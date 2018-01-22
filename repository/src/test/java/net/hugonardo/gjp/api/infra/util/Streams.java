package net.hugonardo.gjp.api.infra.util;

import android.support.annotation.NonNull;

import java.io.InputStream;

import okio.BufferedSource;
import okio.Okio;

public class Streams {

    @NonNull
    public BufferedSource loadResourceFile(String path) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        return Okio.buffer(Okio.source(inputStream));
    }
}
