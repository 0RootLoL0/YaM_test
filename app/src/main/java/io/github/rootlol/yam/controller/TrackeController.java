/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;

import io.github.rootlol.yam.R;
import io.github.rootlol.yandexmusic.pojo.feed.GeneratedPlaylist;

public class TrackeController extends Controller {

    public TrackeController(GeneratedPlaylist model) {
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_tracke, container, false);
        return view;
    }
}
