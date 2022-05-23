package com.locus.bytedance.lark.api;

import com.locus.bytedance.lark.bean.message.v1.FsMessage;
import com.locus.bytedance.lark.bean.message.v1.FsMessageSendResult;
import com.locus.bytedance.lark.error.FsErrorException;

/**
 *
 */
public interface FsMessageService {

    FsMessageSendResult send(FsMessage message) throws FsErrorException;

}
