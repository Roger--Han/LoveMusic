package com.example.roger.lovemusic;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by roger on 10/04/17.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

       // Place the view you wanna recycle here

       public TextView title, count;
       public ImageView thumbnail, overflow;

       public MyViewHolder(View itemView) {
           super(itemView);
           title = (TextView) itemView.findViewById(R.id.title);
           count = (TextView) itemView.findViewById(R.id.count);
           thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
           overflow = (ImageView) itemView.findViewById(R.id.overflow);

       }
   }
}
