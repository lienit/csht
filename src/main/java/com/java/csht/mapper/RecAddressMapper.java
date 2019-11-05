package com.java.csht.mapper;

import com.java.csht.model.RecAddress;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface RecAddressMapper {
    @Select("select * from recaddress ORDER BY defaultAddress desc")
    public List<RecAddress> findAll();

    @Select("select * from recaddress where id =#{id}")
    public RecAddress findById(String id);

    @Select("select * from recaddress where defaultAddress=#{defaultAddress}")
    public RecAddress findByDefault(Boolean defaultAddress);

    @Update("update recaddress set consignee=#{consignee},incampus=#{incampus},dataAddress=#{dataaddress}, mobile=#{mobile},defaultAddress=#{defaultAddress} where id=#{id}")
    public Boolean updateRecAddress(RecAddress recAddress);

    @Update("update recAddress set defaultAddress=#{defaultAddress} where id = #{id}")
    public Boolean updateDefalutAddr(String id,Boolean defaultAddress);

    @Insert("insert into recAddress(consignee,incampus,dataAddress,mobile,defaultAddress) values(#{consignee},#{incampus},#{dataaddress},#{mobile},#{defaultAddress})")
    public Boolean insertRecAddress(RecAddress recAddress);

    @Delete("delete from recAddress where id = #{id}")
    public Boolean deleteAddress(String id);
}