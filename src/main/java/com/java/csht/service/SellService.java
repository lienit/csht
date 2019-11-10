package com.java.csht.service;

import com.java.csht.mapper.SellMapper;
import com.java.csht.model.Sell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellService {
    @Autowired
    private SellMapper sellMapper;

    public List<Sell> findAll(){
        List<Sell> all = sellMapper.findAll();
        return all;
    }

    public List<Sell> BackManagefind(String userName,String sName, Float minPrice,Float maxPrice,Integer sortId){
        List<Sell> sells = sellMapper.BackManagefind(userName,sName,minPrice,maxPrice,sortId);
        System.out.println(sells);
        return sells;
    }

    public Boolean deleteSell(String id){
        Boolean aBoolean = sellMapper.deleteSell(id);
        return aBoolean;
    }

    public Boolean updateSell(String id, String sellName,Integer sortId){
        Boolean aBoolean = sellMapper.updateSell(id, sellName, sortId);
        return aBoolean;
    }

    public Boolean updateSortName(String sortName,Integer id){
        Boolean aBoolean = sellMapper.updateSortName(sortName, id);
        return aBoolean;
    }

}
