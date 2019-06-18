package io.llf.demo.api;

import com.alibaba.fastjson.JSONObject;

public interface BlockRpcClientAPI {

    String getBestblockhash() throws Throwable;

    String getHeight(Integer height) throws Throwable;

    Double getBalance(String address) throws Throwable;

    JSONObject getAddressInfo(String address) throws Throwable;

    JSONObject getRawTransaxtion(String txid) throws Throwable;
}
