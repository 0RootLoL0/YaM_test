/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.tools;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.rootlol.yam.App;
import io.github.rootlol.yamadapter.ItemDataCache;
import io.github.rootlol.yamadapter.YamAdapterInterface;
import io.github.rootlol.yamadapter.YamVHFactory;

public class CacheTool{
    public static void setCache(String typeCache, List<YamAdapterInterface> Listitem, YamVHFactory factory) throws IOException {
        App.getInstance().deleteFile(typeCache+"*");

        File.createTempFile(typeCache, null, App.getInstance().getCacheDir());
        File cacheFile = new File(App.getInstance().getCacheDir(), typeCache);
        Log.i(App.APP_ID, "toCache: path"+cacheFile.getPath());

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        BufferedWriter writer = new BufferedWriter(new FileWriter(cacheFile));
        writer.write(gson.toJson(factory.toDataCache(Listitem)));

        writer.close();


    }

    public static List<YamAdapterInterface> getCache(String typeCache, YamVHFactory factory) throws IOException {

        File cacheFile = new File(App.getInstance().getCacheDir(), typeCache);
        BufferedReader reader = new BufferedReader(new FileReader(cacheFile));

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        List<ItemDataCache> temp = Arrays.asList(gson.fromJson(reader.readLine(), ItemDataCache[].class));

        return factory.toListData(temp);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static long getTimeCache(String typeCache){
        File cacheFile = new File(App.getInstance().getCacheDir(), typeCache);
        BasicFileAttributes attributes = null;
        try {
            attributes = Files.readAttributes(cacheFile.toPath(), BasicFileAttributes.class );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return attributes.creationTime().to(TimeUnit.MILLISECONDS);
    }
}
