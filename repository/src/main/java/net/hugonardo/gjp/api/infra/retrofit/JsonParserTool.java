package net.hugonardo.gjp.api.infra.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class JsonParserTool {

    private static Gson sGson;

    public static Gson gson() {
        if (sGson == null) {
            sGson = new GsonBuilder()
                    .registerTypeAdapter(String.class, StringDeserializer.instance())
                    .setExclusionStrategies(IgnoreNonSerializedNameFields.create())
                    .create();
        }
        return sGson;
    }

    public static String toJson(Object o) {
        return gson().toJson(o);
    }
}
