package io.llf.demo.dto;

import java.util.Date;

public class BlockGetDTO {
    private String blockhash;
    private Integer height;
    private String previousblock;
    private String nextblock;
    private Short txsize;
    private Double difficulty;
    private Long time;
    private Integer size;

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPreviousblock() {
        return previousblock;
    }

    public void setPreviousblock(String previousblock) {
        this.previousblock = previousblock;
    }

    public String getNextblock() {
        return nextblock;
    }

    public void setNextblock(String nextblock) {
        this.nextblock = nextblock;
    }

    public Short getTxsize() {
        return txsize;
    }

    public void setTxsize(Short txsize) {
        this.txsize = txsize;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
