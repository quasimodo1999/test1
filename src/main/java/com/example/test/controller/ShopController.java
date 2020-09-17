package com.example.test.controller;

import com.example.test.exception.MyException;
import com.example.test.pojo.Shop;
import com.example.test.service.ShopService;
import com.example.test.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shop")
@Log4j2
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("getShopList")
    public ResultVo getShopList(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        ResultVo resultVo = new ResultVo();
        PageHelper.startPage(pageNum, 5);
        List<Shop> shopList = shopService.getShopList();
        PageInfo<Shop> shopPageInfo = new PageInfo<>(shopList);
        resultVo.setData(shopPageInfo);
        return resultVo;
    }

    @GetMapping("getExceptionMsg")
    public ResultVo getExceptionMsg () {

        if (1 == 1) {
             // 默认格式: 【接口的名字或者意义】：异常的原因 + 参数
            log.error("【获取异常信息】：出现异常了");
            throw new MyException("出现异常了");
        }
        return new ResultVo();
    }
}
