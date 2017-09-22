package net.hugonardo.gjp.api.repo;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import net.hugonardo.gjp.api.user.User;

@AutoValue
public abstract class Repo implements Parcelable {
    @SerializedName("id") public abstract Long id();
    @SerializedName("name") public abstract String name();
    @SerializedName("full_name") public abstract String fullName();
    @SerializedName("owner") public abstract User owner();
    @SerializedName("description") public abstract String description();
    @SerializedName("forks_count") public abstract Long forksCount();
    @SerializedName("stargazers_count") public abstract Long starsCount();

    public static TypeAdapter<Repo> typeAdapter(Gson gson) {
        return new AutoValue_Repo.GsonTypeAdapter(gson);
    }
}
