package net.hugonardo.gjp.repos;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import net.hugonardo.gjp.api.repo.Repo;
import net.hugonardo.gjp.api.user.User;

import org.parceler.Parcel;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Parcel
@NoArgsConstructor
public class RepoListItemViewModel extends BaseObservable {

    @Getter Repo mModel;

    void setModel(Repo model) {
        mModel = model;
        notifyChange();
    }

    @Bindable public String getName() {
        return mModel != null ? mModel.name() : null;
    }

    @Bindable public String getDescription() {
        return mModel != null ? mModel.description() : null;
    }

    @Bindable public String getForksCount() {
        return ((mModel != null) && (mModel.forksCount() != null))
               ? mModel.forksCount().toString() : null;
    }

    @Bindable public String getStarsCount() {
        return ((mModel != null) && (mModel.starsCount() != null))
               ? mModel.starsCount().toString() : null;
    }

    @Bindable public String getOwnerLogin() {
        return getOwner() != null ? getOwner().login() : null;
    }

    @Bindable public String getOwnerName() {
        return getOwner() != null ? getOwner().name() : null;
    }

    @Bindable private User getOwner() {
        return mModel != null ? mModel.owner() : null;
    }
}
