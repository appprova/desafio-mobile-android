package net.hugonardo.gjp.api.infra.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class JsonParserTool {

    private static Gson mGson;

    public static Gson gson() {
        if (mGson == null) {
            mGson = new GsonBuilder()
                    .registerTypeAdapterFactory(GjpAdapterFactory.create())
                    .registerTypeAdapter(String.class, StringDeserializer.instance())
                    .setExclusionStrategies(IgnoreNonSerializedNameFields.create())
                    .create();
        }
        return mGson;
    }

    public static String toJson(Object o) {
        return gson().toJson(o);
    }
}
