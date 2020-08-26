package com.muneiah.retrofitconfig;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context ctx;
    List<Repo> list;

    public MyAdapter(Context ctx, List<Repo> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ctx).inflate(R.layout.each_row_design,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.Builder builder = new Picasso.Builder(ctx);
        builder.downloader(new OkHttp3Downloader(ctx));
        builder.build().load(list.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.myImage);
        holder.myTextView.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView myImage;
        TextView myTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage=itemView.findViewById(R.id.iv);
            myTextView=itemView.findViewById(R.id.tv);
        }
    }
}
