package com.java.csht.service;

import com.java.csht.mapper.AskBuyMapper;
import com.java.csht.model.AskBuy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AskBuyService {
    @Autowired
    private AskBuyMapper askBuyMapper;

    public List<AskBuy> search(String userName, String aName, Integer sortId){
        List<AskBuy> search = askBuyMapper.search(userName, aName, sortId);
        return search;
    }

    public List<AskBuy> findAll(){
        List<AskBuy> all = askBuyMapper.findAll();
        return all;
    }

    public Boolean updateSortName(String sortName, Integer id){
        Boolean aBoolean = askBuyMapper.updateSortName(sortName, id);
        return aBoolean;
    }

    public Boolean deleteAskBuy(String id){
        Boolean aBoolean = askBuyMapper.deleteAskBuy(id);
        return aBoolean;
    }

    public Boolean updateAskBuy(String id, String aName,Integer sortId){
        Boolean aBoolean = askBuyMapper.updateAskBuy(id, aName, sortId);
        return aBoolean;
    }
}
