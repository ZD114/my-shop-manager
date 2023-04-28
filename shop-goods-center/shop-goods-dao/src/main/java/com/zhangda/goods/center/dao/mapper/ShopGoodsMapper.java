package com.zhangda.goods.center.dao.mapper;

import com.zhangda.common.dao.base.BaseMapper;
import com.zhangda.goods.center.model.po.ShopGoods;
import com.zhangda.goods.center.model.po.ShopGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopGoodsMapper extends BaseMapper<ShopGoods> {
    long countByExample(ShopGoodsExample example);

    int deleteByExample(ShopGoodsExample example);

    List<ShopGoods> selectByExample(ShopGoodsExample example);

    int updateByExampleSelective(@Param("row") ShopGoods row, @Param("example") ShopGoodsExample example);

    int updateByExample(@Param("row") ShopGoods row, @Param("example") ShopGoodsExample example);
}