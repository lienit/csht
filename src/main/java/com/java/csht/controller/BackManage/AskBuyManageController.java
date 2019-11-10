package com.java.csht.controller.BackManage;

import com.java.csht.model.AskBuy;
import com.java.csht.model.Sort;
import com.java.csht.model.User;
import com.java.csht.service.AskBuyService;
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
public class AskBuyManageController {
    @Autowired
    private AskBuyService askBuyService;

    @Autowired
    private SortService sortService;

    @RequestMapping("/askBuyManage")
    public ModelAndView AskBuyManage(){
        List<AskBuy> all = askBuyService.findAll();

        List<Sort> sortList = sortService.findAll();
        System.out.println(all);
        for (AskBuy askBuy : all){
            User user = askBuy.getUser();
            Sort sort = askBuy.getSort();
            askBuy.setUsername(user.getUsername());
            if (!askBuy.getSortname().equals(sort.getCname())){
                askBuyService.updateSortName(sort.getCname(), askBuy.getAid());
                askBuy.setSortname(sort.getCname());
            }
        }
        ModelAndView modelAndView = new ModelAndView("backManage/askBuyManage");
        modelAndView.addObject("askBuyList", all);
        modelAndView.addObject("sortList", sortList);
        return modelAndView;
    }

    @PostMapping("/searchAskBuy")
    @ResponseBody
    public List<AskBuy> SearchAskBuy(String userName, String aName, Integer sortId){
        List<AskBuy> search = askBuyService.search(userName, aName, sortId);
        return search;
    }


    @PostMapping("/deleteAskBuy")
    @ResponseBody
    public String deleteAskBuy(String opt){
        String[] split = opt.split(",");
        List<String> sellId = new ArrayList<>();
        for (String id : split){
            sellId.add(id);
        }
        for (int i = 0; i < sellId.size(); i++){
            askBuyService.deleteAskBuy(sellId.get(i));
        }
        return "sueecss";
    }

    @PostMapping("/updateAskBuy")
    @ResponseBody
    public String updateAskBuy(String id,String rawcName, String sortName, String askBuyName){
        String[] IdArr = id.split(",");
        String[] rawNameArr = rawcName.split(",");
        String[] sortNameArr = sortName.split(",");
        String[] askBuyNameArr = askBuyName.split(",");
        String message = "success";
        for (int i = 0; i < IdArr.length; i++ ){
            if (!sortNameArr[i].equals("")){
                System.out.println("a");
//                Sort sort = new Sort();
//                int sortId1 = Integer.parseInt(sortNameArr[i]);
//                sort.setId(sortId1);
//                List<Sort> bySortName = sortService.findBySortName(sort);
//                sort = bySortName.get(0);
//                Integer sortId2 = sort.getId();
//                askBuyService.updateAskBuy(IdArr[i], askBuyNameArr[i], sortId2);
            }else {
                message = "error";
            }
        }


        return message;

    }
}
