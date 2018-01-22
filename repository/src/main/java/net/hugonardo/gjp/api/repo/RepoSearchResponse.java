package net.hugonardo.gjp.api.repo;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class RepoSearchResponse implements Parcelable {
    @SerializedName("total_count") public abstract Long total();
    @SerializedName("items") public abstract List<Repo> items();

    public static TypeAdapter<RepoSearchResponse> typeAdapter(Gson gson) {
        return new AutoValue_RepoSearchResponse.GsonTypeAdapter(gson);
    }
}
