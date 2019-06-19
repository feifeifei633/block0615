package io.llf.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BitcionService {

    void synchronizeBlock(String hash) throws Throwable;

    void synchronizenTx(JSONObject jsonObject, String hash, Date datetime,Integer confirmations) throws Throwable;


    void synchronizenTxDetail(JSONObject jsonObject,String txid) throws Throwable;

    void synchronizenTxDetailVout(JSONArray vout,String txid);

    void  synchronizenTxDetailVin(JSONArray vin,String txid) throws Throwable;

    void  synchronizenTxAmount(JSONObject jsonObject);
}
