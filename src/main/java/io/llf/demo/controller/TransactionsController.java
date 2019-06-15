package io.llf.demo.controller;

import io.llf.demo.dto.TransactionsGetDTO;
import io.llf.demo.dto.TransactionsListDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionsController {


    @GetMapping("/getTransactions")
    public List<TransactionsGetDTO> getTransactions(){
        TransactionsGetDTO transactionsGetDTO = new TransactionsGetDTO();

        Date now = new Date();
        SimpleFormatter dateFormat = new SimpleFormatter();
        transactionsGetDTO.setTime(new Date());
    }
}
