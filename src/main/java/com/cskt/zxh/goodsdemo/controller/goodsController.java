package com.cskt.zxh.goodsdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cskt.zxh.goodsdemo.entity.Goods;
import com.cskt.zxh.goodsdemo.service.GoodsService;
import com.cskt.zxh.goodsdemo.utils.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zxh
 * @date 2021/11/17 -- 18:15
 */
@RequestMapping("/goods")
@Controller
public class goodsController {
//1
    @Resource
    private GoodsService goodsService;

    @RequestMapping("/goodsList")
    public String goodsList(Integer goodsdistrict,Model model){
        String userlist = RedisUtil.get("userlist");
        List<Goods> list;
        if (userlist==null) {
            QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();
            goodsQueryWrapper.eq("goodsDistrict",goodsdistrict);
            list = goodsService.list(goodsQueryWrapper);
            String s = JSON.toJSONString(list);
            RedisUtil.set("userlist",s);
            RedisUtil.expire("userlist",10);
            model.addAttribute("goodsList",list);
        }else{
            list=JSONArray.parseArray(userlist,Goods.class);
            model.addAttribute("goodsList",list);
        }
        return "goodsList";
    }

    @GetMapping("/goodsById")
    public String goodsById(Integer id,Model model){
        Goods goods= goodsService.getById(id);
        model.addAttribute("goods",goods);
        return "goods";
    }

    @PostMapping("/updateGoods")
    public String updateGoods(Goods goods){
        boolean flag = goodsService.updateById(goods);
        if (flag) {
            QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();
            goodsQueryWrapper.eq("goodsDistrict",goods.getGoodsdistrict());
            List<Goods> list = goodsService.list(goodsQueryWrapper);
            String s = JSON.toJSONString(list);
            RedisUtil.set("userlist",s);
            return "redirect:/goods/goodsList?goodsdistrict="+goods.getGoodsdistrict();
        }else{
            return "redirect:/goods/goodsById?id="+goods.getId();
        }
    }
}
