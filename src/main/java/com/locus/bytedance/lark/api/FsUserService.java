package com.locus.bytedance.lark.api;

import com.locus.bytedance.lark.bean.contact.v3.FsUserListQuery;
import com.locus.bytedance.lark.bean.contact.v3.FsUserListResult;
import com.locus.bytedance.lark.error.FsErrorException;

/**
 * 用户管理接口
 */
public interface FsUserService {

    /**
     * 获取部门成员详情
     *
     * @param query query
     * @return the list
     * @throws FsErrorException the wx error exception
     */
    FsUserListResult listByDepart(FsUserListQuery query) throws FsErrorException;

}
