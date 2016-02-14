package com.zhenmei.testgson.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhenmei.testgson.R;

/**
 * Created by zhenmei on 16/2/14.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private Button btnBean;
    private Button btnListbean;
    private Button btnListstring;
    private Button btnListmap;
    private Button btnListjoke;

    private void initView() {
        btnBean = (Button) findViewById(R.id.btn_bean);
        btnListbean = (Button) findViewById(R.id.btn_listbean);
        btnListstring = (Button) findViewById(R.id.btn_liststring);
        btnListmap = (Button) findViewById(R.id.btn_listmap);
        btnListjoke = (Button) findViewById(R.id.btn_listjoke);

        btnBean.setOnClickListener(this);
        btnListbean.setOnClickListener(this);
        btnListstring.setOnClickListener(this);
        btnListmap.setOnClickListener(this);
        btnListjoke.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bean:
                startNextActivity(BeanActivity.class);
                break;
            case R.id.btn_listbean:
                startNextActivity(ListBeanActivity.class);
                break;
            case R.id.btn_liststring:
                startNextActivity(ListStringActivity.class);
                break;
            case R.id.btn_listmap:
                startNextActivity(ListMapActivity.class);
                break;
            case R.id.btn_listjoke:
                startNextActivity(JokeActivity.class);
                break;
            default:
                break;
        }
    }
}
