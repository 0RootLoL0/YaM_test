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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bluelinelabs.conductor.Controller;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.R;
import io.github.rootlol.yam.adapter.track.TrackDSFactory;
import io.github.rootlol.yamadapter.YamAdapter;

@SuppressLint("ValidController")
public class TrackeController extends Controller {
    ImageView cover;
    TextView name;
    RecyclerView list;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_tracke, container, false);
        bind(view);
        setView(false);
        return view;
    }
    private void bind(View view){
        cover = view.findViewById(R.id.c_track_iv_cover);
        name =  view.findViewById(R.id.c_track_tv_name);
        list = view.findViewById(R.id.c_track_rv_list);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        list.setHasFixedSize(true);
    }
    private void setView(boolean refresh){
        TrackDSFactory trackDSFactory = new TrackDSFactory();


        YamAdapter adapter = new YamAdapter((AppCompatActivity) getActivity(), trackDSFactory, App.getConfig());
        list.setAdapter(adapter);
    }
}
