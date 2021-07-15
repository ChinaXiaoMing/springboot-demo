package com.opencode.utils.generator;

import lombok.Data;

import java.io.File;

/**
 * 配置参数
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@Data
public class ConfigParams {

    private File generateFile;

    private String templateFileName;

    private String className;

}
