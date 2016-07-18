package com.study.mgx.qqnewfun.androidM;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.study.mgx.qqnewfun.util.UiCallback;

import java.io.IOException;

import cn.itcast.wh.androidm.R;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class HttpActivity extends Activity {
    OkHttpClient okHttpClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
    }


    public void sentGet(View v) {
        // 如何使用OkHttp
//        1. 创建OkHttpClient对象（一般单例）
//        OkHttpClient okHttpClient = new OkHttpClient();
//        2. 创建请求对象
        Request request =
                new Request.Builder()
                        .get()// 指定get方式
                        .url("http://10.0.2.2:8080/simple/get") // 指定网址
                        .build(); // 构建请求对象

        // 3. 利用okHttpClient发送请求：
        okHttpClient.newCall(request).enqueue(callback);
//        Call call = okHttpClient.newCall(request);  // 创建出一个网络调用
// 执行调用
//        Response response = call.execute();  //call.execute() 是同步调用，在android中需要在子线程去执行
//        call.enqueue(callback);              // call.enqueue(callback);     是异步调用，网络请求会在子线程去执行，执行的结果会发送到callback中
    }

    ;

    public void sentPost(View v) {

        // 创建post消息体, RequestBody是抽象类，FormBody是表单，MultipartBody是上传文件
        RequestBody requestBody = new FormBody.Builder()
                .add("class", "wh13")   // 添加表单字段和值
                .add("company", "itcast")
                .add("date", "2016-01-09")
                .build();
        // 创建post请求
        Request request = new Request.Builder()
                .post(requestBody)
                .url("http://10.0.2.2:8080/simple/post")
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public void postJson(View v) {

//        MediaType type = new MediaType("application/json","application","json", "utf-8");
        MediaType type = MediaType.parse("application/json; charset=utf-8");
        String json = "{\"class\":\"wh13\",\"company\":\"itcast\",\"b\":true,\"int\":10}";
        RequestBody body = RequestBody.create(type, json);
        Request request = new Request.Builder().post(body).url("http://10.0.2.2:8080/simple/json").build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    /*


   // 4 实现回调
   // callback中的方法不会在主线程执行
   private Callback callback = new Callback() {
       // 失败会调用此方法
       @Override
       public void onFailure(Request request, IOException e) {
           Log.e("onFailure", request.toString());
       }

       // 当获得服务器的相应后会调用此方法，为什么不叫成功呢？ 对于成功的定义不一样，有些情况任务2** 才是成功，有的3** 也算成功
       @Override
       public void onResponse(Response response) throws IOException {
           Log.e("onResponse", response.toString());
//            判断是否是真的成功了 [200,300)
           if (response.isSuccessful()) {
               // 打印响应的正文
               String body = response.body().string();
               Log.d("onResponse", body);
               // 不能在这里做UI相关操作，因为还是子线程
//                Toast.makeText(MainActivity.this, body,Toast.LENGTH_SHORT).show();
           }
       }
   };
      */
    private Callback callback = new UiCallback() {
        @Override
        public void onUiFailure(Request request, IOException e) {
            Toast.makeText(HttpActivity.this, " onUiFailure \n" + request.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onUiResponse(Response response) throws IOException {
            Toast.makeText(HttpActivity.this, " onUiResponse \n" + response.toString(), Toast.LENGTH_SHORT).show();
        }
    };
}
