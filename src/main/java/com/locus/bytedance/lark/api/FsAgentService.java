package com.locus.bytedance.lark.api;

import com.locus.bytedance.lark.bean.agent.v2.FsAgentAuthScope;
import com.locus.bytedance.lark.error.FsErrorException;

public interface FsAgentService {

    FsAgentAuthScope getAuthScope() throws FsErrorException;

}
