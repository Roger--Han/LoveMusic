package com.example.roger.lovemusic;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.roger.lovemusic.AlbumModel.Album;

import java.util.List;


/**
 * Created by roger on 10/04/17.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context context;
    private List<Album> albumList;

    // Default constructor of AlbumsAdapter
    public AlbumsAdapter(Context context, List<Album> albumList) {

        this.context = context;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_card, parent, false);
        // Initialize MyViewHolder
        MyViewHolder myViewHolder = new MyViewHolder(rootView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Album album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getNumOfSongs() + " songs");

        // Loading album cover using Glide library

        Glide.with(context).load(album.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(holder.overflow);
            }
        });

    }

    /**
     * Show popup menu when tapping on 3 dots
     *
     */
    private void showPopupMenu(View view) {
        // Inflate menu
        final PopupMenu popupMenu = new PopupMenu(context, view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.menu, popupMenu.getMenu());
//

        popupMenu.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popupMenu.show();
    }

    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(context, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.action_play_next:
                    Toast.makeText(context, "Play next", Toast.LENGTH_SHORT).show();
                    return true;

                default:
            }
            return false;
        }
    }


    @Override
    public int getItemCount() {
        return albumList == null ? 0 : albumList.size();
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
