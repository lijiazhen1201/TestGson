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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenmei on 16/2/14.
 */
public class ListMapActivity extends BaseActivity implements View.OnClickListener{

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
    private List<Map<String, Object>> list, newList;
    private String json;

    private void initGson(){
        // 初始化Gson对象
        gson = new Gson();
        // 初始化Map<String,Object>
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("id", 1);
        map1.put("name", "张三");
        map1.put("sex", '男');
        map1.put("isMarried", true);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", 2);
        map2.put("name", "李四");
        map2.put("sex", '女');
        map2.put("isMarried", false);
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("id", 3);
        map3.put("name", "王五");
        map3.put("sex", '男');
        map3.put("isMarried", true);
        // 初始化List<Map<String,Object>>，将map放入List
        list = new ArrayList<Map<String, Object>>();
        list.add(map1);
        list.add(map2);
        list.add(map3);
        // 将List转化为json字符串
        json = gson.toJson(list);
        // 将json字符串解析成List
        Type typeOfT = new TypeToken<List<Map<String, Object>>>() {
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
                tvFromjson.setText(newList.toString());
                break;
            default:
                break;
        }
    }

}
