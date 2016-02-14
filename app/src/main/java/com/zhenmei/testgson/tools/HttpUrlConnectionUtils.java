package com.zhenmei.testgson.tools;


import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhenmei on 16/2/14.
 */
public class HttpUrlConnectionUtils {

    // 用get请求来访问
    public static String httpUrlGet(String URL, Map<String, Object> map) {
        String result = "";
        // 拼接地址
        String newURL = URL + "?" + checkMap(map);
        try {
            // 创建url
            URL url = new URL(newURL);
            // 利用url打开一个连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置连接方式为get
            conn.setRequestMethod("GET");
            // 获取输入流，转换成缓冲流方便读取
            InputStream in = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            // 判断连接是否成功
            if (conn.getResponseCode() == 200) {
                String line = "";
                while ((line = reader.readLine()) != null) {
                    // 拼接结果
                    result += line;
                }
            } else {// 访问失败
                Log.i("info", "HttpUrlConnectionGet方式请求失败");
                result = "请求失败";
            }
            // 关闭流
            in.close();
            // 断开连接
            conn.disconnect();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    // 用post请求来访问
    public static String httpUrlPost(String URL, Map<String, Object> map) {
        String result = "";
        try {
            // 创建url
            URL url = new URL(URL);
            // 利用url打开一个连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置连接方式为post
            conn.setRequestMethod("POST");
            // 设置可以向外输出信息，也可以接收信息
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 设置请求头信息
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Charset", "utf-8");
            // 要发送的信息
            String data = checkMap(map);
            // 设置数据内容的长度
            conn.setRequestProperty("Content-Length", String.valueOf(data.getBytes().length));
            // 获取输出流，发送信息给服务器
            OutputStream out = conn.getOutputStream();
            out.write(data.getBytes());
            out.flush();
            // 获取输入流，转换成缓冲流方便读取
            InputStream in = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            // 判断连接是否成功
            if (conn.getResponseCode() == 200) {
                String line = "";
                while ((line = reader.readLine()) != null) {
                    // 拼接结果
                    result += line;
                }
            } else {// 访问失败
                Log.i("info", "HttpUrlConnectionPost方式请求失败");
                result = "请求失败";
            }
            // 关闭流
            in.close();
            // 断开连接
            conn.disconnect();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    // Map拼接成数据
    private static String checkMap(Map<String, Object> map) {
        String data = "";
        Set<String> set = map.keySet();
        for (String key : set) {
            data = data + key + "=" + map.get(key) + "&";
        }
        data = data.substring(0, data.length() - 1);
        return data;
    }

}

