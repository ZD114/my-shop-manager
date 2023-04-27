package com.zhangda.code.generator;

import com.zhangda.code.generator.util.CodeGeneratorUtil;

/**
 * 商品代码生成
 *
 * @author zhangda
 * @date: 2023/4/27
 **/
public class ShopGoodsCodeGeneratorApplication {

    public static void main(String[] args) throws Exception {
        CodeGeneratorUtil.generatorCode("goods-center-code-generator-config.xml");
    }
}
