package com.app.desafio_mobile_android.service.model.repositorie;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Classe de mapeamento com o retorno da lista de repositórios
 */

public class Repositorie implements Parcelable {
    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("incomplete_results")
    private boolean incompleteResults;
    @SerializedName("items")
    private List<RepositorieItem> items = null;

    protected Repositorie(Parcel in) {
        totalCount = in.readInt();
        incompleteResults = in.readByte() != 0;
        items = in.createTypedArrayList(RepositorieItem.CREATOR);
    }

    public static final Creator<Repositorie> CREATOR = new Creator<Repositorie>() {
        @Override
        public Repositorie createFromParcel(Parcel in) {
            return new Repositorie(in);
        }

        @Override
        public Repositorie[] newArray(int size) {
            return new Repositorie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(totalCount);
        parcel.writeByte((byte) (incompleteResults ? 1 : 0));
        parcel.writeTypedList(items);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public List<RepositorieItem> getItems() {
        return items;
    }
}
