package net.hugonardo.gjp.api.infra.retrofit;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.SerializedName;

class IgnoreNonSerializedNameFields implements ExclusionStrategy {

    static ExclusionStrategy create() {
        return new IgnoreNonSerializedNameFields();
    }

    @Override public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(SerializedName.class) == null;
    }

    @Override public boolean shouldSkipClass(Class<?> clazz) { return false; }
}
