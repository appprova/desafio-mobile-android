package net.hugonardo.gjp.repos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import net.hugonardo.gjp.R;
import net.hugonardo.gjp.api.repo.Repo;
import net.hugonardo.gjp.tools.base.BaseFragment;

import java.util.List;

public class RepoListFragment extends BaseFragment
        implements LoaderManager.LoaderCallbacks<List<Repo>>,
        RecyclerArrayAdapter.OnMoreListener,
        RepoListAdapter.EventHandler {

    private static final int REPOSITORY_LOADER_ID = 0;

    private RepoListAdapter mAdapter;
    private EasyRecyclerView mEasyRecyclerView;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.repo_list_fragment, container, false);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupListView(view);
        setupAdapter();
    }

    private void setupListView(View view) {
        mEasyRecyclerView = view.findViewById(R.id.easyRecycler);
        mEasyRecyclerView.getRecyclerView().setLayoutManager(new LinearLayoutManager(getContext()));
        mEasyRecyclerView.getRecyclerView().setHasFixedSize(true);
        HorizontalDividerItemDecoration divider = new HorizontalDividerItemDecoration
                .Builder(getContext())
                .marginResId(R.dimen.list_divider_vertical_margin_start, R.dimen.list_divider_vertical_margin_end)
                .build();
        mEasyRecyclerView.getRecyclerView().addItemDecoration(divider);
    }

    private void setupAdapter() {
        mAdapter = new RepoListAdapter(LayoutInflater.from(getContext()), this);
        mAdapter.setMore(R.layout.list_item_loading_more, this);
        mEasyRecyclerView.setAdapterWithProgress(mAdapter);
    }

    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(REPOSITORY_LOADER_ID, null, this);
    }

    @Override public void onMoreShow() {
        if (isAdded()) {
            final RepoLoader loader = repositoryLoader();

            if (loader == null || !loader.hasMoreResults()) {
                mAdapter.stopMore();
                return;
            }

            loader.loadMoreResults();
        }
    }

    @Override public void onMoreClick() {}

    private RepoLoader repositoryLoader() {
        return (RepoLoader) getLoaderManager().<List<Repo>>getLoader(REPOSITORY_LOADER_ID);
    }

    @Override public Loader<List<Repo>> onCreateLoader(int id, Bundle args) {
        return new RepoLoader(getContext());
    }

    @Override public void onLoadFinished(Loader<List<Repo>> loader, List<Repo> data) {
        mAdapter.swapData(data);
    }

    @Override public void onLoaderReset(Loader<List<Repo>> loader) {
        mAdapter.clear();
    }

    @Override public void onItemClick(Repo repo) {
        Snackbar.make(mEasyRecyclerView, "Navegar até a lista de PRs", Snackbar.LENGTH_SHORT).show();
        //Bundle args = PullRequestActivity.getLauncherBundle(mModel);
        //getFrameworkTools().navigator().forwardTo(PullRequestActivity.class, args);
    }
}
