package com.opencode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 预加载
 *
 * @author fu.yuanming
 * @since 2020-07-15
 */
@Component
@Slf4j
public class PreLoad {

    @EventListener(ApplicationReadyEvent.class)
    public void startup() {
        log.info("=========== application started =================");
    }

}
