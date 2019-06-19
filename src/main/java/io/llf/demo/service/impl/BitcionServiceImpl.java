package io.llf.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.llf.demo.api.BlockApi;
import io.llf.demo.dao.BlockMapper;
import io.llf.demo.dao.TransactiondetailMapper;
import io.llf.demo.dao.TransactionsMapper;
import io.llf.demo.dto.TransactionsGetDTO;
import io.llf.demo.po.Block;
import io.llf.demo.po.Transactiondetail;
import io.llf.demo.po.Transactions;
import io.llf.demo.service.BitcionService;
import org.apache.ibatis.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;

@Service
public class BitcionServiceImpl implements BitcionService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BlockApi blockApi;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionsMapper transactionsMapper;

    @Autowired
    private TransactiondetailMapper transactiondetailMapper;

    @Override
    @Async
    @Transactional
    public void synchronizeBlock(String hash) {
        logger.info("开始同步", hash);
        String bitcoinhash =hash;
        while (bitcoinhash != null && !bitcoinhash.isEmpty()){
            JSONObject blockJson = blockApi.getBlock(bitcoinhash);
            Block block = new Block();
            block.setBlockhash(blockJson.getString("hash"));
            block.setHeight(blockJson.getInteger("height"));
            Long time = blockJson.getLong("time");
            Date datetime = new Date(time * 1000);
            block.setTime(datetime);
            block.setTxsize(blockJson.getShort("nTx"));
            block.setSize(blockJson.getInteger("size"));
            block.setWeight(blockJson.getFloat("weight"));
            block.setDifficulty(blockJson.getDouble("difficulty"));
            block.setPreviousblock(blockJson.getString("previousblockhash"));
            block.setNextblock(blockJson.getString("nextblockhash"));
            Integer confirmations = blockJson.getInteger("confirmations");
            blockMapper.insert(block);

            JSONArray tx = blockJson.getJSONArray("tx");

            for (Object object : tx) {
                JSONObject jsonObject = new JSONObject((LinkedHashMap) object);
                synchronizenTx(jsonObject, hash, datetime, confirmations);
            }

            bitcoinhash = block.getNextblock();
        }
        logger.info("同步结束");
    }

    @Override
    @Transactional
    @Async
    public void synchronizenTx(JSONObject jsonObject, String hash, Date datetime, Integer confirmations) {
        Transactions transactions = new Transactions();
        transactions.setTxhash(jsonObject.getString("txid"));
        transactions.setBlockhash(hash);
        transactions.setTime(datetime);
        transactions.setSize(jsonObject.getInteger("size"));
        transactions.setWeight(jsonObject.getFloat("weight"));
        transactions.setConfirmations(confirmations);
        transactionsMapper.insert(transactions);

        //todo set txdetail
        synchronizenTxDetail(jsonObject);

        //todo set amount
        synchronizenTxAmount(jsonObject);
    }

    @Override
    @Transactional
    @Async
    public void synchronizenTxDetail(JSONObject jsonObject) {
        JSONArray vout = jsonObject.getJSONArray("vout");
        synchronizenTxDetailVout(vout);
        JSONArray vin = jsonObject.getJSONArray("vin");
        synchronizenTxDetailVin(vin);
    }

    @Override
    public void synchronizenTxDetailVout(JSONArray vout) {
        for (Object vouts : vout) {
            Transactiondetail transactiondetail = new Transactiondetail();
            JSONObject jsonObject = new JSONObject((LinkedHashMap) vouts);
            transactiondetail.setAddress(jsonObject.getJSONObject("scriptPubKey").getString("addresses"));
            transactiondetail.setTxDetailId(jsonObject.getJSONObject("scriptPubKey").getInteger("reqSigs"));
            transactiondetail.setType(jsonObject.getJSONObject("scriptPubKey").getByte("type"));
            transactiondetailMapper.insert(transactiondetail);
        }
    }

    @Override
    public void synchronizenTxDetailVin(JSONArray vin) {

    }

    @Override
    public void synchronizenTxAmount(JSONObject jsonObject) {

    }


}
