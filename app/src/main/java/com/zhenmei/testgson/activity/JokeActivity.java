package com.zhenmei.testgson.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhenmei.testgson.R;
import com.zhenmei.testgson.bean.Joke;
import com.zhenmei.testgson.tools.HttpUrlConnectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenmei on 16/2/14.
 */
public class JokeActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        initView();
    }

    private Button btnTojson;
    private TextView tvTojson;
    private Button btnFromjson;
    private TextView tvFromjson;

    private void initView() {
        btnTojson = (Button) findViewById(R.id.btn_tojson);
        tvTojson = (TextView) findViewById(R.id.tv_tojson);
        btnFromjson = (Button) findViewById(R.id.btn_fromjson);
        tvFromjson = (TextView) findViewById(R.id.tv_fromjson);

        btnTojson.setOnClickListener(this);
        btnFromjson.setOnClickListener(this);

        initGson();
    }

    private Gson gson;
    private Joke joke;
    private String json;
    private String url = "http://api.1-blog.com/biz/bizserver/xiaohua/list.do";

    private void initGson() {
        // 初始化Gson对象
        gson = new Gson();
        //开启子线程访问网络
        new Thread(new Runnable() {
            @Override
            public void run() {
                //构造访问时的参数
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("size", 5 + "");
                //访问网络，获得json数据
                String json = HttpUrlConnectionUtils.httpUrlGet(url, map);
                //将json数据传给主线程
                Message msg = handler.obtainMessage();
                msg.what = 0;
                msg.obj = json;
                handler.sendMessage(msg);
            }
        }).start();

    }

    private Handler handler = new Handler() {
        public void dispatchMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0:
                    //接收子线程传来的数据
                    json = (String) msg.obj;
                    //将json数据解析成实体类
                    joke = gson.fromJson(json, Joke.class);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btn_tojson:
                tvTojson.setText(json);
                break;
            case R.id.btn_fromjson:
                tvFromjson.setText(parseJoke(joke));
                break;
            default:
                break;
        }
    }

    private String parseJoke(Joke joke) {
        String result = "";
        List<Joke.DetailEntity> list = joke.getDetail();
        for (Joke.DetailEntity d : list) {
            result += d.toString();
        }
        return result;
    }

}
