package com.java.csht.service;

import com.java.csht.mapper.SortMapper;
import com.java.csht.model.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {
    @Autowired
    private SortMapper sortMapper;

    public List<Sort> findAll(){
        List<Sort> all = sortMapper.findAllInfo();
        return all;
    }

    public List<Sort> findBySortName(Sort sort){
        List<Sort> bySortName = sortMapper.findBySortName(sort);
        return bySortName;
    }

    public Boolean updateSortName(String sortName, String id){
        Boolean aBoolean = sortMapper.updateSortName(sortName, id);
        return aBoolean;
    }

    public Boolean insertSort(Sort sort){
        Boolean aBoolean = sortMapper.insertSort(sort);
        return aBoolean;
    }

    public Boolean deleteSort(String id){
        Boolean aBoolean = sortMapper.deleteSort(id);
        return aBoolean;
    }

}
