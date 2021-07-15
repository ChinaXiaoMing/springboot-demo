package com.opencode.spi_test;


import lombok.extern.slf4j.Slf4j;

/**
 * 大黄蜂
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@Slf4j
public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        log.info("Hello, I am Bumblebee.");
    }

}
