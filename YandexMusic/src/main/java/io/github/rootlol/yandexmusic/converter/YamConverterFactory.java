/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yandexmusic.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.github.rootlol.yandexmusic.converter.response.SearchResponse;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class YamConverterFactory extends Converter.Factory {
    public CallbackConverter callbackConverter;
    public interface CallbackConverter{
        void JsonErrorParse(String e, String json);
    }


    public static YamConverterFactory create(CallbackConverter callback){
        YamConverterFactory factory = new YamConverterFactory();
        factory.callbackConverter = callback;
        return factory;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == SearchResponse.class) return new SearchConverter(callbackConverter);
        return null;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return null;
    }
}

