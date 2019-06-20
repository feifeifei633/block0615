package io.llf.demo.controller;

import com.alibaba.fastjson.JSONObject;
import io.llf.demo.api.BlockApi;
import io.llf.demo.api.BlockRpcClientAPI;
import io.llf.demo.dao.BlockMapper;
import io.llf.demo.po.Block;
import io.llf.demo.service.BitcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/temp")
@EnableAutoConfiguration
public class TempController {
    @Autowired
    private BlockApi blockApi;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private BlockRpcClientAPI blockRpcClientAPI;

    @Autowired
    private BitcionService bitcionService;


    @GetMapping("/tt")
    public String tt() throws Throwable {
       /* String blockhash = "00000000b873e79784647a6c82962c70d228557d24a747ea4d1b8bbe878e1206";

        while (blockhash !=null && !blockhash.isEmpty()){
            JSONObject jsonObject = blockApi.getBlock(blockhash);
            Block block = new Block();
            block.setBlockhash(jsonObject.getString("hash"));
            block.setHeight(jsonObject.getInteger("height"));
            Long time = jsonObject.getLong("time");
            block.setTime(new Date(time *1000));
            block.setTxsize(jsonObject.getShort("nTx"));
            block.setSize(jsonObject.getInteger("size"));
            block.setWeight(jsonObject.getFloat("weight"));
            block.setDifficulty(jsonObject.getDouble("difficulty"));
            block.setPreviousblock(jsonObject.getString("previousblockhash"));
            block.setNextblock(jsonObject.getString("nextblockhash"));
            blockMapper.insert(block);
            blockhash = block.getNextblock();

        }*/

       String hash = "000000000000006c9ed4a5a221f3d222f10309be3045c168055cc5870d11f23d";
       bitcionService.synchronizeBlockFromHash(hash);

        return null;
    }

}
