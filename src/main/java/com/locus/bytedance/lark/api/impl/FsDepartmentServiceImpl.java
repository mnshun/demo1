package com.locus.bytedance.lark.api.impl;

import com.google.gson.JsonObject;
import com.locus.bytedance.lark.api.FsDepartmentService;
import com.locus.bytedance.lark.api.FsService;
import com.locus.bytedance.lark.bean.contact.v3.FsDepartListQuery;
import com.locus.bytedance.lark.bean.contact.v3.FsDepartListResult;
import com.locus.bytedance.lark.error.FsErrorException;
import com.locus.bytedance.lark.util.DataUtils;
import com.locus.bytedance.lark.util.json.GsonParser;
import lombok.RequiredArgsConstructor;

import static com.locus.bytedance.lark.constant.FsApiPathConstant.Department.DEPARTMENT_LIST;


/**
 * 部门管理接口
 */
@RequiredArgsConstructor
public class FsDepartmentServiceImpl implements FsDepartmentService {
    private final FsService mainService;

    @Override
    public FsDepartListResult list(FsDepartListQuery query) throws FsErrorException {
        String json = query.toJson();
        String params = DataUtils.parseJsonToUrlParams(json);

        String url = this.mainService.getFsConfigStorage().getApiUrl(DEPARTMENT_LIST);
        String responseContent = this.mainService.get(url, params);
        JsonObject tmpJsonObject = GsonParser.parse(responseContent);
        return FsDepartListResult.fromJson(tmpJsonObject.get("data").toString());
    }
}
