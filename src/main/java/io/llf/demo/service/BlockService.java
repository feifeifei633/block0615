package io.llf.demo.service;

import io.llf.demo.dto.BlockGetDTO;
import io.llf.demo.dto.BlockListDTO;

import java.util.List;

public interface BlockService {
    List<BlockListDTO> getJustNowBlocks();

    List<BlockGetDTO> getblockview();
}
