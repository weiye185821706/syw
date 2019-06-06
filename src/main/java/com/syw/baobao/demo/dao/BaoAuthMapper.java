package com.syw.baobao.demo.dao;

import com.syw.baobao.demo.entiy.BaoAuth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BaoAuthMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(BaoAuth record);

    BaoAuth selectByPrimaryKey(BaoAuth baoAuth);

    List<BaoAuth> selectAll();

    int updateByPrimaryKey(BaoAuth record);
}