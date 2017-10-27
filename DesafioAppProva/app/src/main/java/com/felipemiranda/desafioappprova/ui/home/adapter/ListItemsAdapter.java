package com.felipemiranda.desafioappprova.ui.home.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.felipemiranda.desafioappprova.R;
import com.felipemiranda.desafioappprova.model.Item;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by felipemiranda on 26/10/17.
 */

public class ListItemsAdapter extends RecyclerView.Adapter<ListItemsAdapter.AppViewHolder> {

    private ArrayList<Item> mItems;

    public ListItemsAdapter(ArrayList<Item> mSearchResponses) {
        this.mItems = mSearchResponses;
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        final Item item = mItems.get(holder.getAdapterPosition());
        ItemViewHolder holderItem = (ItemViewHolder) holder;

        holderItem.tvName.setText(item.getName());
        holderItem.tvDescription.setText(item.getDescription());
        holderItem.tvFork.setText(String.valueOf(item.getForks_count()));
        holderItem.tvStar.setText(String.valueOf(item.getStargazers_count()));
        holderItem.tvUsername.setText(item.getOwner().getLogin());
        holderItem.tvUserFullName.setText(item.getFull_name());

        if (mItems.get(position).getOwner().getAvatar_url() != null) {
            final int patternSizeImg = 420;
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(mItems.get(position).getOwner().getAvatar_url()))
                    .setResizeOptions(new ResizeOptions(patternSizeImg, patternSizeImg))
                    .build();
            holderItem.ivUser.setController(
                    Fresco.newDraweeControllerBuilder()
                            .setOldController(holderItem.ivUser.getController())
                            .setImageRequest(request)
                            .build());
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class AppViewHolder extends RecyclerView.ViewHolder {
        public AppViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ItemViewHolder extends AppViewHolder {

        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_description)
        TextView tvDescription;
        @BindView(R.id.tv_fork)
        TextView tvFork;
        @BindView(R.id.tv_star)
        TextView tvStar;
        @BindView(R.id.iv_user)
        SimpleDraweeView ivUser;
        @BindView(R.id.tv_username)
        TextView tvUsername;
        @BindView(R.id.tv_user_fullname)
        TextView tvUserFullName;

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
