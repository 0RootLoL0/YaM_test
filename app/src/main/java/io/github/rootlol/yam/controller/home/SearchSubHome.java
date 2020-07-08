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
import android.widget.ProgressBar;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.R;
import io.github.rootlol.yam.account.AccountUtils;
import io.github.rootlol.yamsearchautocomplete.DelayAutoCompleteTextView;
import io.github.rootlol.yamsearchautocomplete.SearchAutoCompleteAdapterTool;

public class SearchSubHome extends Controller {

    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_search, container, false);
        bind(view);
        return view;
    }
    private void bind(View view){
        DelayAutoCompleteTextView searchTextedit = view.findViewById(R.id.c_home_search_et_search);
        searchTextedit.setThreshold(4);
        searchTextedit.setAdapter(new SearchAutoCompleteAdapterTool(getApplicationContext(), AccountManager.get(getApplicationContext()).peekAuthToken(App.getAccount(), AccountUtils.AUTH_TOKEN_TYPE)));
        searchTextedit.setLoadingIndicator((ProgressBar) view.findViewById(R.id.c_home_search_pb_search));
        searchTextedit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String book = (String) adapterView.getItemAtPosition(position);
                searchTextedit.setText(book);
            }
        });
    }
}