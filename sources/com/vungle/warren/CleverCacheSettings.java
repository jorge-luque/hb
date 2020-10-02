package com.vungle.warren;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.vungle.warren.model.JsonUtil;

public class CleverCacheSettings {
    static final boolean DEFAULT_ENABLED = true;
    static final long DEFAULT_TIMESTAMP = -1;
    static final String KEY_CLEVER_CACHE = "clever_cache";
    static final String KEY_ENABLED = "enabled";
    static final String KEY_TIMESTAMP = "clear_shared_cache_timestamp";
    @SerializedName("enabled")
    private final boolean enabled;
    @SerializedName("clear_shared_cache_timestamp")
    private final long timestamp;

    private CleverCacheSettings(boolean z, long j) {
        this.enabled = z;
        this.timestamp = j;
    }

    static CleverCacheSettings deserializeFromString(String str) {
        if (str == null) {
            return null;
        }
        try {
            return fromJson((JsonObject) new GsonBuilder().create().fromJson(str, JsonObject.class));
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    public static CleverCacheSettings fromJson(JsonObject jsonObject) {
        if (!JsonUtil.hasNonNull(jsonObject, "clever_cache")) {
            return null;
        }
        long j = -1;
        boolean z = DEFAULT_ENABLED;
        JsonObject asJsonObject = jsonObject.getAsJsonObject("clever_cache");
        try {
            if (asJsonObject.has(KEY_TIMESTAMP)) {
                j = asJsonObject.get(KEY_TIMESTAMP).getAsLong();
            }
        } catch (NumberFormatException unused) {
        }
        if (asJsonObject.has("enabled")) {
            JsonElement jsonElement = asJsonObject.get("enabled");
            if (jsonElement.isJsonPrimitive() && "false".equalsIgnoreCase(jsonElement.getAsString())) {
                z = false;
            }
        }
        return new CleverCacheSettings(z, j);
    }

    static CleverCacheSettings getDefault() {
        return new CleverCacheSettings(DEFAULT_ENABLED, -1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return DEFAULT_ENABLED;
        }
        if (obj == null || CleverCacheSettings.class != obj.getClass()) {
            return false;
        }
        CleverCacheSettings cleverCacheSettings = (CleverCacheSettings) obj;
        if (this.enabled == cleverCacheSettings.enabled && this.timestamp == cleverCacheSettings.timestamp) {
            return DEFAULT_ENABLED;
        }
        return false;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        long j = this.timestamp;
        return ((this.enabled ? 1 : 0) * true) + ((int) (j ^ (j >>> 32)));
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public String serializeToString() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("clever_cache", new GsonBuilder().create().toJsonTree(this));
        return jsonObject.toString();
    }
}
