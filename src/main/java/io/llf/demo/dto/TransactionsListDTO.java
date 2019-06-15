package io.llf.demo.dto;

import java.util.Date;

public class TransactionsListDTO {

    private String blockhash;

    private Date time;

    private Double amounte;

    private Double amountu;


    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getAmounte() {
        return amounte;
    }

    public void setAmounte(Double amounte) {
        this.amounte = amounte;
    }

    public Double getAmountu() {
        return amountu;
    }

    public void setAmountu(Double amountu) {
        this.amountu = amountu;
    }
}
