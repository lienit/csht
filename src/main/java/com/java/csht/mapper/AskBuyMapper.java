package com.java.csht.mapper;

import com.java.csht.model.AskBuy;

public interface AskBuyMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(AskBuy record);

    int insertSelective(AskBuy record);

    AskBuy selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(AskBuy record);

    int updateByPrimaryKey(AskBuy record);
}