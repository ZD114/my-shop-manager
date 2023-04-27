package com.zhangda.code.generator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * 增加自定义导入类包插件
 *
 * @author zhangda
 * @date: 2023/4/27
 **/
public class AutoImportClassPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType("io.swagger.annotations.ApiModelProperty");
        return true;
    }
}
