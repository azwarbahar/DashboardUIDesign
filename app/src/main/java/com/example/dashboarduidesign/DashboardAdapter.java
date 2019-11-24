package com.example.dashboarduidesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by Muhammad Azwar Bahar on 24/11/19.
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.MyHolder> {

    private Context mContext;
    List<DashboardItem> dashboardItems;

    public DashboardAdapter(Context mContext, List<DashboardItem> dashboardItems) {
        this.mContext = mContext;
        this.dashboardItems = dashboardItems;
    }

    @NonNull
    @Override
    public DashboardAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_dashboard, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardAdapter.MyHolder holder, int position) {

        holder.title.setText(dashboardItems.get(position).getTitle());
        holder.poster.setImageResource(dashboardItems.get(position).getPoster());
        holder.image_bg.setImageResource(dashboardItems.get(position).getBackground());
    }

    @Override
    public int getItemCount() {
        return dashboardItems.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {


        private TextView title;
        private ImageView image_bg;
        private ImageView poster;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_item);
            image_bg = itemView.findViewById(R.id.image_bg);
            poster = itemView.findViewById(R.id.poster);
        }
    }
}
