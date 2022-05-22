package com.example.demo.web;

import com.github.tingyugetc520.bytedance.lark.api.impl.FsServiceImpl;
import com.github.tingyugetc520.bytedance.lark.bean.contact.v3.FsUserListQuery;
import com.github.tingyugetc520.bytedance.lark.bean.contact.v3.FsUserListResult;
import com.github.tingyugetc520.bytedance.lark.config.impl.FsDefaultConfigImpl;
import com.github.tingyugetc520.bytedance.lark.error.FsErrorException;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DemoController {
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "hello world";
    }

    @RequestMapping("/testSendMessage")
    @ResponseBody
    public String testSendMessage(@RequestBody String json) throws FsErrorException {
        Map<String, String> map = new Gson().fromJson(json, Map.class);
        FsDefaultConfigImpl config = new FsDefaultConfigImpl();
        config.setAppId(map.get("appId"));
        config.setAppSecret(map.get("appSecret"));
// FsService为SDK使用入口，后续接口使用均需要FsService
        FsServiceImpl fsService = new FsServiceImpl();
        fsService.setFsConfigStorage(config);

// 查询用户
        FsUserListQuery query = new FsUserListQuery();
//        query.setUserIdType("");
//        query.setDepartIdType("");
//        query.setDepartId("");
//        query.setPageToken("");
        FsUserListResult fsUserListResult = fsService.getUserService().listByDepart(query);
        return fsUserListResult.toJson();
    }


}
