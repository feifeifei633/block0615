package io.llf.demo.po;

public class Transactiondetail {
    private Integer txDetailId;

    private String txhash;

    private String address;

    private Double amount;

    private Byte type;

    public Integer getTxDetailId() {
        return txDetailId;
    }

    public void setTxDetailId(Integer txDetailId) {
        this.txDetailId = txDetailId;
    }

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash == null ? null : txhash.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}