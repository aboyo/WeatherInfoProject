WeatherInfoProject  
===================
###利用YAHOO Weather API取得氣象資訊:
* [YQL](https://developer.yahoo.com/weather/documentation.html) 
* [Yahoo developer](https://developer.yahoo.com/weather/)

###STEP:
* Add permission:
```xml
    <uses-permission android:name="android.permission.INTERNET" />
```
* gradle:
```
    compile 'com.mcxiaoke.volley:library:1.0.+'
    compile 'com.google.code.gson:gson:2.+'
```
* 使用:
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ...
        YWeather yWeather = new YWeather(this, this); //context, callback
        yWeather.getWeather("竹北市"); //pseudo
    }
    ...
    
    @Override
    public void onSuccess(WeatherInfo weatherInfo) {
        //weahterInfo格式參照Yahoo API json result格式
        //Log.i("ABO", "setWeatherInfo: "+weatherInfo.getmItem().getCondition().getTemp());
    }

    @Override
    public void onFail(VolleyError error) {

    }
```
