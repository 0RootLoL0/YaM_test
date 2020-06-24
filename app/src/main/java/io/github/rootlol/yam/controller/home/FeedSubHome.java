/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.controller.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;

import io.github.rootlol.yam.R;

public class FeedSubHome extends Controller {

    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_feed, container, false);

        return view;
    }

}
