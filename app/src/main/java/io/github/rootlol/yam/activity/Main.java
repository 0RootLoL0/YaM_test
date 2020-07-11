/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.support.RouterPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.R;
import io.github.rootlol.yam.controller.HomeController;
import io.github.rootlol.yandexmusic.ApiMusic;
import io.github.rootlol.yandexmusic.converter.YamConverterFactory;

public class Main extends AppCompatActivity implements YamConverterFactory.CallbackConverter{

    private Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiMusic.getInstance(this::JsonErrorParse);
        ViewGroup container = findViewById(R.id.a_main_chflayout_container);

        router = Conductor.attachRouter(this, container, savedInstanceState);
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(new HomeController()));
        }

    }

    @Override
    public void onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed();
        }
    }

    @Override
    public void JsonErrorParse(String e, String json) {
        Intent intent = new Intent(App.getInstance(), ExceptionActivity.class);
        intent.putExtra("error", e);
        intent.putExtra("json", json);
        startActivity(intent);
        finish();
    }
}
