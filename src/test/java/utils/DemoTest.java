package utils;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020/6/6 16:07
 * @Version 1.0
 **/
public class DemoTest {

  public static void main(String[] args) {
    String url = "http://gitlab.iwhalecloud.com/bassc/agic-mirror/material/tree/master/page/CustomerTag";
    System.out.println(url.split("page/")[1]);
  }

}
