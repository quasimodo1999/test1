package com.example.test.service.Impl;

import com.example.test.mapper.ShopMapper;
import com.example.test.pojo.Shop;
import com.example.test.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Shop> getShopList() {
        return shopMapper.selectAll();
    }
}
