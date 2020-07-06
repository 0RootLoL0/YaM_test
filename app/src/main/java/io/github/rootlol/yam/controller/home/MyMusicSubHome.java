/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.controller.home;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.bluelinelabs.conductor.Controller;

import io.github.rootlol.yam.R;
import io.github.rootlol.yam.activity.Main;
import io.github.rootlol.yam.activity.Settings;

import static io.github.rootlol.yam.App.APP_ID;


public class MyMusicSubHome extends Controller implements Toolbar.OnMenuItemClickListener {

    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_mymusic, container, false);
        bind(view);
        return view;
    }
    private void bind(View view){

        Toolbar toolbar = view.findViewById(R.id.c_home_mymusic_toolbar_setting);
        toolbar.setTitle(R.string.tab_mymusic);
        toolbar.inflateMenu(R.menu.menu_mymusic);
        toolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.m_mymusic_settings:
                startActivity(new Intent(getActivity(), Settings.class));
                break;
        }
        return false;
    }
}