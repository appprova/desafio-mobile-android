package net.hugonardo.gjp.api.infra.retrofit;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import static net.hugonardo.java.commons.text.StringUtils.normalizeSpace;
import static net.hugonardo.java.commons.text.StringUtils.trimToNull;

final class StringDeserializer implements JsonDeserializer<String> {

    private static final StringDeserializer INSTANCE = new StringDeserializer();

    static StringDeserializer instance() {
        return INSTANCE;
    }

    @Override
    public String deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return normalizeSpace(trimToNull(json.getAsString()));
    }
}
