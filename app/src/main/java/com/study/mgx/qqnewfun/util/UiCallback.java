package com.study.mgx.qqnewfun.util;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

/**
 * // 主线程的Callback
 */
public abstract class UiCallback implements okhttp3.Callback {
    @Override
    public void onFailure(final Request request, final IOException e) {
        getUiHandler().post(new Runnable() {
            @Override
            public void run() {
                onUiFailure(request, e);
            }
        });
    }

    @Override
    public void onResponse(final Response response) throws IOException {
        getUiHandler().post(new Runnable() {
            @Override
            public void run() {
                try {
                    onUiResponse(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public abstract void onUiFailure(Request request, IOException e) ;


    public abstract void onUiResponse(Response response) throws IOException;

    static Handler  handlerInstance ;
    private  static Handler getUiHandler (){
        if(handlerInstance ==null){
            synchronized(UiCallback.class){
                if(handlerInstance ==null){
//                    在哪个线程中创建Handler，就在哪个线程执行runnable
//                    handlerInstance =  new Handler();

                    handlerInstance = new Handler(Looper.getMainLooper());
                }
            }
        }
        return handlerInstance;
    };
}
