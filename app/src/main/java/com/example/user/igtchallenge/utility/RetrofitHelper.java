package com.example.user.igtchallenge.utility;

import com.example.user.igtchallenge.model.GameList;
import com.example.user.igtchallenge.model.Player;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by User on 4/26/2017.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "https://dl.dropboxusercontent.com/s/";


    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            return originalResponse.newBuilder()
                    .header("Cache-Control", String.format("max-age=%d, only-if-cached, max-stale=%d", 120, 120))
                    .build();
        }
    };

    public static Retrofit create() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

//        //setup cache
//        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
//        int cacheSize = 10 * 1024 * 1024; // 10 MiB
//        Cache cache = new Cache(httpCacheDirectory, cacheSize);
//
////add cache to the client

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .build();
//        client.cache(cache);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit;

    }

    public static Observable<Player> createPlayerObs() {

        Retrofit retrofit = create();
        RetroFitService service = retrofit.create(RetroFitService.class);
        return service.getPlayerInfo();
    }

    public static Observable<GameList> createGameListObs() {
        Retrofit retrofit = create();
        RetroFitService service = retrofit.create(RetroFitService.class);
        return service.getGameList();

    }


    interface RetroFitService {

        @GET("5zz3hibrxpspoe5/playerInfo.json")
        Observable<Player> getPlayerInfo();

        @GET("2ewt6r22zo4qwgx/gameData.json")
        Observable<GameList> getGameList();

    }
}


