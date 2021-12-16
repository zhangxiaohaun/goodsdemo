package com.cskt.zxh.goodsdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cskt.zxh.goodsdemo.entity.Goods;
import com.cskt.zxh.goodsdemo.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zxh
 * @date 2021/11/17 -- 18:18
 */
@Controller
public class TiaoHtml5Controller {

    @Resource
    private GoodsService goodsService;

    @RequestMapping("/")
    public String index(Model model){/*
        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.select("distinct (goodsDistrict)");
        List<Goods> list = goodsService.list(goodsQueryWrapper);
        model.addAttribute("goodsDistrictList",list);*/
        return "index";
    }

}
