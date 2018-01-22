package net.hugonardo.gjp.api.repo;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import net.hugonardo.gjp.api.user.User;

@AutoValue
public abstract class Repo implements Parcelable {
    @SerializedName("id") public abstract Long id();
    @SerializedName("name") public abstract String name();

    @Nullable
    @SerializedName("full_name")
    public abstract String fullName();

    @SerializedName("owner") public abstract User owner();

    @Nullable
    @SerializedName("description")
    public abstract String description();

    @Nullable
    @SerializedName("forks_count")
    public abstract Long forksCount();

    @Nullable
    @SerializedName("stargazers_count")
    public abstract Long starsCount();

    public static TypeAdapter<Repo> typeAdapter(Gson gson) {
        return new AutoValue_Repo.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_Repo.Builder();
    }

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder id(Long id);
        public abstract Builder name(String name);
        public abstract Builder fullName(String fullName);
        public abstract Builder owner(User owner);
        public abstract Builder description(String description);
        public abstract Builder forksCount(Long forksCount);
        public abstract Builder starsCount(Long starsCount);
        public abstract Repo build();
    }
}
