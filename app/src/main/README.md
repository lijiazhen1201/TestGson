# TestGson
## 练习Gson解析json数据

**Gson的jar包下载**

[https://code.google.com/p/google-gson/](https://code.google.com/p/google-gson/)

1. 将下载好的jar包导入自己工程中

2. 解析的数据类型

* 类型一:`JavaBean`

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

* 类型二:`List<JavaBean>`

	    private Gson gson;
	    private List<Person> list, newList;
	    private String json;
	
	    private void initGson(){
	        // 初始化Gson对象
	        gson = new Gson();
	        // 初始化实体bean
	        Person person1 = new Person(1, "张三", '男', true);
	        Person person2 = new Person(2, "李四", '女', false);
	        Person person3 = new Person(2, "王五", '男', true);
	        // 初始化List集合，实体bean放入List中
	        list = new ArrayList<Person>();
	        list.add(person1);
	        list.add(person2);
	        list.add(person3);
	        // 将List<Bean>转化为json字符串
	        json = gson.toJson(list);
	        // 将json字符串解析成List<Bean>
	        Type typeOfT = new TypeToken<List<Person>>() {
	        }.getType();
	        newList = gson.fromJson(json, typeOfT);
	    }

* 类型三:`List<String>`

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

* 类型四:`List<Map<String,Object>>`

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

* 类型五:`网络数据`

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
	    
	**千万要注意添加访问网络的权限**
	
	`<uses-permission android:name="android.permission.INTERNET"/>`