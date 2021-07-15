package com.opencode.utils.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * freemarker工具类
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@Slf4j
public class FreeMarkerUtils {

    private static final String JAVA_DIR = "D:/gitRepository/springboot-demo/src/main/java/com/opencode/";

    private static final String RESOURCE_DIR = "D:/gitRepository/springboot-demo/src/main/resources/";

    public static void generateMapperXmlFile(String tableName) throws IOException {
        ConfigParams params = new ConfigParams();
        params.setClassName(tableName);
        params.setGenerateFile(new File(RESOURCE_DIR + "mapper/" + tableName + "Mapper.xml"));
        params.setTemplateFileName("mapper.xml.ftl");
        configGenerate(params);
    }

    public static void generateMapperInterface(String tableName) throws IOException {
        ConfigParams params = new ConfigParams();
        params.setClassName(tableName);
        params.setGenerateFile(new File(JAVA_DIR + "dao/" + params.getClassName() + "Mapper.java"));
        params.setTemplateFileName("mapper.java.ftl");
        configGenerate(params);
    }

    public static void generateJavaEntity(String tableName) throws IOException {
        ConfigParams params = new ConfigParams();
        params.setClassName(tableName);
        params.setGenerateFile(new File(JAVA_DIR + "entity/" + params.getClassName() + ".java"));
        params.setTemplateFileName("entity.java.ftl");
        params.setClassName(tableName);
        configGenerate(params);
    }

    private static void configGenerate(ConfigParams params) throws IOException {
        //1.创建freemarker配置
        Configuration configuration = new Configuration(Configuration.getVersion());
        //2.设置字符集
        configuration.setDefaultEncoding("utf-8");

        File templateFile = ResourceUtils.getFile("classpath:templates/freemarker/");
        //3.设置模板文件所在路径
        configuration.setDirectoryForTemplateLoading(templateFile);
        //4.指定模板文件
        Template template = configuration.getTemplate(params.getTemplateFileName());

        try (Writer writer = new FileWriter(params.getGenerateFile())) {
            template.process(params, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
            log.error("模板文件解析发生错误！错误信息: {}", e.getMessage());
        }
        log.info("模板文件解析成功，生成文件: {}", params.getGenerateFile().getName());
    }

}
