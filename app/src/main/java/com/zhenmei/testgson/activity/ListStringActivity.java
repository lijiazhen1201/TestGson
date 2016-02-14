package com.zhenmei.testgson.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhenmei.testgson.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenmei on 16/2/14.
 */
public class ListStringActivity extends BaseActivity implements View.OnClickListener{

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
    private List<String> list, newList;
    private String json;

    private void initGson(){
        // 初始化Gson对象
        gson = new Gson();
        // 初始化List集合，String放入List中
        list = new ArrayList<String>();
        list.add("zhang3");
        list.add("li4");
        list.add("wang5");
        // 将List<String>转化为json字符串
        json = gson.toJson(list);
        // 将json字符串解析成List<String>
        Type typeOfT = new TypeToken<List<String>>() {
        }.getType();
        newList = gson.fromJson(json, typeOfT);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btn_tojson:
                tvTojson.setText(json);
                break;
            case R.id.btn_fromjson:
                for (String s : newList) {
                    tvFromjson.setText(tvFromjson.getText().toString() + "\n" + s);
                }
                break;
            default:
                break;
        }
    }

}