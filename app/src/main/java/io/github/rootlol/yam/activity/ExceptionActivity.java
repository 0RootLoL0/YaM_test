/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import io.github.rootlol.yam.R;

public class ExceptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);
        Bundle arguments = getIntent().getExtras();
        String error = arguments.get("error").toString();
        String json = arguments.get("json").toString();
        ((TextView) findViewById(R.id.textView6)).setText(json);
        ((TextView) findViewById(R.id.textView5)).setText(error);
    }
}