package com.opencode.utils.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.*;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020/4/4 10:22
 * @Version 1.0
 **/
public class FreeMarkerUtils {

    private static Logger logger = LoggerFactory.getLogger(FreeMarkerUtils.class);

    private static final String JAVA_DIR = "D:/gitRepository/springboot-demo/src/main/java/com/opencode/";

    private static final String RESOURCE_DIR = "D:/gitRepository/springboot-demo/src/main/resources/";

    public static void generateMapperXmlFile(String tableName) {
        ConfigParams params = new ConfigParams();
        params.setClassName(tableName);
        params.setGenerateFile(new File(RESOURCE_DIR + "mapper/" + tableName + "Mapper.xml"));
        params.setTemplateFileName("mapper.xml.ftl");
        configGenerate(params);
    }

    public static void generateMapperInterface(String tableName) {
        ConfigParams params = new ConfigParams();
        params.setClassName(tableName);
        params.setGenerateFile(new File(JAVA_DIR + "dao/" + params.getClassName() + "Mapper.java"));
        params.setTemplateFileName("mapper.java.ftl");
        configGenerate(params);
    }

    public static void generateJavaEntity(String tableName) {
        ConfigParams params = new ConfigParams();
        params.setClassName(tableName);
        params.setGenerateFile(new File(JAVA_DIR + "entity/" + params.getClassName() + ".java"));
        params.setTemplateFileName("entity.java.ftl");
        params.setClassName(tableName);
        configGenerate(params);
    }

    private static void configGenerate(ConfigParams params) {
        //1.创建freemarker配置
        Configuration configuration = new Configuration(Configuration.getVersion());
        //2.设置字符集
        configuration.setDefaultEncoding("utf-8");
        File templateFile = null;
        try {
            templateFile = ResourceUtils.getFile("classpath:templates/freemarker/");
            //3.设置模板文件所在路径
            configuration.setDirectoryForTemplateLoading(templateFile);
            //4.指定模板文件
            Template template = configuration.getTemplate(params.getTemplateFileName());

            Writer writer = new FileWriter(params.getGenerateFile());
            try {
                template.process(params, writer);
            } catch (TemplateException e) {
                e.printStackTrace();
                logger.error("模板文件解析发生错误！错误信息: {}", e.getMessage());
            }
            writer.close();
            logger.info("模板文件解析成功，生成文件: {}", params.getGenerateFile().getName());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("模板文件或目录不存在！");
        }
    }

    @Test
    public void generateTest() {
        String tableName = "Hello";
//        FreeMarkerUtils.generateJavaEntity(tableName);
//        FreeMarkerUtils.generateMapperInterface(tableName);
        FreeMarkerUtils.generateMapperXmlFile(tableName);
    }

}
