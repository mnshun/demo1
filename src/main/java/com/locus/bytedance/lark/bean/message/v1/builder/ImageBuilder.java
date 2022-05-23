package com.locus.bytedance.lark.bean.message.v1.builder;

import com.locus.bytedance.lark.bean.message.v1.FsMessage;
import com.locus.bytedance.lark.constant.FsConstant;

/**
 *
 */
public final class ImageBuilder extends BaseBuilder<ImageBuilder> {
    private String imageKey;

    public ImageBuilder() {
        this.msgType = FsConstant.AppMsgType.IMAGE;
    }

    public ImageBuilder imageKey(String imageKey) {
        this.imageKey = imageKey;
        return this;
    }

    @Override
    public FsMessage build() {
        FsMessage m = super.build();
        m.setImageKey(this.imageKey);
        return m;
    }
}
