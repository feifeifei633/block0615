package io.llf.demo.dao;

import io.llf.demo.po.Block;

public interface BlockMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);
}