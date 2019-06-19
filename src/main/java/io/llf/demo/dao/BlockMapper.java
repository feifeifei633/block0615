package io.llf.demo.dao;

import io.llf.demo.dto.BlockListDTO;
import io.llf.demo.po.Block;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    //zi ding yi
    List<Block> getJustNowBlocks();
}