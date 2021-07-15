package com.opencode.spi_test;

import lombok.extern.slf4j.Slf4j;

import java.util.ServiceLoader;


/**
 * java SPI测试
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@Slf4j
public class JavaSpiTest {

    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        log.info("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }

}
