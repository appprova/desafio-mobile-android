package com.app.desafio_mobile_android.service.model.pull;

import android.os.Parcel;
import android.os.Parcelable;

import com.app.desafio_mobile_android.service.model.Owner;
import com.app.desafio_mobile_android.service.model.repositorie.RepositorieItem;
import com.google.gson.annotations.SerializedName;

public class PullHead implements Parcelable {
    @SerializedName("label")
    private String label;
    @SerializedName("ref")
    private String ref;
    @SerializedName("sha")
    private String sha;
    @SerializedName("user")
    private Owner user;
    @SerializedName("repo")
    private RepositorieItem repo;

    protected PullHead(Parcel in) {
        label = in.readString();
        ref = in.readString();
        sha = in.readString();
        user = in.readParcelable(Owner.class.getClassLoader());
        repo = in.readParcelable(RepositorieItem.class.getClassLoader());
    }

    public static final Creator<PullHead> CREATOR = new Creator<PullHead>() {
        @Override
        public PullHead createFromParcel(Parcel in) {
            return new PullHead(in);
        }

        @Override
        public PullHead[] newArray(int size) {
            return new PullHead[size];
        }
    };

    public String getLabel() {
        return label;
    }

    public String getRef() {
        return ref;
    }

    public String getSha() {
        return sha;
    }

    public Owner getUser() {
        return user;
    }

    public RepositorieItem getRepo() {
        return repo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(label);
        parcel.writeString(ref);
        parcel.writeString(sha);
        parcel.writeParcelable(user, i);
        parcel.writeParcelable(repo, i);
    }
}
