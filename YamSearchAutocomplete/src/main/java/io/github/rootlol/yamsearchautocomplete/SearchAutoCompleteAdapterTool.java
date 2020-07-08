/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yamsearchautocomplete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yandexmusic.ApiMusic;

public class SearchAutoCompleteAdapterTool extends BaseAdapter implements Filterable {

    private static final int MAX_RESULTS = 10;

    private final Context mContext;
    private List<String> mResults;
    private String token;

    public SearchAutoCompleteAdapterTool(Context mContext, String token) {
        this.mContext = mContext;
        mResults = new ArrayList<String>();
        this.token = token;
    }

    @Override
    public int getCount() {
        return mResults.size();
    }

    @Override
    public String getItem(int position) {
        return mResults.get(position);    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.adapter_auc_search, parent, false);
        }
        String info = getItem(position);
        ((TextView) convertView.findViewById(R.id.text1)).setText(info);

        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter(){
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    List<String> books = new ArrayList<>();
                    try {
                        JSONObject jsonobj = ApiMusic.getInstance().getSearchSuggest(token, constraint.toString()).execute().body();
                        JSONObject result = (JSONObject) jsonobj.get("result");
                        JSONArray suggestions = (JSONArray) result.get("suggestions");
                        for (int i = 0; i < suggestions.size(); i++) {
                            String suggestion = (String) suggestions.get(i);
                            books.add(suggestion);
                        }
                        filterResults.values = books;
                        filterResults.count = suggestions.size();
                    } catch (IOException e) {
                        filterResults.values = books;
                        filterResults.count = 0;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    mResults = (List<String>) results.values;
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
        return filter;
    }
}
