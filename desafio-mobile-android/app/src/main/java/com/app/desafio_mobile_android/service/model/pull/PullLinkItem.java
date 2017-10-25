package com.app.desafio_mobile_android.service.model.pull;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PullLinkItem implements Parcelable {
    @SerializedName("href")
    private String href;

    protected PullLinkItem(Parcel in) {
        href = in.readString();
    }

    public static final Creator<PullLinkItem> CREATOR = new Creator<PullLinkItem>() {
        @Override
        public PullLinkItem createFromParcel(Parcel in) {
            return new PullLinkItem(in);
        }

        @Override
        public PullLinkItem[] newArray(int size) {
            return new PullLinkItem[size];
        }
    };

    public String getHref() {
        return href;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(href);
    }
}
