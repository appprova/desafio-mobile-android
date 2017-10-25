package com.app.desafio_mobile_android.presentation.home.repositorielist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.desafio_mobile_android.R;
import com.app.desafio_mobile_android.intrastructure.util.CircleTransform;
import com.app.desafio_mobile_android.service.model.repositorie.RepositorieItem;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RepositorieListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<RepositorieItem> mRepositorieItems;
    private Context mContext;
    private RepositorieListPresenter.RepositorieListListener mListListener;

    public RepositorieListAdapter(Context mContext, List<RepositorieItem> repositorieItems, RepositorieListPresenter.RepositorieListListener listListener) {
        this.mContext = mContext;
        this.mRepositorieItems = repositorieItems;
        this.mListListener = listListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_repositorie_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        configHolder(mRepositorieItems.get(position), (ViewHolder) holder);
    }

    @Override
    public int getItemCount() {
        return mRepositorieItems.size();
    }

    public void addAll(List<RepositorieItem> repositorieItemList) {
        for (RepositorieItem repositorieItem : repositorieItemList) {
            add(repositorieItem);
        }
    }

    public void add(RepositorieItem repositorieItem) {
        mRepositorieItems.add(repositorieItem);
        notifyItemInserted(mRepositorieItems.size() - 1);
    }

    private void configHolder(RepositorieItem item, ViewHolder holder) {
        setAvatar(item, holder);
        holder.mTextViewRepoName.setText(item.getName());
        holder.mTextViewDescription.setText(item.getDescription());
        NumberFormat numberFormat = NumberFormat.getInstance();
        holder.mTextViewForks.setText(numberFormat.format(item.getForks()));
        holder.mTextViewStars.setText(numberFormat.format(item.getStargazersCount()));
        holder.mTextViewUsername.setText(item.getOwner().getLogin());
        holder.mTextViewFullName.setText(item.getFullName());
    }

    private void setAvatar(RepositorieItem item, ViewHolder holder)  {
        Picasso.with(mContext).load(item.getOwner().getAvatarUrl())
                .transform(new CircleTransform())
                .placeholder(R.drawable.ic_user)
                .into(holder.mImageViewAvatar);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textview_item_repositorie_list_repo_name)
        TextView mTextViewRepoName;
        @BindView(R.id.textview_item_respositorie_list_description)
        TextView mTextViewDescription;
        @BindView(R.id.textview_item_respositorie_list_forks)
        TextView mTextViewForks;
        @BindView(R.id.textview_item_respositorie_list_stars)
        TextView mTextViewStars;
        @BindView(R.id.imageview_item_respositorie_list_avatar)
        ImageView mImageViewAvatar;
        @BindView(R.id.textview_item_respositorie_list_username)
        TextView mTextViewUsername;
        @BindView(R.id.textview_item_respositorie_list_fullname)
        TextView mTextViewFullName;
        @BindView(R.id.relativelayout_item_repositorie_main_content)
        RelativeLayout mRelativeLayoutMainContent;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.relativelayout_item_repositorie_main_content)
        public void onViewClicked() {
            mListListener.onItemSelected(getAdapterPosition());
        }
    }
}
