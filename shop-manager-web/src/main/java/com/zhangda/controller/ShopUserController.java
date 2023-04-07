package com.zhangda.controller;

import com.zhangda.common.Constant;
import com.zhangda.common.PageResult;
import com.zhangda.common.Result;
import com.zhangda.pojo.model.ShopUserInfoRepository;
import com.zhangda.service.ShopUserService;
import com.zhangda.service.common.CommonService;
import com.zhangda.pojo.ShopUser;
import com.zhangda.pojo.params.ShopUserParams;
import com.zhangda.utils.EasyExcelUtil;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 用户控制类
 *
 * @author zhangda
 * @date: 2023/3/31
 **/
@RestController
@RequestMapping("/user")
public class ShopUserController {

    @DubboReference
    public ShopUserService shopUserService;
    @DubboReference
    public CommonService commonService;

    private static final Logger log = LoggerFactory.getLogger(ShopUserController.class);

    /**
     * 用户列表
     *
     * @param searchParam
     * @return
     */
    @PostMapping("/list")
    public PageResult<ShopUser> list(@RequestBody ShopUserParams searchParam) {
        var pageResult = new PageResult<ShopUser>();
        var params = new HashMap<String, Object>();
        var sql = new StringBuilder("SELECT * FROM shop_user WHERE 1=1 ");

        if (StringUtils.isNotBlank(searchParam.getUsername())) {
            sql.append(" AND username like :username ");
            params.put("username", "%" + searchParam.getUsername() + "%");

        }

        if (StringUtils.isNotBlank(searchParam.getNickname())) {
            sql.append(" AND nickname like :nickname ");
            params.put("nickname", "%" + searchParam.getNickname() + "%");

        }

        var sqlCount = new StringBuilder("SELECT COUNT(1) FROM( " + sql + " GROUP BY id ) eq");

        var totalCount = commonService.countLine(sqlCount.toString(), params);

        log.info("总数量：{}", totalCount);

        if (totalCount > 0) {

            var start = searchParam.getPageIndex() == 0 ? 0
                    : (searchParam.getPageIndex() - 1) * searchParam.getPageSize();

            sql.append(" GROUP BY id ORDER BY id DESC LIMIT :start,:pageSize ");
            params.put("start", start);
            params.put("pageSize", searchParam.getPageSize());

            var resources = shopUserService.searchPageList(sql.toString(), params);

            pageResult.setData(resources);
        }

        pageResult.setTotal(totalCount);
        pageResult.setTotalPages((long) Math.ceil(totalCount / (double) searchParam.getPageSize()));

        return pageResult;
    }

    /**
     * 保存用信息
     *
     * @param shopUser
     * @return
     */
    @PostMapping("")
    public Result addUser(@RequestBody ShopUserInfoRepository shopUser) {
        return shopUserService.addUser(shopUser);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delUser(@PathVariable Long id) {
        return shopUserService.delUser(id);
    }

    /**
     * 查询用户详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result queryUserInfo(@PathVariable Long id) {
        return shopUserService.queryUserInfo(id);
    }

    /**
     * 更新用户信息
     *
     * @param repository
     * @return
     */
    @PutMapping("")
    public Result updateUser(@RequestBody ShopUserInfoRepository repository) {
        return shopUserService.updateUser(repository);
    }

    /**
     * 下载excel
     *
     * @param response
     */
    @PostMapping("/download")
    public void downloadExcel(@RequestBody List<Long> ids, HttpServletResponse response) {
        EasyExcelUtil.downloadExcel(response, Constant.SHOP_USER, shopUserService.querySelect(ids), ShopUserInfoRepository.class);
    }

}
