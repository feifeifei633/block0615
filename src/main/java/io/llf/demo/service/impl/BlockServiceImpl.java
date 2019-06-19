package io.llf.demo.service.impl;

import io.llf.demo.dao.BlockMapper;
import io.llf.demo.dto.BlockListDTO;
import io.llf.demo.po.Block;
import io.llf.demo.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockMapper blockMapper;

    @Override
    public List<BlockListDTO> getJustNowBlocks() {
        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();

        List<Block> blockList = blockMapper.getJustNowBlocks();

        for (Block block : blockList) {
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setBlockhash(block.getBlockhash());
            blockListDTO.setHeight(block.getHeight());
            blockListDTO.setTime(block.getTime().getTime());
            blockListDTO.setTxsize(block.getTxsize());
            blockListDTO.setSize(block.getSize());
            blockListDTOS.add(blockListDTO);
        }

        return blockListDTOS;
    }
}
