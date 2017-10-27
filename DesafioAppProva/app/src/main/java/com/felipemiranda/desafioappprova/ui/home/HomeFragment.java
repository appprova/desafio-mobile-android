package com.felipemiranda.desafioappprova.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.felipemiranda.desafioappprova.R;
import com.felipemiranda.desafioappprova.model.response.SearchResponse;
import com.felipemiranda.desafioappprova.ui.home.adapter.ListItemsAdapter;
import com.felipemiranda.desafioappprova.ui.main.BaseFragment;
import com.felipemiranda.desafioappprova.ui.main.BaseLoadingPresenter;
import com.felipemiranda.desafioappprova.ui.search.ItemDetailFragment;

import butterknife.BindView;

/**
 * Created by felipemiranda on 26/10/17.
 */

public class HomeFragment extends BaseFragment implements HomeView, ListItemsAdapter.OnClickItem {

    public static final String TAG = HomeFragment.class.getSimpleName();

    @BindView(R.id.rv_list_items)
    RecyclerView rvListItems;

    private HomePresenter mHomePresenter;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateViewBinder(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHomePresenter = new HomePresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mHomePresenter.requestSearch();
    }

    @Override
    public BaseLoadingPresenter getPresenter() {
        return mHomePresenter;
    }

    @Override
    public void successSearch(SearchResponse response) {
        if (response != null && response.getItems() != null && !response.getItems().isEmpty()) {
            ListItemsAdapter listItemsAdapter = new ListItemsAdapter(response.getItems(), this);
            rvListItems.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            rvListItems.setAdapter(listItemsAdapter);
        }
    }

    @Override
    public void onClickItem(String url) {
        setFragmentContent(ItemDetailFragment.newInstance(url), TAG);
    }
}
