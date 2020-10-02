package com.vungle.warren.network.converters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import p113i.C3484b0;

public class JsonConverter implements Converter<C3484b0, JsonObject> {
    private static final Gson gson = new GsonBuilder().create();

    public JsonObject convert(C3484b0 b0Var) throws IOException {
        try {
            return (JsonObject) gson.fromJson(b0Var.string(), JsonObject.class);
        } finally {
            b0Var.close();
        }
    }
}
