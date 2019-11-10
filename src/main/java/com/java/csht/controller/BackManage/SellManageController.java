package com.java.csht.controller.BackManage;

import com.java.csht.model.Sell;
import com.java.csht.model.Sort;
import com.java.csht.model.User;
import com.java.csht.service.SellService;
import com.java.csht.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SellManageController {
    @Autowired
    private SellService sellService;

    @Autowired
    private SortService sortService;



    @RequestMapping("/sellManage")
    public ModelAndView SellManage(){
        List<Sell> all = sellService.findAll();

        List<Sort> sortList = sortService.findAll();
        System.out.println(all);
        for (Sell sell :all){
            User user = sell.getUser();
            Sort sort = sell.getSort();

            sell.setUsername(user.getUsername());
            if (!sell.getSortname().equals(sort.getCname())){
                sellService.updateSortName(sort.getCname(), sell.getSid());
                sell.setSortname(sort.getCname());
            }

        }

//        System.out.println(all);

        ModelAndView modelAndView = new ModelAndView("backManage/sellManage");
        modelAndView.addObject("sellList", all);
        modelAndView.addObject("sortList", sortList);
        return modelAndView;
    }

    @PostMapping("/backManageFind")
    @ResponseBody
    public List<Sell> BackManagefind(String userName, String sName, Float minPrice, Float maxPrice, Integer sortId){
        System.out.println(sortId);
        List<Sell> sells = sellService.BackManagefind(userName,sName,minPrice,maxPrice,sortId);
        return sells;
    }


    @PostMapping("/deleteSell")
    @ResponseBody
    public String DeleSell(String opt){
        String[] split = opt.split(",");
        List<String> sellId = new ArrayList<>();
        for (String id : split){
            sellId.add(id);
        }
        for (int i = 0; i < sellId.size(); i++){
            sellService.deleteSell(sellId.get(i));
        }
        return "sueecss";
    }

    @PostMapping("/updateSell")
    @ResponseBody
    public String UpdateSell(String id,String rawcName, String sortName, String sellName){
        String[] IdArr = id.split(",");
        String[] rawNameArr = rawcName.split(",");
        String[] sortNameArr = sortName.split(",");
        String[] sellNameArr = sellName.split(",");

        String message = "success";

        for (int i = 0; i < IdArr.length; i++ ){
            if (!sortNameArr[i].equals("")){
                Sort sort = new Sort();
                int sortId1 = Integer.parseInt(sortNameArr[i]);
                sort.setId(sortId1);
                List<Sort> bySortName = sortService.findBySortName(sort);
                sort = bySortName.get(0);
                Integer sortId2 = sort.getId();
                sellService.updateSell(IdArr[i], sellNameArr[i], sortId2);
            }else {
                message = "error";
            }

        }

        return message;
    }
}
