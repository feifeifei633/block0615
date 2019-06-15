package io.llf.demo.po;

import java.util.Date;

public class transactions {
    private Integer txid;

    private String txhash;

    private String blockhash;

    private Date time;

    private Double amount;

    private Integer size;

    private Float weight;

    private Integer confirmations;

    private Double totalinput;

    private Double totaloutput;

    private Double fees;

    private Double feeperbyte;

    private Double feeperweightunit;

    private Double btctransacted;

    public Integer getTxid() {
        return txid;
    }

    public void setTxid(Integer txid) {
        this.txid = txid;
    }

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash == null ? null : txhash.trim();
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash == null ? null : blockhash.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Double getTotalinput() {
        return totalinput;
    }

    public void setTotalinput(Double totalinput) {
        this.totalinput = totalinput;
    }

    public Double getTotaloutput() {
        return totaloutput;
    }

    public void setTotaloutput(Double totaloutput) {
        this.totaloutput = totaloutput;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Double getFeeperbyte() {
        return feeperbyte;
    }

    public void setFeeperbyte(Double feeperbyte) {
        this.feeperbyte = feeperbyte;
    }

    public Double getFeeperweightunit() {
        return feeperweightunit;
    }

    public void setFeeperweightunit(Double feeperweightunit) {
        this.feeperweightunit = feeperweightunit;
    }

    public Double getBtctransacted() {
        return btctransacted;
    }

    public void setBtctransacted(Double btctransacted) {
        this.btctransacted = btctransacted;
    }
}