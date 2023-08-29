package com.zhangda.crm.model.po;

import java.time.LocalDateTime;

/**
 * @author zhangda
 * @date: 2023/5/29
 **/
public class ContractData {
    private String title; // 合同标题
    private String name; // 客户名称
    private String type; // 合同类型
    private String product; // 产品名称
    private int quantity; // 产品数量
    private double price; // 产品单价
    private double amount; // 产品总金额
    private byte[] signature; // 签章图片字节数组
    private LocalDateTime time; //签订时间

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
