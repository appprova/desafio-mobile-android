package net.hugonardo.gjp.api.user;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class User implements Parcelable {
    @SerializedName("id") public abstract Long id();
    @SerializedName("login") public abstract String login();

    @Nullable
    @SerializedName("name")
    public abstract String name();

    @Nullable
    @SerializedName("avatar_url")
    public abstract String avatarUrl();

    public static TypeAdapter<User> typeAdapter(Gson gson) {
        return new AutoValue_User.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_User.Builder();
    }

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder id(Long id);
        public abstract Builder login(String login);
        public abstract Builder name(String name);
        public abstract Builder avatarUrl(String avatarUrl);
        public abstract User build();
    }
}
