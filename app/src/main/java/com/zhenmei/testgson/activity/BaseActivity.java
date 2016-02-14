package com.zhenmei.testgson.activity;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by zhenmei on 16/2/14.
 */
public class BaseActivity extends Activity {

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private final int info = 0;
    private final String tag = "info";

    public void printInfo(String msg) {
        if (info == 0) {
            Log.i(tag, msg);
        }
    }

    public void startNextActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
