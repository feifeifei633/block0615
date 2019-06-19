package io.llf.demo.dao;

import io.llf.demo.po.Transactions;

public interface TransactionsMapper {
    int deleteByPrimaryKey(Integer txid);

    int insert(Transactions record);

    int insertSelective(Transactions record);

    Transactions selectByPrimaryKey(Integer txid);

    int updateByPrimaryKeySelective(Transactions record);

    int updateByPrimaryKey(Transactions record);
}