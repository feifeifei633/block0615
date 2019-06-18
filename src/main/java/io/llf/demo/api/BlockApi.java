package io.llf.demo.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "bitcoin",url = "http://localhost:18332")
public interface BlockApi {

    @GetMapping("/rest/tx/{txhash}.json")
    JSONObject getTransaction(@PathVariable("txhash") String txhash);

    @GetMapping("/rest/block/{blockhash}.json")
    JSONObject getBlock(@PathVariable("blockhash") String blockhash);

    @GetMapping("/rest/headers/{count}/{blockhash}.json")
    List<JSONObject> getBlockHeaders(@PathVariable("count") Integer count, @PathVariable("blockhash") String blockhash);

    @GetMapping("/rest/blockhashbyheight/{count}.json")
    JSONObject getCount(@PathVariable("count") String count);

    @GetMapping("/rest/chaininfo.json")
    JSONObject getChainInfos();

    @GetMapping("/rest/getutxos/{checkmempool}.json")
    JSONObject getutxos(@PathVariable("checkmempool") String checkmempool,@PathVariable("n")Integer n);

    @GetMapping("/rest/mempool/info.json")
    JSONObject getMempoolInfo();

    @GetMapping("/rest/mempool/contents.json")
    JSONObject getMempoolContents();

}
