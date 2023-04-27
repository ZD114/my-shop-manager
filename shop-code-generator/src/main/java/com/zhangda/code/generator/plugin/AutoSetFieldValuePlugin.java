package com.zhangda.code.generator.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * MyBatis自定义插件, 当MyBatis Generator自动生成代码时, 为相应字段自动生成注解
 *
 * @author zhangda
 * @date: 2023/4/27
 **/
public class AutoSetFieldValuePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelFieldGenerated(Field field,
                                       TopLevelClass topLevelClass,
                                       IntrospectedColumn introspectedColumn,
                                       IntrospectedTable introspectedTable,
                                       ModelClassType modelClassType) {
        String fieldName = field.getName();

        // 此处根据字段名称来判断是否加注解
        final String createdTime = "createTime";
        final String updatedTime = "updateTime";

        final String createdUserId = "createUserId";
        final String updatedUserId = "updateUserId";

        final String createdUser = "createUser";
        final String updatedUser = "updateUser";

        if (fieldName.equalsIgnoreCase(createdTime)) {
            field.addAnnotation("@com.zhangda.common.constant.annotation.AutoTimeOnInsert");
        } else if (fieldName.equalsIgnoreCase(updatedTime)) {
            field.addAnnotation("@com.zhangda.common.constant.annotation.AutoTimeOnUpdate");
        } else if (fieldName.equalsIgnoreCase(createdUserId)) {
            field.addAnnotation("@com.zhangda.common.constant.annotation.AutoUserIdOnInsert");
        } else if (fieldName.equalsIgnoreCase(updatedUserId)) {
            field.addAnnotation("@com.zhangda.common.constant.annotation.AutoUserIdOnUpdate");
        } else if (fieldName.equalsIgnoreCase(createdUser)) {
            field.addAnnotation("@com.zhangda.common.constant.annotation.AutoUserOnInsert");
        } else if (fieldName.equalsIgnoreCase(updatedUser)) {
            field.addAnnotation("@com.zhangda.common.constant.annotation.AutoUserOnUpdate");
        }

        return true;
    }
}
