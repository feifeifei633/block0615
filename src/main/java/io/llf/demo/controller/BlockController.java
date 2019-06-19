package io.llf.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.llf.demo.api.BlockApi;
import io.llf.demo.api.BlockRpcClientAPI;
import io.llf.demo.api.BlockRpcClientImpl;
import io.llf.demo.dto.BlockGetDTO;
import io.llf.demo.dto.BlockListDTO;
import io.llf.demo.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/block")
@EnableAutoConfiguration
@EnableAsync
public class BlockController {

    @Autowired
    private BlockApi blockApi;

    @Autowired
    private BlockRpcClientAPI blockRpcClientAPI;

    @Autowired
    private BlockService blockService;

    @GetMapping("/getJustNowBlocks")
    public List<BlockListDTO> getJustNowBlocks(){
        List<BlockListDTO> blockListDTOList = blockService.getJustNowBlocks();
        return blockListDTOList;
    }

    @GetMapping("/getBlockHeader")
    public BlockGetDTO getBlockHeader(@RequestParam String hash){
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("00000000000000add3a8881e17fa7bab9a8c31f8e90ba04ef17be8ef9d2754f8");
        blockGetDTO.setHeight(1381602);
        blockGetDTO.setPreviousblock("00000000000000729201dae009ad242cba9994d31eda602417bcea99bead69a3");
        blockGetDTO.setNextblock("0000000000000036152b19dc6e1e36f292126f4aa1c5997c68b0a967e9bbe15f");
        blockGetDTO.setTxsize((short)2870);
        blockGetDTO.setDifficulty(17349304.92883517);
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setSize(817042);

        return blockGetDTO;
    }

    @GetMapping("/getBlockHash")
    public BlockGetDTO getBlockHash(@RequestParam Integer height){
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("00000000000000add3a8881e17fa7bab9a8c31f8e90ba04ef17be8ef9d2754f8");
        blockGetDTO.setHeight(1381602);
        blockGetDTO.setPreviousblock("00000000000000729201dae009ad242cba9994d31eda602417bcea99bead69a3");
        blockGetDTO.setNextblock("0000000000000036152b19dc6e1e36f292126f4aa1c5997c68b0a967e9bbe15f");
        blockGetDTO.setTxsize((short)2870);
        blockGetDTO.setDifficulty(17349304.92883517);
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setSize(817042);

        return blockGetDTO;
    }



    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks() throws Throwable {

        List<BlockListDTO> blockListDTOS = new ArrayList<>();

        JSONObject blockChainInfo = blockApi.getMempoolInfo();

        Integer blockHeight = blockChainInfo.getInteger("blocks");

        Integer blockFromHeight = blockHeight - 5;

        String blockhash = blockRpcClientAPI.getHeight(blockFromHeight);

        List<JSONObject> blockHeaders = blockApi.getBlockHeaders(5,blockhash);

        for(Object blockHeader : blockHeaders){

            JSONObject jsonObject = (JSONObject) blockHeader;

            BlockListDTO blockListDTO = new BlockListDTO();

            blockListDTO.setHeight(jsonObject.getInteger("height"));

            Long time = jsonObject.getLong("time");

            blockListDTO.setTime(new Date(1000*time).getTime());


            blockListDTO.setBlockhash(jsonObject.getString("hash"));

            blockListDTO.setTxsize(jsonObject.getShort("nTx"));

            blockListDTO.setSize(null);

            blockListDTOS.add(blockListDTO);

        }

        return blockListDTOS;

    }

    @GetMapping("/getblockByHeight")
    public BlockGetDTO getblockByHeight(@RequestParam Integer Blockheight) throws Throwable {

        BlockGetDTO blockGetDTO = new BlockGetDTO();

        String blockhash = blockRpcClientAPI.getHeight(Blockheight);

        JSONObject block = blockApi.getBlock(blockhash);

        blockGetDTO.setBlockhash(blockhash);


        blockGetDTO.setSize(block.getInteger("size"));

        blockGetDTO.setTime(block.getLong("time"));

        blockGetDTO.setTxsize(block.getShort("nTx"));

        blockGetDTO.setNextblock(block.getString("nextblockhash"));

        blockGetDTO.setPreviousblock(block.getString("previousblockhash"));

        return blockGetDTO;

    }
//----------------
    @GetMapping("/getBestblockHash")
    public String getBestblockhash() throws Throwable {
        return blockRpcClientAPI.getBestblockhash();
    }

    @GetMapping("/getHeight")
    public String getHeight(Integer blockHeight) throws Throwable {

        return blockRpcClientAPI.getHeight(blockHeight);

    }

    @GetMapping("/getAddressInfo")
    public JSONObject getAddressInfo(String address) throws Throwable {
        return blockRpcClientAPI.getAddressInfo(address);
    }

    @GetMapping("/getBalance")
    public Double getBalance(String address) throws Throwable {
        return blockRpcClientAPI.getBalance(address);
    }

    @GetMapping("/getRawTransaxtion")
    public JSONObject getRawTransaxtion(String txid) throws Throwable {
        return blockRpcClientAPI.getRawTransaxtion(txid);
    }

    @GetMapping("/getTransaction")
    public JSONObject getTransaction(){
        return blockApi.getTransaction("3aac2f8454bb928214f3c1833b8da6b1b346bd75de7eb07a55252109e5ab5982");
    }

    @GetMapping("/getBlock")
    public JSONObject getBlock(){
        return blockApi.getBlock("0000000001237182c6a11a4e4466975349f14cfacb53253e4f2661f59374b712");
    }

    @GetMapping("/getBlockHeaders")
    public List<JSONObject> getBlockHeaders(){
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

    @GetMapping("/getutxos")
    public JSONObject getutxos(){
        return blockApi.getutxos("0000000024224c12fd9cc28e17b7eb5cd08645324e209ef48b95625d7aa260d9",2);
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

    @GetMapping("/getRecentBlockss")
    public List<BlockListDTO> getRecentBlockss(){

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
