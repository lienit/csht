package com.java.csht.mapper;

import com.java.csht.model.Sell;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Repository
@Transactional(rollbackFor = Exception.class)
public interface SellMapper {
    public List<Sell> findAll();

    public List<Sell> BackManagefind(String userName,String sName,Float minPrice, Float maxPrice,Integer sortId);

    @Delete("delete from sell where sid = #{id}")
    public Boolean deleteSell(String id);

    @Update("update sell set sName=#{sellName},sortId=#{sortId} where sid = #{id}")
    public Boolean updateSell(String id, String sellName,Integer sortId);

    @Update("update sell set sortName = #{sortName} where sid= #{id}")
    public Boolean updateSortName(String sortName,Integer id);

}