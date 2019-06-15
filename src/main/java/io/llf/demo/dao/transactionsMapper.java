package io.llf.demo.dao;

import io.llf.demo.po.transactions;

public interface transactionsMapper {
    int deleteByPrimaryKey(Integer txid);

    int insert(transactions record);

    int insertSelective(transactions record);

    transactions selectByPrimaryKey(Integer txid);

    int updateByPrimaryKeySelective(transactions record);

    int updateByPrimaryKey(transactions record);
}