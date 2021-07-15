package com.opencode.utils.generator;

import com.opencode.utils.DateUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

/**
 * leetcode解决生成工具类
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@Slf4j
public class LeetcodeGenerator {

    public static void main(String[] args) throws IOException, TemplateException {
        //1.创建freemarker配置
        Configuration configuration = new Configuration(Configuration.getVersion());
        //2.设置字符集
        configuration.setDefaultEncoding("utf-8");
        File templateFile = ResourceUtils.getFile("classpath:templates/freemarker/");
        //3.设置模板文件所在路径
        configuration.setDirectoryForTemplateLoading(templateFile);
        //4.指定模板文件
        Template template = configuration.getTemplate("leetcode.ftl");
        //5.绑定参数
        HashMap<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("num", 160);
        paramsMap.put("description", "相交链表");
        paramsMap.put("level", "easy");
        paramsMap.put("methodName", "getIntersectionNode");
        paramsMap.put("param", "ListNode headA, ListNode headB");
        paramsMap.put("return", "ListNode");

        paramsMap.put("date", DateUtils.getLocalDateTime());
        File javaFile = new File("D:/gitRepository/springboot-demo/src/main/java/com/opencode/leetcode/Solution"
                + paramsMap.get("num") + ".java");
        Writer writer = new FileWriter(javaFile);
        template.process(paramsMap, writer);
        writer.close();
        log.info("模板文件生成成功！");
    }

}
