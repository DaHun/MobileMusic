package test.dahun.mobileplay.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import test.dahun.mobileplay.R;
import test.dahun.mobileplay.tab.VideoFragment;
import test.dahun.mobileplay.viewholder.MovieViewHolder;
import test.dahun.mobileplay.viewholder.PictureViewHolder;

/**
 * Created by jeongdahun on 2017. 6. 26..
 */

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieViewHolder>{

    Context context;
    VideoFragment.YoutubeListener youtubeListener;

    public static final String API_KEY = "AIzaSyDi54gnjDssDmXAfG1X-rJs4OmuYjH8iGM";


    public MovieRecyclerViewAdapter(Context context, VideoFragment.YoutubeListener youtubeListener){
        this.context=context;
        this.youtubeListener=youtubeListener;
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_movie,parent,false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, final int position) {
        switch(position){
            case 0:
                //


                holder.mv_thumb.initialize(API_KEY, new YouTubeThumbnailView.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
                        youTubeThumbnailLoader.setVideo("42Gtm4-Ax2U");
                        youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                            @Override
                            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                                youTubeThumbnailLoader.release();
                            }

                            @Override
                            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                            }
                        });
                    }

                    @Override
                    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });
                //
                holder.mv_title.setText("[Teaser 1] IU(아이유)_The shower(푸르던)");
                holder.mv_exp.setText("Album_ CHAT-SHIRE\n" +
                        "Release Date_ 2017.03.21\n" +
                        "Play Time_ 00:45");
                break;
            case 1:

                holder.mv_thumb.initialize(API_KEY, new YouTubeThumbnailView.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
                        youTubeThumbnailLoader.setVideo("Dtt0Gp78uuE");
                        youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                            @Override
                            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                                youTubeThumbnailLoader.release();
                            }

                            @Override
                            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                            }
                        });
                    }

                    @Override
                    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });
                holder.mv_title.setText("[Teaser 1] IU(아이유)_The shower(푸르던2)");
                holder.mv_exp.setText("Album_ CHAT-SHIRE\n" +
                        "Release Date_ 2017.03.21\n" +
                        "Play Time_ 00:45");

                break;

        }
        holder.mv_play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youtubeListener.startYoutube(position);
            }
        });

        holder.mv_share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"공유"+ position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
       return 2;
    }
}
