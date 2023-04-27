package com.zhangda.code.generator.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangda
 * @date: 2023/4/27
 **/
public class CodeGeneratorUtil {

    /**
     * 根据配置文件生成代码
     * @param configFile 配置文件
     */
    public static void generatorCode(String configFile) throws Exception {
        URL resource = CodeGeneratorUtil.class.getClassLoader().getResource(configFile);
        String filePath = resource.getFile();
        File file = new File(filePath);

        List<String> warnings = new ArrayList<>();
        ConfigurationParser parser = new ConfigurationParser(warnings);

        Configuration configuration = parser.parseConfiguration(file);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
        myBatisGenerator.generate(null);

        // 打印警告
        System.out.println("*************************************************************");
        warnings.stream().forEach(System.out::println);
        System.out.println("*************************************************************");
    }
}
