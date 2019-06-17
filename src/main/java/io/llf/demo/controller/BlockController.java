package io.llf.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.llf.demo.api.BlockApi;
import io.llf.demo.dto.BlockGetDTO;
import io.llf.demo.dto.BlockListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/block")
@EnableAutoConfiguration
public class BlockController {

    @Autowired
    private BlockApi blockApi;

    @GetMapping("/getTransaction")
    public JSONObject getTransaction(){
        return blockApi.getTransaction("0000000000000000001b7a59574f4940c89b1e3f04a1e440276044878e580370");
    }

    @GetMapping("/getBlock")
    public JSONObject getBlock(){
        return blockApi.getBlock("0000000024224c12fd9cc28e17b7eb5cd08645324e209ef48b95625d7aa260d9");
    }

    @GetMapping("/getBlockHeaders")
    public JSONArray getBlockHeaders(){
        return blockApi.getBlockHeaders(5,"0000000024224c12fd9cc28e17b7eb5cd08645324e209ef48b95625d7aa260d9");
    }

    @GetMapping("/getCount")
    public JSONObject getCount(){
        return blockApi.getCount("0000000024224c12fd9cc28e17b7eb5cd08645324e209ef48b95625d7aa260d9");
    }

    @GetMapping("/getChainInfos")
    public JSONObject getChainInfos(){
        return blockApi.getChainInfos();
    }

    @GetMapping("/getCheckmempool")
    public JSONObject getCheckmempool(){
        return blockApi.getCheckmempool("0000000024224c12fd9cc28e17b7eb5cd08645324e209ef48b95625d7aa260d9");
    }

    @GetMapping("/getMempoolContents")
    public JSONObject getMempoolInfo(){
        return blockApi.getMempoolInfo();
    }

    @GetMapping("/getMempoolInfo")
    public JSONObject getMempoolContents(){
        return blockApi.getMempoolContents();
    }

    @GetMapping("/getByHeight")
    public BlockGetDTO getByHeight(@RequestParam Integer height){

//ssssss
        BlockGetDTO blockGetDTO = new BlockGetDTO();

        blockGetDTO.setBlockhash("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");

        blockGetDTO.setHeight(580769);

        blockGetDTO.setPreviousblock("00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd");

        blockGetDTO.setNextblock("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");

        blockGetDTO.setTime(new Date().getTime());


        blockGetDTO.setSize(1773);

        blockGetDTO.setDifficulty(7409399249090.25);

        return blockGetDTO;
    }

    @GetMapping("/getByBlockhash")
    public BlockGetDTO getByBlockhash(@RequestParam String getByBlockhash){

        BlockGetDTO blockGetDTO = new BlockGetDTO();

        blockGetDTO.setBlockhash("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");

        blockGetDTO.setHeight(580769);

        blockGetDTO.setPreviousblock("00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd");

        blockGetDTO.setNextblock("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");


        blockGetDTO.setTime(new Date().getTime());


        blockGetDTO.setSize(1773);

        blockGetDTO.setDifficulty(7409399249090.25);



        return blockGetDTO;

    }

    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks(){

        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();



        BlockListDTO blockListDTO = new BlockListDTO();

        blockListDTO.setBlockhash("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");

        blockListDTO.setHeight(580769);

        blockListDTO.setTime(new Date().getTime());

        blockListDTO.setTxsize((short) 2390);

        blockListDTO.setSize(1773);

        blockListDTOS.add(blockListDTO);



        BlockListDTO blockListDTO2 = new BlockListDTO();

        blockListDTO2.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");

        blockListDTO2.setHeight(580643);

        blockListDTO2.setTime(new Date().getTime());

        blockListDTO2.setTxsize((short) 2702);

        blockListDTO2.setSize(1322496);

        blockListDTOS.add(blockListDTO2);



        return blockListDTOS;

    }


}
