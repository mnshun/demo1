package com.locus.bytedance.lark.bean;

import com.locus.bytedance.lark.api.impl.FsServiceImpl;
import com.locus.bytedance.lark.bean.contact.v3.FsUser;
import com.locus.bytedance.lark.bean.contact.v3.FsUserListQuery;
import com.locus.bytedance.lark.bean.contact.v3.FsUserListResult;
import com.locus.bytedance.lark.config.impl.FsDefaultConfigImpl;
import com.locus.bytedance.lark.error.FsErrorException;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Test
@Slf4j
public class FsUserTest {

    public void testFromJson() {
        String json = "";
        FsUser user = FsUser.fromJson(json);
        log.info("user: {}", user);
    }

    public void testToJson() {
        FsUser user = FsUser.builder().build();
        log.info("json: {}", user.toJson());
    }

    public void testSendMessage() throws FsErrorException {
        FsDefaultConfigImpl config = new FsDefaultConfigImpl();
        config.setAppId("cli_a209371ee438d00d");
        config.setAppSecret("p4K7GoYT83gX0ubiUCiVdbzv0UYcMQSY");

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
        System.out.println(fsUserListResult.toJson());

    }

}
