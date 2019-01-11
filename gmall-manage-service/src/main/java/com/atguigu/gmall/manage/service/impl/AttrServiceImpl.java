package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.bean.BaseCatalog1;
import com.atguigu.gmall.bean.BaseCatalog2;
import com.atguigu.gmall.bean.BaseCatalog3;
import com.atguigu.gmall.manage.mapper.*;
import com.atguigu.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {
    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;
    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;
    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;

    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;
    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;

    /**
     * 得到所有的一级分类的信息
     * @return
     */
    @Override
    public List<BaseCatalog1> getCatalog1() {
        return baseCatalog1Mapper.selectAll();
    }
    /**
     * 通过一级分类的cataLog1Id，得到相应的二级分类的信息
     * @param cataLog1Id
     * @return
     */
    @Override
    public List<BaseCatalog2> getCatalog2(String cataLog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(cataLog1Id);
        return baseCatalog2Mapper.select(baseCatalog2);
    }

    /**
     * 通过二级分类得到三级分类的信息
     * @param cataLog2Id
     * @return
     */
    @Override
    public List<BaseCatalog3> getCatalog3(String cataLog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(cataLog2Id);
        return baseCatalog3Mapper.select(baseCatalog3);
    }

    /**
     * 通过三级分类的id来得属性表中的数据信息
     * @param cataLog3Id
     * @return
     */
    @Override
    public List<BaseAttrInfo> getAttrInfo(String cataLog3Id) {
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(cataLog3Id);
        return baseAttrInfoMapper.select(baseAttrInfo);
    }
}
