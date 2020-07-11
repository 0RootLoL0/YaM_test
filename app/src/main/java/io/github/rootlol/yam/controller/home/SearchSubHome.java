/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.controller.home;

import android.accounts.AccountManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bluelinelabs.conductor.Controller;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.R;
import io.github.rootlol.yam.account.AccountUtils;
import io.github.rootlol.yam.adapter.search.SearchDSFactory;
import io.github.rootlol.yamadapter.YamAdapter;
import io.github.rootlol.yamsearchautocomplete.DelayAutoCompleteTextView;
import io.github.rootlol.yamsearchautocomplete.SearchAutoCompleteAdapterTool;

public class SearchSubHome extends Controller {

    private RecyclerView PRV;
    private static TextView NR;

    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_search, container, false);
        bind(view);
        return view;
    }
    private void bind(View view){
        NR = view.findViewById(R.id.textView3);

        PRV = view.findViewById(R.id.recyclerView);
        PRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        PRV.setHasFixedSize(true);

        DelayAutoCompleteTextView searchTextedit = view.findViewById(R.id.c_home_search_et_search);
        searchTextedit.setThreshold(4);
        searchTextedit.setAdapter(new SearchAutoCompleteAdapterTool(getApplicationContext(), AccountManager.get(getApplicationContext()).peekAuthToken(App.getAccount(), AccountUtils.AUTH_TOKEN_TYPE)));
        searchTextedit.setLoadingIndicator((ProgressBar) view.findViewById(R.id.c_home_search_pb_search));
        searchTextedit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String book = (String) adapterView.getItemAtPosition(position);
                setListSearch(book);
                searchTextedit.setText(book);
            }
        });

        ImageButton searchButton = view.findViewById(R.id.c_home_search_ib_searchbutton);
        searchButton.setOnClickListener((v) -> {
            setListSearch(searchTextedit.getText().toString());
        });
    }
    private void setListSearch(String textSearch){
        SearchDSFactory searchDSFactory = new SearchDSFactory(getApplicationContext(), textSearch);
        YamAdapter adapter = new YamAdapter((AppCompatActivity) getActivity(), searchDSFactory, App.getConfig());
        PRV.setAdapter(adapter);
    }
    public static void visibilityNR(boolean v){
        if (v) {
            NR.setVisibility(View.VISIBLE);
        }
        NR.setVisibility(View.INVISIBLE);
    }
}