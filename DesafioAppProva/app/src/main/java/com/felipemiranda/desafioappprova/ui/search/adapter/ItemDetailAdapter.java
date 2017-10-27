package com.felipemiranda.desafioappprova.ui.search.adapter;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.felipemiranda.desafioappprova.R;
import com.felipemiranda.desafioappprova.model.ItemDetail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.felipemiranda.desafioappprova.utils.Utils.getDate;

/**
 * Created by felipemiranda on 26/10/17.
 */

public class ItemDetailAdapter extends RecyclerView.Adapter<ItemDetailAdapter.AppViewHolder> {

    private ArrayList<ItemDetail> mItems;
    private OnClickItem mOnClickItem;

    public ItemDetailAdapter(ArrayList<ItemDetail> itemDetails, OnClickItem onClickItem) {
        this.mItems = itemDetails;
        this.mOnClickItem = onClickItem;
    }

    public interface OnClickItem {
        void onClickItem(String url);
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        final ItemDetail item = mItems.get(holder.getAdapterPosition());
        ItemViewHolder holderItem = (ItemViewHolder) holder;

        holderItem.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItem.onClickItem(item.getHtml_url());
            }
        });

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String date = sFormat.format(getDate(item.getCreated_at()));

        holderItem.tvDate.setText(date);
        holderItem.tvUsername.setText(item.getUser().getLogin() != null ? item.getUser().getLogin() : "");
        holderItem.tvName.setText(item.getTitle() != null ? item.getTitle() : "");
        holderItem.tvDescription.setText(item.getBody() != null ? item.getBody() : "");

        if (mItems.get(position).getUser().getAvatar_url() != null) {
            final int patternSizeImg = 420;
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(mItems.get(position).getUser().getAvatar_url()))
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
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_description)
        TextView tvDescription;
        @BindView(R.id.iv_user)
        SimpleDraweeView ivUser;
        @BindView(R.id.tv_username)
        TextView tvUsername;
        @BindView(R.id.item)
        LinearLayout item;

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
