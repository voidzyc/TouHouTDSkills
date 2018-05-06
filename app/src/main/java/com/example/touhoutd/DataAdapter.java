package com.example.touhoutd;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    Context context;

    private List<AvatarIcon> mAvatarIconList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatariconImage;

        public ViewHolder(View view) {
            super(view);
            avatariconImage = (ImageView) view.findViewById(R.id.avataricon_image);
        }
    }

    public DataAdapter(Context context, List<AvatarIcon> avatarIconList) {
        this.context = context;
        this.mAvatarIconList = avatarIconList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.avataricon_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.avatariconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                AvatarIcon avataricon = mAvatarIconList.get(position);
                Intent intent = new Intent(v.getContext(), SkillActivity.class);
                intent.putExtra("extra_name", avataricon.getName());
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AvatarIcon avataricon = mAvatarIconList.get(position);
        holder.avatariconImage.setImageResource(avataricon.getImageId());

        LinearLayout.LayoutParams layoutParams =
                (LinearLayout.LayoutParams) holder.avatariconImage.getLayoutParams();

        float itemWidth = (ScreenUtils.getScreenWidth(holder.itemView.getContext()) - 30 * 5) / 4;
        layoutParams.width = (int) itemWidth;
        float scale = (itemWidth + 0f) / avataricon.getWidth();
        layoutParams.height = (int) (avataricon.getHeight() * scale);
        holder.avatariconImage.setLayoutParams(layoutParams);

        RequestOptions myOptions = new RequestOptions()
                .fitCenter()
                .override(layoutParams.width, layoutParams.height);

        Glide.with(context)
                .load(avataricon.getImageId())
                .apply(myOptions)
                .into(holder.avatariconImage);
    }

    @Override
    public int getItemCount() {
        return mAvatarIconList.size();
    }
}
