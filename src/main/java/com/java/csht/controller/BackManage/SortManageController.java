package com.java.csht.controller.BackManage;

import com.java.csht.model.Sell;
import com.java.csht.model.Sort;
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
public class SortManageController {
    @Autowired
    private SortService sortService;

    @RequestMapping("/sortManage")
    public ModelAndView SortManage(){
        List<Sort> all = sortService.findAll();
        for (Sort sort : all){
            List<Sell> sells = sort.getSells();
        }
        System.out.println(all);
        ModelAndView modelAndView = new ModelAndView("backManage/sortManage");
        modelAndView.addObject("SortList",all);
        return modelAndView;
    }



    //新增类别
    @PostMapping("/addsort")
    @ResponseBody
    public String AddSort(Sort sort){
        List<Sort> bySortName = sortService.findBySortName(sort);
        if (bySortName.size() == 0){
            Boolean aBoolean = sortService.insertSort(sort);
            if (aBoolean){
                return "sueecss";
            }else{
                return "fault";
            }
        }else {
            return "error";
        }
    }

    @PostMapping("/delesort")
    @ResponseBody
    public String DeleSort(String opt){
        String[] split = opt.split(",");
        List<String> sortId = new ArrayList<>();
        for (String id : split){
            sortId.add(id);
        }
        for (int i = 0; i < sortId.size(); i++){
            sortService.deleteSort(sortId.get(i));
        }
        return "sueecss";
    }

    @PostMapping("/updatesortname")
    @ResponseBody
    public String UpdateSortName(String cname,String id,String rawcName){
        String[] SortNameArr = cname.split(",");
        String[] IdArr = id.split(",");
        String[] rawNameArr = rawcName.split(",");
        List<Integer> timeList = new ArrayList<>();

        Sort sort = new Sort();
        for (int i = 0; i < IdArr.length; i++){
            if (!rawNameArr[i].equals(SortNameArr[i])){
                sort.setCname(SortNameArr[i]);
                List<Sort> bySortName = sortService.findBySortName(sort);

                timeList.add(bySortName.size());
            }else {
                timeList.add(0);
            }
        }
        String massage = "success";

        for (int i = 0; i < IdArr.length; i++){
            if (timeList.get(i)!=1){
                sortService.updateSortName(SortNameArr[i],IdArr[i]);
            }else {
                massage =  SortNameArr[i];
            }
        }
        return massage;
    }

}
