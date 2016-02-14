package com.zhenmei.testgson.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhenmei.testgson.R;
import com.zhenmei.testgson.bean.Person;

/**
 * Created by zhenmei on 16/2/14.
 */
public class BeanActivity extends BaseActivity implements View.OnClickListener{

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
    private Person person, newPerson;
    private String json;

    private void initGson(){
        //初始化Gson对象
        gson = new Gson();
        //初始化实体bean
        person = new Person(1, "张三", '男', true);
        //实体bean转化为json的字符串
        json = gson.toJson(person);
        //json字符串解析成实体bean
        newPerson = gson.fromJson(json, Person.class);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btn_tojson:
                tvTojson.setText(json);
                break;
            case R.id.btn_fromjson:
                tvFromjson.setText(newPerson.toString());
                break;
            default:
                break;
        }
    }

}