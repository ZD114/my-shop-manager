package com.zhangda.goods.center.model.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 * 表名：shop_goods
*/
@Table(name = "shop_goods")
public class ShopGoods implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 商品编号
     */
    @Column(name = "good_code")
    @ApiModelProperty("商品编号")
    private String goodCode;

    /**
     * 商品名称
     */
    @Column(name = "good_name")
    @ApiModelProperty("商品名称")
    private String goodName;

    /**
     * 商品描述
     */
    @ApiModelProperty("商品描述")
    private String description;

    /**
     * 商品状态（0-正常，1-售罄，2-下架）
     */
    @ApiModelProperty("商品状态（0-正常，1-售罄，2-下架）")
    private Integer status;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    @ApiModelProperty("创建人id")
    @com.zhangda.common.constant.annotation.AutoUserIdOnInsert
    private String createUserId;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    @ApiModelProperty("创建人")
    @com.zhangda.common.constant.annotation.AutoUserOnInsert
    private String createUser;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    @com.zhangda.common.constant.annotation.AutoTimeOnInsert
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    @Column(name = "update_user_id")
    @ApiModelProperty("更新人id")
    @com.zhangda.common.constant.annotation.AutoUserIdOnUpdate
    private String updateUserId;

    /**
     * 更新人
     */
    @Column(name = "update_user")
    @ApiModelProperty("更新人")
    @com.zhangda.common.constant.annotation.AutoUserOnUpdate
    private String updateUser;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @ApiModelProperty("更新时间")
    @com.zhangda.common.constant.annotation.AutoTimeOnUpdate
    private LocalDateTime updateTime;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id")
    public static final String ID = "id";

    public static final String DB_ID = "id";

    /**
     * 商品编号
     */
    @Column(name = "good_code")
    @ApiModelProperty("商品编号")
    public static final String GOOD_CODE = "goodCode";

    public static final String DB_GOOD_CODE = "good_code";

    /**
     * 商品名称
     */
    @Column(name = "good_name")
    @ApiModelProperty("商品名称")
    public static final String GOOD_NAME = "goodName";

    public static final String DB_GOOD_NAME = "good_name";

    /**
     * 商品描述
     */
    @ApiModelProperty("商品描述")
    public static final String DESCRIPTION = "description";

    public static final String DB_DESCRIPTION = "description";

    /**
     * 商品状态（0-正常，1-售罄，2-下架）
     */
    @ApiModelProperty("商品状态（0-正常，1-售罄，2-下架）")
    public static final String STATUS = "status";

    public static final String DB_STATUS = "status";

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    @ApiModelProperty("创建人id")
    public static final String CREATE_USER_ID = "createUserId";

    public static final String DB_CREATE_USER_ID = "create_user_id";

    /**
     * 创建人
     */
    @Column(name = "create_user")
    @ApiModelProperty("创建人")
    public static final String CREATE_USER = "createUser";

    public static final String DB_CREATE_USER = "create_user";

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    public static final String CREATE_TIME = "createTime";

    public static final String DB_CREATE_TIME = "create_time";

    /**
     * 更新人id
     */
    @Column(name = "update_user_id")
    @ApiModelProperty("更新人id")
    public static final String UPDATE_USER_ID = "updateUserId";

    public static final String DB_UPDATE_USER_ID = "update_user_id";

    /**
     * 更新人
     */
    @Column(name = "update_user")
    @ApiModelProperty("更新人")
    public static final String UPDATE_USER = "updateUser";

    public static final String DB_UPDATE_USER = "update_user";

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @ApiModelProperty("更新时间")
    public static final String UPDATE_TIME = "updateTime";

    public static final String DB_UPDATE_TIME = "update_time";

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品编号
     *
     * @return goodCode - 商品编号
     */
    public String getGoodCode() {
        return goodCode;
    }

    /**
     * 设置商品编号
     *
     * @param goodCode 商品编号
     */
    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    /**
     * 获取商品名称
     *
     * @return goodName - 商品名称
     */
    public String getGoodName() {
        return goodName;
    }

    /**
     * 设置商品名称
     *
     * @param goodName 商品名称
     */
    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    /**
     * 获取商品描述
     *
     * @return description - 商品描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置商品描述
     *
     * @param description 商品描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取商品状态（0-正常，1-售罄，2-下架）
     *
     * @return status - 商品状态（0-正常，1-售罄，2-下架）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置商品状态（0-正常，1-售罄，2-下架）
     *
     * @param status 商品状态（0-正常，1-售罄，2-下架）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建人id
     *
     * @return createUserId - 创建人id
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建人id
     *
     * @param createUserId 创建人id
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取创建人
     *
     * @return createUser - 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新人id
     *
     * @return updateUserId - 更新人id
     */
    public String getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 设置更新人id
     *
     * @param updateUserId 更新人id
     */
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 获取更新人
     *
     * @return updateUser - 更新人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置更新人
     *
     * @param updateUser 更新人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取更新时间
     *
     * @return updateTime - 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}