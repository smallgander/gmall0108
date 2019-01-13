package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.service.SpuService;
import com.atguigu.gmall.util.MessageUtil;
import org.mockito.invocation.StubInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SpuManageController {

    @Reference
    private SpuService spuService;

    @RequestMapping("saveSpu")
    @ResponseBody
    public String saveSpu(SpuInfo spuInfo){
        //spuService.saveSpu(spuInfo);
        return MessageUtil.SAVE_SPU_SUCCESS;
    }

    @RequestMapping("spuList")
    @ResponseBody
    public List<SpuInfo> getSpuListList(String catalog3Id){
        return spuService.getSupInfoList(catalog3Id);
    }

    @RequestMapping("baseSaleAttrList")
    @ResponseBody()
    public List<BaseSaleAttr> baseSaleAttrList() {
        List<BaseSaleAttr>  baseSaleAttrList  = spuService.getBaseSaleAttrList();
        return baseSaleAttrList;
    }

    //@ResponseBody
    @RequestMapping("index")
    public String index() {
        return "index";
    }
    /**
     * 跳转到SpuListPage
     * 在index.html页面上加载spuListPage
     */
    @RequestMapping("spuListPage")
    public String getSpuListPage() {
        return "spuListPage";
    }


    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(){
        System.out.println("fileUpload");
        return "fileUpload";
    }





}
