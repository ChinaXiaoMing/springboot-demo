package com.opencode.spi_test;

import lombok.extern.slf4j.Slf4j;

/**
 * 擎天柱
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@Slf4j
public class OptimusPrime implements Robot {

    @Override
    public void sayHello() {
        log.info("Hello, I am Optimus Prime.");
    }

}
