package com.java.csht.mapper;

import com.java.csht.model.AskBuy;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Repository
@Transactional(rollbackFor = Exception.class)
public interface AskBuyMapper {
    public List<AskBuy> findAll();

    public List<AskBuy> search(String userName, String aName, Integer sortId);

    @Update("update askbuy set sortName = #{sortName} where aid = #{id}")
    public Boolean updateSortName(String sortName,Integer id);

    @Delete("delete from askbuy where aid = #{id} ")
    public Boolean deleteAskBuy(String id);

    @Update("update askBuy set aName = #{aName},sortId = #{sortId} where aid = #{id}")
    public Boolean updateAskBuy(String id, String aName,Integer sortId);
}