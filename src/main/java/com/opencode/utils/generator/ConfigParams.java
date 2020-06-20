package com.opencode.utils.generator;

import lombok.Data;

import java.io.File;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020/5/24 22:37
 * @Version 1.0
 **/
@Data
public class ConfigParams {

    private File generateFile;

    private String TemplateFileName;

    private String className;

}
