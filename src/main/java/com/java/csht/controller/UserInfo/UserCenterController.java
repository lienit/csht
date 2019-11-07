package com.java.csht.controller.UserInfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.java.csht.model.RecAddress;
import com.java.csht.model.User;
import com.java.csht.service.RecAddressService;
import com.java.csht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class UserCenterController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecAddressService recAddressService;

    @Value("${app.upload.location}")
    private String path;

    @RequestMapping("/userdata")
    public ModelAndView UserData(String id) throws ParseException {
        ModelAndView modelAndView = new ModelAndView("userCenter/userData");
        User user = userService.findById(id);
        String realname = user.getRealname();
        if (!realname.equals("")) {
            String substring = realname.substring(0, 1);
            Integer namelength = realname.length() - 1;
            String count = "";
            for (int i = 0; i < namelength; i++) {
                count += "*";
            }
            realname = substring + count;
            user.setRealname(realname);
        }
        String[] split = user.getAddress().split("-");
        String province = split[0];
        String city = split[1];

        modelAndView.addObject("user", user);
        modelAndView.addObject("province", province);
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/edituserdata")
    @ResponseBody
    public String EditUserData(@Valid User user, BindingResult resultError) throws IOException {
        if (user.getRealname().indexOf("*") != -1) {
            String username = user.getUsername();
            User byUserName = userService.findByUserName(username);
            String realname = byUserName.getRealname();
            user.setRealname(realname);

        }



        Boolean aBoolean = userService.UpdateByUserName(user);
        if (aBoolean) {
            return "success";
        }
        return "error";
    }

    @PostMapping("/imgupload")
    @ResponseBody
    public String ImgUpload(@RequestParam(value = "file") MultipartFile photo, String username, HttpServletRequest request) throws Exception {
        User user = userService.findByUserName(username);
        String userPhoto = user.getPhoto();

        String filenameTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        String[] split = filenameTime.split("-");
        String filename = photo.getOriginalFilename();

        String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
        BufferedImage bi = ImageIO.read(photo.getInputStream());
        Boolean succeed = true;
        if (bi == null) {
            succeed = false;
        }

        String uuid = UUID.randomUUID().toString();
        String filePath = "userPhoto" + "/" + split[0] + "/" + split[1] + "/" + split[2];
        File file = new File(path + filePath);
        if (!file.exists()) {
            boolean mkdir = file.mkdirs();
            System.out.println(mkdir);
        }

        System.out.println(userPhoto);
        filename = filePath + "/" + uuid + username + filename;
        File file1 = new File(path + filename);
        if (!userPhoto.equals("")) {

            File file2 = new File(path + userPhoto);
            file2.delete();
        }
        if (bi != null) {
            photo.transferTo(file1);
        }
        String photofile = "/uploads/" + filename;

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("paths", photofile);
        jsonObject.put("succeed", succeed);
        String json = JSON.toJSONString(jsonObject);
        System.out.println(json);
        return json;
    }

    @RequestMapping("/useraddress")
    public ModelAndView UserAddress(String id) {
        User user = userService.findById(id);
        List<RecAddress> recAddress = recAddressService.findAll();
        Integer count = recAddress.size();
        ModelAndView modelAndView = new ModelAndView("userCenter/userAddress");
        modelAndView.addObject("user", user);
        modelAndView.addObject("recAddress", recAddress);
        modelAndView.addObject("count", count);
        return modelAndView;
    }

    @PostMapping("/addrecaddress")
    @ResponseBody
    public String AddRecAddress(RecAddress recAddress, String defaultAddr, Integer id) {
        List<RecAddress> recAddressList = recAddressService.findAll();
        if (recAddressList.size() <= 20) {
            if (defaultAddr.equals("1")) {
                RecAddress byDefault = recAddressService.findByDefault(true);
                if(byDefault!=null){
                    byDefault.setDefaultAddress(false);
                    recAddressService.updateRecAddress(byDefault);
                }
                recAddress.setDefaultAddress(true);
            } else {
                recAddress.setDefaultAddress(false);
            }
            Boolean aBoolean = recAddressService.insertRecAddress(recAddress);
            if (aBoolean) {
                return "success";
            }

        }
        return "error";
    }

    @GetMapping("/setdefault")
    public String setDefault(String userId,String addressId){
        RecAddress byDefault = recAddressService.findByDefault(true);
        if (byDefault!=null){
            byDefault.setDefaultAddress(false);
            recAddressService.updateRecAddress(byDefault);
        }
        Boolean aBoolean = recAddressService.updateDefalutAddr(addressId, true);

        return "redirect:/useraddress?id="+userId;
    }

    @RequestMapping("/deleteaddr")
    public String DeleteAddress(String userId,String addressId){
        recAddressService.deleteAddress(addressId);
        return "redirect:/useraddress?id="+userId;
    }

    @RequestMapping("/findbyidaddress")
    @ResponseBody
    public RecAddress FindByIdAddress(String userId,String addressId){
        RecAddress byId = recAddressService.findById(addressId);
        return byId;
    }

    @PostMapping("/editaddress")
    @ResponseBody
    public String EditAddress(RecAddress recAddress, String defaultAddr, Integer userId){
        if (defaultAddr.equals("1")) {
            RecAddress byDefault = recAddressService.findByDefault(true);

            if(byDefault!=null){
                byDefault.setDefaultAddress(false);
                recAddressService.updateRecAddress(byDefault);
            }
            recAddress.setDefaultAddress(true);
        } else {
            recAddress.setDefaultAddress(false);
        }

        Boolean aBoolean = recAddressService.updateRecAddress(recAddress);
        System.out.println(aBoolean);
        if (aBoolean) {
            return "success";
        }
        return "error";
    }
}
