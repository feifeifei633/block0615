package io.llf.demo.po;

import java.util.Date;

public class Block {
    private Integer bid;

    private String blockhash;

    private Integer height;

    private Date time;

    private Short txsize;

    private Integer size;

    private Double difficulty;

    private Float weight;

    private String miner;

    private String version;

    private Integer nonce;

    private String previousblock;

    private String nextblock;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash == null ? null : blockhash.trim();
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Short getTxsize() {
        return txsize;
    }

    public void setTxsize(Short txsize) {
        this.txsize = txsize;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner == null ? null : miner.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getNonce() {
        return nonce;
    }

    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }

    public String getPreviousblock() {
        return previousblock;
    }

    public void setPreviousblock(String previousblock) {
        this.previousblock = previousblock == null ? null : previousblock.trim();
    }

    public String getNextblock() {
        return nextblock;
    }

    public void setNextblock(String nextblock) {
        this.nextblock = nextblock == null ? null : nextblock.trim();
    }
}