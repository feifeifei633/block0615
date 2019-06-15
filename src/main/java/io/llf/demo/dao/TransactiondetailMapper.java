package io.llf.demo.dao;

import io.llf.demo.po.Transactiondetail;

public interface TransactiondetailMapper {
    int deleteByPrimaryKey(Integer txDetailId);

    int insert(Transactiondetail record);

    int insertSelective(Transactiondetail record);

    Transactiondetail selectByPrimaryKey(Integer txDetailId);

    int updateByPrimaryKeySelective(Transactiondetail record);

    int updateByPrimaryKey(Transactiondetail record);
}