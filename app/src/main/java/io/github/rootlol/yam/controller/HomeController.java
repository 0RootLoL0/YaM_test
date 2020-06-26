/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.support.RouterPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import io.github.rootlol.yam.R;
import io.github.rootlol.yam.controller.home.FeedSubHome;
import io.github.rootlol.yam.controller.home.MyMusicSubHome;
import io.github.rootlol.yam.controller.home.RadioSubHome;
import io.github.rootlol.yam.controller.home.SearchSubHome;

public class HomeController extends Controller {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private static HomeController intens;

    private final RouterPagerAdapter pagerAdapter;
    private static final int[] TAB_TITLES = new int[]{R.string.tab_feed, R.string.tab_radio, R.string.tab_mymusic, R.string.tab_search};

    public HomeController() {
        intens = this;
        this.pagerAdapter = new RouterPagerAdapter(this) {
            @Override
            public void configureRouter(@NonNull Router router, int position) {
                if (!router.hasRootController()) {
                    Controller page;
                    switch (position){
                        case 0:
                            page = new FeedSubHome();
                            break;
                        case 1:
                            page = new RadioSubHome();
                            break;
                        case 2:
                            page = new MyMusicSubHome();
                            break;
                        default:
                            page = new SearchSubHome();
                    }
                    router.setRoot(RouterTransaction.with(page));
                }
            }

            @Override
            public int getCount() {
                return TAB_TITLES.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getApplicationContext().getResources().getString(TAB_TITLES[position]);
            }
        };
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home, container, false);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    public static HomeController getIntens() {
        return intens;
    }
}
