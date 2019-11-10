package com.java.csht.mapper;

import com.java.csht.model.Sort;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Repository
@Transactional(rollbackFor = Exception.class)
public interface SortMapper {
    public List<Sort> findAllInfo();

    @Select("select * from sort where id = #{id}")
    public List<Sort> findBySortName(Sort sort);

    @Insert("insert into sort(cName) values(#{cname})")
    public Boolean insertSort(Sort sort);

    @Delete("delete from sort where id = #{id}")
    public Boolean deleteSort(String id);

    @Update("update sort  set cName=#{sortName} where id = #{id}")
    public Boolean updateSortName(String sortName,String id);
}