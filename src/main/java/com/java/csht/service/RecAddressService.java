package com.java.csht.service;

import com.java.csht.mapper.RecAddressMapper;
import com.java.csht.model.RecAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecAddressService {
    @Autowired
    private RecAddressMapper recAddressMapper;

    public List<RecAddress> findAll(){
        List<RecAddress> all = recAddressMapper.findAll();
        return all;
    }

    public RecAddress findById(String id){
        RecAddress byId = recAddressMapper.findById(id);
        return byId;
    }

    public RecAddress findByDefault(Boolean defaultAddress){
        RecAddress byDefault = recAddressMapper.findByDefault(defaultAddress);
        return byDefault;
    }

    public Boolean updateRecAddress(RecAddress recAddress){
        Boolean aBoolean = recAddressMapper.updateRecAddress(recAddress);
        return aBoolean;
    }

    public Boolean updateDefalutAddr(String id,Boolean defaultAddress){
        Boolean aBoolean = recAddressMapper.updateDefalutAddr(id, defaultAddress);
        return  aBoolean;
    }
    public Boolean insertRecAddress(RecAddress recAddress){
        Boolean aBoolean = recAddressMapper.insertRecAddress(recAddress);
        return aBoolean;
    }

    public Boolean deleteAddress(String id){
        Boolean aBoolean = recAddressMapper.deleteAddress(id);
        return aBoolean;
    }
}
