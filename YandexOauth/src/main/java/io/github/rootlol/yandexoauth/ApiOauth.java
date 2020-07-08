/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yandexoauth;

import org.json.simple.JSONObject;

import java.util.Map;

import io.github.rootlol.jsonsimpleconverter.JsonSimpleConverterFactory;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class ApiOauth {
    public interface Api {
        @FormUrlEncoded
        @POST("token")
        Call<JSONObject> login(@FieldMap Map<String, String> body);
    }

    private static String urlBase = "https://oauth.yandex.ru/";
    private static Retrofit retrofit;
    private static Api api;

    public static String CLIENT_ID = "23cabbbdc6cd418abb4b39c32c41195d";
    public static String CLIENT_SECRET = "53bc75238f0c4d08a118e51fe9203300";

    public static Api getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(JsonSimpleConverterFactory.create())
                    .baseUrl(urlBase)
                    .build();
        }
        api = retrofit.create(Api.class);
        return api;
    }
}
