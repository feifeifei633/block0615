package io.llf.demo.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BlockScheduler {
    private Logger logger = LoggerFactory.getLogger(BlockScheduler.class);

    @Scheduled(fixedRate = 60000)
    private void scheduleds(){
        logger.info("定时任务6分钟刷新一次");
    }
}
