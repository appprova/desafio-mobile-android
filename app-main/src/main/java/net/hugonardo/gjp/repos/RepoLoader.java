package net.hugonardo.gjp.repos;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import net.hugonardo.gjp.api.repo.Repo;
import net.hugonardo.gjp.tools.dummy.DummyRepositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RepoLoader extends AsyncTaskLoader<List<Repo>> {

    private List<Repo> mData;
    private Integer mNextPageToken;
    private boolean mIsLoading;

    private boolean mHasError;

    RepoLoader(Context context) {
        super(context);
        init();
    }

    private void init() {
        mHasError = false;
        mNextPageToken = 1;
        mIsLoading = true;
        mData = null;
    }

    @Override
    protected void onStartLoading() {
        if (mData != null) {
            // If we already have results and are starting up, deliver what we already have.
            deliverResult(null);
        } else {
            forceLoad();
        }
    }

    @Override
    public List<Repo> loadInBackground() {
        mIsLoading = true;
        List<Repo> data = null;

        try {
            Thread.sleep(1000);
            data = DummyRepositories.getPage(mNextPageToken);
            if (mData == null) {
                mData = Collections.synchronizedList(new ArrayList<Repo>());
            }
            mData.addAll(data);
            mHasError = false;
            mNextPageToken = DummyRepositories.getNextPageToken(mNextPageToken);
        } catch (IndexOutOfBoundsException | InterruptedException e) {
            e.printStackTrace();
            mHasError = true;
            mNextPageToken = null;
        }

        return data;
    }

    @Override
    public void onCanceled(List<Repo> data) {
        if (data != null) {
            deliverResult(data);
        }
    }

    @Override
    public void deliverResult(List<Repo> data) {
        mIsLoading = false;
        if (isStarted()) {
            // Need to return new ArrayList for some reason or onLoadFinished() is not called
            super.deliverResult(mData == null ? null : new ArrayList<>(mData));
        }
    }

    @Override
    protected void onStopLoading() {
        mIsLoading = false;
        cancelLoad();
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        mData = null;
    }

    void loadMoreResults() {
        if (!isLoading() && hasMoreResults()) {
            forceLoad();
        }
    }

    boolean isLoading() {
        return mIsLoading;
    }

    boolean hasMoreResults() {
        return mNextPageToken != null;
    }

    boolean hasError() {
        return mHasError;
    }

    void refresh() {
        reset();
        startLoading();
    }
}
