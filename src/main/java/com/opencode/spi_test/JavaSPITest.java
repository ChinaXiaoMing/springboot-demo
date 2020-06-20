package com.opencode.spi_test;

import java.util.ServiceLoader;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020/4/23 22:14
 * @Version 1.0
 **/
public class JavaSPITest {

    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }

}
