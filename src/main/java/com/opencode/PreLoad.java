package com.opencode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author fu.yuanming
 * @since 2020-07-15
 */
@Component
public class PreLoad {

    private static Logger logger = LoggerFactory.getLogger(PreLoad.class);

    @EventListener(ApplicationReadyEvent.class)
    public void startup() {
        logger.info("=========== application started =================");
    }

}
