package com.locus.bytedance.lark.bean.contact.v3;

import com.google.gson.annotations.SerializedName;
import com.locus.bytedance.lark.util.json.FsGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FsUserListQuery implements Serializable {
    private static final long serialVersionUID = -4552693690813504019L;

    private String userIdType;
    @SerializedName("department_id_type")
    private String departIdType;
    @SerializedName("department_id")
    private String departId;

    private String pageToken;
    private Integer pageSize;

    public static FsUserListQuery fromJson(String json) {
        return FsGsonBuilder.create().fromJson(json, FsUserListQuery.class);
    }

    public String toJson() {
        return FsGsonBuilder.create().toJson(this);
    }

}
