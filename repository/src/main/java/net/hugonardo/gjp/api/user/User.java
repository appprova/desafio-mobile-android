package net.hugonardo.gjp.api.user;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class User implements Parcelable {
    @SerializedName("id") public abstract Long id();
    @SerializedName("login") public abstract String login();
    @SerializedName("name") public abstract String name();
    @SerializedName("avatar_url") public abstract String avatarUrl();

    public static TypeAdapter<User> typeAdapter(Gson gson) {
        return new AutoValue_User.GsonTypeAdapter(gson);
    }
}
