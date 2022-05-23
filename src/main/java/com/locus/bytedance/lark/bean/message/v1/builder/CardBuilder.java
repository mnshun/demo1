package com.locus.bytedance.lark.bean.message.v1.builder;

import com.google.gson.JsonObject;
import com.locus.bytedance.lark.bean.message.v1.FsMessage;
import com.locus.bytedance.lark.bean.message.v1.builder.card.CardLink;
import com.locus.bytedance.lark.bean.message.v1.builder.card.Config;
import com.locus.bytedance.lark.bean.message.v1.builder.card.Header;
import com.locus.bytedance.lark.bean.message.v1.builder.card.element.Element;
import com.locus.bytedance.lark.constant.FsConstant;
import com.locus.bytedance.lark.util.json.FsGsonBuilder;

import java.util.List;

/**
 * 消息卡片
 */
public class CardBuilder extends BaseBuilder<CardBuilder> {
    private Config config;
    private Header header;
    private List<Element> elements;

    private CardLink cardLink;

    public CardBuilder() {
        this.msgType = FsConstant.AppMsgType.CARD;
    }

    public CardBuilder config(Config config) {
        this.config = config;
        return this;
    }

    public CardBuilder header(Header header) {
        this.header = header;
        return this;
    }

    public CardBuilder elements(List<Element> elements) {
        this.elements = elements;
        return this;
    }

    public CardBuilder cardLink(CardLink url) {
        this.cardLink = url;
        return this;
    }

    public JsonObject toJsonObject() {
        JsonObject cardJson = new JsonObject();
        cardJson.add("config", FsGsonBuilder.create().toJsonTree(config));
        cardJson.add("header", FsGsonBuilder.create().toJsonTree(header));
        cardJson.add("elements", FsGsonBuilder.create().toJsonTree(elements));
        cardJson.add("card_link", FsGsonBuilder.create().toJsonTree(cardLink));
        return cardJson;
    }

    @Override
    public FsMessage build() {
        FsMessage m = super.build();
        m.setCardSimple(toJsonObject().toString());
        return m;
    }

}
