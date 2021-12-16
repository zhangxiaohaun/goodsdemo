package com.cskt.zxh.goodsdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cskt.zxh.goodsdemo.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
@author zxh
@date 2021/11/17 -- 18:13
*/
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
}