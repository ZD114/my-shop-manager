package com.zhangda.pojo.model;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhangda
 * @date: 2023/4/6
 **/
public class ShopUserInfoRepository implements Serializable {
    /**用户基本信息**********************************/
    @ExcelProperty(value = "用户详情编号", index = 8)
    private Long id;

    @ExcelProperty(value = "用户名称", index = 1)
    private String username;

    @ExcelProperty(value = "密码", index = 2)
    private String password;

    @ExcelProperty(value = "昵称", index = 3)
    private String nickname;

    @ExcelProperty(value = "是否管理员", index = 4)
    private Integer isAdmin;

    @ExcelProperty(value = "是否删除", index = 5)
    private Integer isDelete;

    @ExcelProperty(value = "是否审批", index = 6)
    private Integer isApprove;

    @ExcelProperty(value = "是否冻结", index = 7)
    private Integer isFreeze;

    /**用户详情信息**********************************/
    @ExcelProperty(value = "用户编号", index = 0)
    private Long userId;

    @ExcelProperty(value = "性别（0未知，1男，2女）", index = 9)
    private Integer sex;

    @ExcelProperty(value = "真实姓名", index = 10)
    private String realName;

    @ExcelProperty(value = "QQ号", index = 11)
    private String qq;

    @ExcelProperty(value = "微信号", index = 12)
    private String wx;

    @ExcelProperty(value = "邮箱号", index = 13)
    private String email;

    @ExcelProperty(value = "生日", index = 14)
    private LocalDateTime birthday;

    @ExcelProperty(value = "手机号", index = 15)
    private String mobile;

    @ExcelProperty(value = "收货地址", index = 16)
    private String address;

    @ExcelProperty(value = "积分", index = 17)
    private Integer integral;

    @ExcelProperty(value = "头像", index = 18)
    private String profilePicture;

    @ExcelProperty(value = "签名", index = 19)
    private String signature;

    @ExcelProperty(value = "创建时间", index = 20)
    private LocalDateTime createTime;

    @ExcelProperty(value = "更新时间", index = 21)
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(Integer isApprove) {
        this.isApprove = isApprove;
    }

    public Integer getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(Integer isFreeze) {
        this.isFreeze = isFreeze;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
