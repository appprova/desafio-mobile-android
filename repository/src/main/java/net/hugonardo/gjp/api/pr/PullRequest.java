package net.hugonardo.gjp.api.pr;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import net.hugonardo.gjp.api.user.User;

@AutoValue
public abstract class PullRequest implements Parcelable {
    @SerializedName("id") public abstract Long id();
    @SerializedName("number") public abstract Long number();
    @SerializedName("title") public abstract String title();
    @SerializedName("body") public abstract String body();
    @SerializedName("user") public abstract User user();

    public static TypeAdapter<PullRequest> typeAdapter(Gson gson) {
        return new AutoValue_PullRequest.GsonTypeAdapter(gson);
    }
}
