package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AttrManageController {
    @Reference
    private AttrService attrService;

    @RequestMapping("attrListPage")
    public String getAttrListPage(){
        return "attrListPage";
    }
    /**
     * 给easyUI的数据需要是json类型的数据，
     * @return
     */
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1(){
        return attrService.getCatalog1();
    }
    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getCatalog2(String catalog1Id){
        List<BaseCatalog2> baseCatalog2s = attrService.getCatalog2(catalog1Id);
        System.out.println(baseCatalog2s);
        return baseCatalog2s;
    }
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        List<BaseCatalog3> baseCatalog3s = attrService.getCatalog3(catalog2Id);
        return baseCatalog3s;
    }
    /**
     * 点击查询按钮通过三级分类id得到属性表中的信息
     */
    @RequestMapping("getAttrList")
    @ResponseBody
    public List<BaseAttrInfo> getAttrList(String cataLog3Id){
        List<BaseAttrInfo> attrInfoList = attrService.getAttrInfo(cataLog3Id);
        return attrInfoList;
    }

}
