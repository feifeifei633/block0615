package io.llf.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BitcionService {

    void synchronizeBlock(String hash);

    void synchronizenTx(JSONObject jsonObject, String hash, Date datetime,Integer confirmations);


    void synchronizenTxDetail(JSONObject jsonObject);

    void synchronizenTxDetailVout(JSONArray vout);

    void  synchronizenTxDetailVin(JSONArray vin);

    void  synchronizenTxAmount(JSONObject jsonObject);
}
