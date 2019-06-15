package io.llf.demo.controller;

import io.llf.demo.dto.TransactionsGetDTO;
import io.llf.demo.dto.TransactionsListDTO;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionsController {


    @GetMapping("/getTransactions")
    public List<TransactionsGetDTO> getTransactions() throws ParseException {
        List<TransactionsGetDTO> list = new ArrayList<>();
        TransactionsGetDTO transactionsGetDTO = new TransactionsGetDTO();

        String datestr = "2019-06-15 14:55:10";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        SimpleFormatter dateFormat = new SimpleFormatter();
        transactionsGetDTO.setTime(sdf.parse(datestr));
        transactionsGetDTO.setAmounte(0.12000000);
        transactionsGetDTO.setAmountu(31.89);
        transactionsGetDTO.setBlockhash("0x001602d970831791dfee74891487805f441d4d25581fadc90a1b6ff06c5a5795");
        list.add(transactionsGetDTO);

        TransactionsGetDTO transactionsGetDTO1 = new TransactionsGetDTO();

        String datestr1 = "2019-06-15 14:55:10";
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now1 = new Date();
        SimpleFormatter dateFormat1 = new SimpleFormatter();
        transactionsGetDTO1.setTime(sdf.parse(datestr));
        transactionsGetDTO1.setAmounte(0.46000000);
        transactionsGetDTO1.setAmountu(122.74);
        transactionsGetDTO1.setBlockhash("0x056b38709539e60dea00c8dec89f2546ea3f57a1b48f992deac871f3c11d4117");
        list.add(transactionsGetDTO);


        return list;
    }
}
