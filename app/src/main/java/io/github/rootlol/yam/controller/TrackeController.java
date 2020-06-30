/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.controller;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bluelinelabs.conductor.Controller;
import com.squareup.picasso.Picasso;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.R;
import io.github.rootlol.yam.tools.RoundedTransformation;
import io.github.rootlol.yandexmusic.pojo.feed.GeneratedPlaylist;

@SuppressLint("ValidController")
public class TrackeController extends Controller {

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_tracke, container, false);
        /*Toast.makeText(getApplicationContext(), model.getType(), Toast.LENGTH_LONG).show();


        Picasso.with(App.getInstance())
                .load("https://"+model.getData().getOgImage().replace("%%", "200x200"))
                .transform(new RoundedTransformation(16, 4))
                .into( ((ImageView) view.findViewById(R.id.imageView)) );

        ((TextView) view.findViewById(R.id.textView5)).setText(model.getData().getTitle());

        TrackAdapter adapter = new TrackAdapter();


        LiveData<PagedList<ItemTrack>> pagedListLiveData = new LivePagedListBuilder<>(new TrackDataSourseFactory(App.getModel()), App.getConfig()).build();
        pagedListLiveData.observe((AppCompatActivity) getActivity(), new Observer<PagedList<ItemTrack>>() {
            @Override
            public void onChanged(@Nullable PagedList<ItemTrack> playlistListInterfaces) {
                adapter.submitList(playlistListInterfaces);
            }
        });
        ((RecyclerView) view.findViewById(R.id.redf)).setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ((RecyclerView) view.findViewById(R.id.redf)).setHasFixedSize(true);

        ((RecyclerView) view.findViewById(R.id.redf)).setAdapter(adapter);*/
        return view;
    }
}
