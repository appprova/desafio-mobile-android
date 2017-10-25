package com.app.desafio_mobile_android.presentation.pull;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.desafio_mobile_android.R;
import com.app.desafio_mobile_android.intrastructure.util.CircleTransform;
import com.app.desafio_mobile_android.service.model.pull.Pull;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PullAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Pull> mPullList;
    private Context mContext;
    private PullPresenter.PullListListener mPullListListener;

    public PullAdapter(Context mContext, List<Pull> pullList, PullPresenter.PullListListener pullListListener) {
        this.mContext = mContext;
        this.mPullList = pullList;
        this.mPullListListener = pullListListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_pull, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        configHolder(mPullList.get(position), (ViewHolder) holder);
    }

    @Override
    public int getItemCount() {
        return mPullList.size();
    }

    private void configHolder(Pull item, ViewHolder holder) {
        setAvatar(item, holder);
        holder.mTextViewName.setText(item.getTitle());
        holder.mTextViewDescription.setText(item.getBody());
        holder.mTextViewUsername.setText(item.getUser().getLogin());
        holder.mTextViewDate.setText(item.dateCreate());
    }

    private void setAvatar(Pull item, ViewHolder holder) {
        Picasso.with(mContext).load(item.getUser().getAvatarUrl())
                .transform(new CircleTransform())
                .placeholder(R.drawable.ic_user)
                .into(holder.mImageViewAvatar);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textview_item_pull_name)
        TextView mTextViewName;
        @BindView(R.id.textview_item_pull_description)
        TextView mTextViewDescription;
        @BindView(R.id.imageview_item_pull_user_avatar)
        ImageView mImageViewAvatar;
        @BindView(R.id.textview_item_pull_username)
        TextView mTextViewUsername;
        @BindView(R.id.textview_item_pull_date)
        TextView mTextViewDate;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.relativelayout_item_pull_main_content)
        public void onViewClicked() {
            mPullListListener.onItemClick(getAdapterPosition());
        }
    }
}
