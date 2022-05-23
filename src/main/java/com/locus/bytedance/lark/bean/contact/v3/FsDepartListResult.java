package com.locus.bytedance.lark.bean.contact.v3;

import com.locus.bytedance.lark.util.json.FsGsonBuilder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FsDepartListResult implements Serializable {
    private static final long serialVersionUID = -4552693690813504019L;

    private Boolean hasMore;
    private String pageToken;
    private List<FsDepart> items;

    public static FsDepartListResult fromJson(String json) {
        return FsGsonBuilder.create().fromJson(json, FsDepartListResult.class);
    }

    public String toJson() {
        return FsGsonBuilder.create().toJson(this);
    }

}
