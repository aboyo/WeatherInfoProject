package com.example.abo.weatherinfoproject.yahooweatherservice;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Abo on 2017/1/5.
 */

public class YWeather {
    Context context;
    WeatherCallBack callBack;
    public YWeather(Context context, WeatherCallBack callBack){
        this.context = context;
        this.callBack = callBack;
    }

    public void getWeather(String woeid){

        String unit = "c";
        String location = woeid;

        String YQL = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\") and u='" + unit + "'", location);
        String endpoint = String.format("https://query.yahooapis.com/v1/public/yql?q=%s&format=json", Uri.encode(YQL));

        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest getRequest = new StringRequest(endpoint,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            String str;
                            str = new JSONObject(s).getString("query");
                            str = new JSONObject(str).getString("results");
                            str = new JSONObject(str).getString("channel");

                            Gson gson = new Gson();
                            WeatherInfo w = gson.fromJson(str, WeatherInfo.class);
                            JSONObject jobj = new JSONObject(str);
                            str = jobj.getString("units");
                            w.setmUnits(gson.fromJson(str, WeatherInfo.Units.class));
                            str = jobj.getString("location");
                            w.setmLocation(gson.fromJson(str, WeatherInfo.Location.class));
                            str = jobj.getString("wind");
                            w.setmWind(gson.fromJson(str, WeatherInfo.Wind.class));
                            str = jobj.getString("atmosphere");
                            w.setmAtmosphere(gson.fromJson(str, WeatherInfo.Atmosphere.class));
                            str = jobj.getString("astronomy");
                            w.setmAstronomy(gson.fromJson(str, WeatherInfo.Astronomy.class));
                            str = jobj.getString("image");
                            w.setmImage(gson.fromJson(str, WeatherInfo.Image.class));
                            str = jobj.getString("item");

                            w.setmItem(gson.fromJson(str, WeatherInfo.Item.class));
                            String conditionStr = new JSONObject(str).getString("condition");
                            w.getmItem().setCondition(gson.fromJson(conditionStr, WeatherInfo.Item.Condition.class));

                            String forecastStr = new JSONObject(str).getString("forecast");
                            w.getmItem().setForecast(gson.fromJson(forecastStr, WeatherInfo.Item.Forecast[].class));
                            callBack.onSuccess(w);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callBack.onFail(error);
                    }
                });
        mQueue.add(getRequest);
    }

    public interface WeatherCallBack {
        void onSuccess(WeatherInfo weatherInfo);
        void onFail(VolleyError error);
    }
}
