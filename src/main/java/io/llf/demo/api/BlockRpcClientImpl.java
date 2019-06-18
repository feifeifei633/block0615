package io.llf.demo.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpAsyncClient;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@Service
public class BlockRpcClientImpl implements BlockRpcClientAPI{
    private JsonRpcHttpClient jsonRpcHttpClient;

    public BlockRpcClientImpl() throws MalformedURLException {
        HashMap<String, String> hashMap = new HashMap<>();

        String authorOig = String.format("%s:%s","cjf","123456");
        String author = Base64.getEncoder().encodeToString(authorOig.getBytes());
        String authorResult = String.format("Basic %s",author);
        hashMap.put("Authorization",authorResult);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL("http://localhost:18332\""),hashMap);
    }

    @Override
    public String getBestblockhash() throws Throwable {
        String blockhash = jsonRpcHttpClient.invoke("getbestblockhash",null, String.class);

        return blockhash;
    }

    @Override
    public String getHeight(Integer height) throws Throwable {
        String blockhash = jsonRpcHttpClient.invoke("getblockhash", new Integer[]{height}, String.class);

        return blockhash;
    }

    @Override
    public Double getBalance(String address) throws Throwable {
        JSONArray balances = jsonRpcHttpClient.invoke("listunspent", new Object[]{6, 9999999}, JSONArray.class);

        JSONObject balance = balances.getJSONObject(1);

        Double amount = balance.getDouble("amount");

        return amount;
    }

    @Override
    public JSONObject getAddressInfo(String address) throws Throwable {
        JSONObject blockhash = jsonRpcHttpClient.invoke("getaddressinfo", new String[]{address}, JSONObject.class);

        return blockhash;
    }

    @Override
    public JSONObject getRawTransaxtion(String txid) throws Throwable {
        JSONObject rawTransaction = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txid, true}, JSONObject.class);

        return rawTransaction;
    }
}
