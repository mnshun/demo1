package com.locus.bytedance.lark.util.json;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.locus.bytedance.lark.error.FsError;

/**
 *
 */
public class FsGsonBuilder {
    private static final GsonBuilder INSTANCE = new GsonBuilder();

    static {
        INSTANCE.disableHtmlEscaping();
        INSTANCE.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        INSTANCE.registerTypeAdapter(FsError.class, new FsErrorAdapter());
    }

    public static Gson create() {
        return INSTANCE.create();
    }

}
