package com.example.abo.weatherinfoproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.abo.weatherinfoproject.yahooweatherservice.WeatherInfo;
import com.example.abo.weatherinfoproject.yahooweatherservice.YWeather;
import com.example.abo.weatherinfoproject.yahooweatherservice.YahooWeatherCodeMap;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements YWeather.WeatherCallBack {

    private ImageView weatherImg;
    private ArrayList<ImageView> forecastImgList;
    private TextView tempTv, cityTv, descTv, humidityTv, directionTv;
    private ArrayList<TextView> forecastDayTvList;
    private ArrayList<TextView> forecastTempTvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout weatherInfoLayout = (RelativeLayout) findViewById(R.id.weather_info_view);
        weatherImg = (ImageView) findViewById(R.id.weather_icon);
        tempTv = (TextView) findViewById(R.id.temp_textView);
        cityTv = (TextView) findViewById(R.id.city_textView);
        descTv = (TextView) findViewById(R.id.desc_textView);
        humidityTv = (TextView) findViewById(R.id.humidity_textView);
        directionTv = (TextView) findViewById(R.id.direction_textView);

        forecastImgList = new ArrayList<ImageView>();
        ImageView forecastImg1 = (ImageView) findViewById(R.id.forecastImageView1);
        forecastImgList.add(forecastImg1);
        ImageView forecastImg2 = (ImageView) findViewById(R.id.forecastImageView2);
        forecastImgList.add(forecastImg2);
        ImageView forecastImg3 = (ImageView) findViewById(R.id.forecastImageView3);
        forecastImgList.add(forecastImg3);
        ImageView forecastImg4 = (ImageView) findViewById(R.id.forecastImageView4);
        forecastImgList.add(forecastImg4);

        forecastDayTvList = new ArrayList<TextView>();
        TextView forecastDayTv1 = (TextView) findViewById(R.id.day_textView1);
        forecastDayTvList.add(forecastDayTv1);
        TextView forecastDayTv2 = (TextView) findViewById(R.id.day_textView2);
        forecastDayTvList.add(forecastDayTv2);
        TextView forecastDayTv3 = (TextView) findViewById(R.id.day_textView3);
        forecastDayTvList.add(forecastDayTv3);
        TextView forecastDayTv4 = (TextView) findViewById(R.id.day_textView4);
        forecastDayTvList.add(forecastDayTv4);

        forecastTempTvList = new ArrayList<TextView>();
        TextView forecastTempTv1 = (TextView) findViewById(R.id.temp_textView1);
        forecastTempTvList.add(forecastTempTv1);
        TextView forecastTempTv2 = (TextView) findViewById(R.id.temp_textView2);
        forecastTempTvList.add(forecastTempTv2);
        TextView forecastTempTv3 = (TextView) findViewById(R.id.temp_textView3);
        forecastTempTvList.add(forecastTempTv3);
        TextView forecastTempTv4 = (TextView) findViewById(R.id.temp_textView4);
        forecastTempTvList.add(forecastTempTv4);

        weatherInfoLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int h = weatherInfoLayout.getHeight();
                int w = weatherInfoLayout.getWidth();
                weatherImg.getLayoutParams().height = h / 2;
                weatherImg.getLayoutParams().width = h / 2;
                weatherInfoLayout.getViewTreeObserver()
                        .removeGlobalOnLayoutListener(this);

            }
        });

        final RelativeLayout forecastLayout = (RelativeLayout) findViewById(R.id.forecast_Layout);
        forecastLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int h = forecastLayout.getHeight();
                int w = forecastLayout.getWidth();
                int forecastImgHW = (int) ((w / 4) * 0.8);

                for (int i = 0; i < forecastImgList.size(); i++) {
                    forecastImgList.get(i).getLayoutParams().height = forecastImgHW;
                    forecastImgList.get(i).getLayoutParams().width = forecastImgHW;
                }

            }
        });

        YWeather yWeather = new YWeather(this, this);
        //pseudo
        yWeather.getWeather("竹北市");



    }


    @Override
    public void onSuccess(WeatherInfo weatherInfo) {

        //current
        weatherImg.setImageResource(YahooWeatherCodeMap.getWeatherIcon(weatherInfo.getmItem().getCondition().getCode()));
        tempTv.setText(weatherInfo.getmItem().getCondition().getTemp()+"\u00B0"+weatherInfo.getmUnits().getTemperature());
        cityTv.setText(weatherInfo.getmLocation().getCity());
        descTv.setText(weatherInfo.getmItem().getCondition().getText());
        humidityTv.setText("濕度 "+weatherInfo.getmAtmosphere().getHumidity()+"%");
        directionTv.setText("風向 "+weatherInfo.getmWind().getSpeed()+" "+weatherInfo.getmUnits().getSpeed()+", "+weatherInfo.getmWind().getDirection()+"");
        Log.i("ABO", "setWeatherInfo: "+weatherInfo.getmWind().getDirection());

        //forecast->show 4 days
        for (int i=1 ; i<=4 ; i++){
            forecastImgList.get(i-1).setImageResource(YahooWeatherCodeMap.getWeatherIcon(weatherInfo.getmItem().getForecast()[i].getCode()));
            forecastDayTvList.get(i-1).setText(weatherInfo.getmItem().getForecast()[i].getDay());
            forecastTempTvList.get(i-1).setText(weatherInfo.getmItem().getForecast()[i].getHigh()+"\u00B0"+weatherInfo.getmUnits().getTemperature());
        }
    }

    @Override
    public void onFail(VolleyError error) {

    }
}
