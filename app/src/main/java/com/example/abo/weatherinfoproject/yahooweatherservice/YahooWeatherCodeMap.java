package com.example.abo.weatherinfoproject.yahooweatherservice;

import com.example.abo.weatherinfoproject.R;

import java.util.HashMap;

/**
 * Created by Abo on 2016/12/30.
 */

public class YahooWeatherCodeMap {

    //static private HashMap<String, Integer> weatherCode = new HashMap<String, Integer>();
    private static HashMap<String, Integer> weatherCode;

    static {
        weatherCode = new HashMap<String, Integer>();
        weatherCode.put("0", R.drawable.y_0);
        weatherCode.put("1", R.drawable.y_1);
        weatherCode.put("2", R.drawable.y_2);
        weatherCode.put("3", R.drawable.y_3);
        weatherCode.put("4", R.drawable.y_4);
        weatherCode.put("5", R.drawable.y_5);
        weatherCode.put("6", R.drawable.y_6);
        weatherCode.put("7", R.drawable.y_7);
        weatherCode.put("8", R.drawable.y_8);
        weatherCode.put("9", R.drawable.y_9);
        weatherCode.put("10", R.drawable.y_10);
        weatherCode.put("11", R.drawable.y_11);
        weatherCode.put("12", R.drawable.y_12);
        weatherCode.put("13", R.drawable.y_13);
        weatherCode.put("14", R.drawable.y_14);
        weatherCode.put("15", R.drawable.y_15);
        weatherCode.put("16", R.drawable.y_16);
        weatherCode.put("17", R.drawable.y_17);
        weatherCode.put("18", R.drawable.y_18);
        weatherCode.put("19", R.drawable.y_19);
        weatherCode.put("20", R.drawable.y_20);
        weatherCode.put("21", R.drawable.y_21);
        weatherCode.put("22", R.drawable.y_22);
        weatherCode.put("23", R.drawable.y_23);
        weatherCode.put("24", R.drawable.y_24);
        weatherCode.put("25", R.drawable.y_25);
        weatherCode.put("26", R.drawable.y_26);
        weatherCode.put("27", R.drawable.y_27);
        weatherCode.put("28", R.drawable.y_28);
        weatherCode.put("29", R.drawable.y_29);
        weatherCode.put("30", R.drawable.y_30);
        weatherCode.put("31", R.drawable.y_31);
        weatherCode.put("32", R.drawable.y_32);
        weatherCode.put("33", R.drawable.y_33);
        weatherCode.put("34", R.drawable.y_34);
        weatherCode.put("35", R.drawable.y_35);
        weatherCode.put("36", R.drawable.y_36);
        weatherCode.put("37", R.drawable.y_37);
        weatherCode.put("38", R.drawable.y_38);
        weatherCode.put("39", R.drawable.y_39);
        weatherCode.put("40", R.drawable.y_40);
        weatherCode.put("41", R.drawable.y_41);
        weatherCode.put("42", R.drawable.y_42);
        weatherCode.put("43", R.drawable.y_43);
        weatherCode.put("44", R.drawable.y_44);
        weatherCode.put("45", R.drawable.y_45);
        weatherCode.put("46", R.drawable.y_46);
        weatherCode.put("47", R.drawable.y_47);
        weatherCode.put("na", R.drawable.y_na);

    }

    public static int getWeatherIcon(String stateName) {
        if (weatherCode.containsKey(stateName)) {
            return weatherCode.get(stateName);
        }
        return 0;
    }

    /*static public int getWeatherIcon(Context context, String code){

        Resources res = context.getResources();
        weatherCode.put("26", res.getIdentifier("y_26", "drawable", context.getPackageName()));
        weatherCode.put("27", res.getIdentifier("y_27", "drawable", context.getPackageName()));
        weatherCode.put("28", res.getIdentifier("y_28", "drawable", context.getPackageName()));
        weatherCode.put("29", res.getIdentifier("y_29", "drawable", context.getPackageName()));
        weatherCode.put("30", res.getIdentifier("y_30", "drawable", context.getPackageName()));
        weatherCode.put("31", res.getIdentifier("y_31", "drawable", context.getPackageName()));
        weatherCode.put("32", res.getIdentifier("y_32", "drawable", context.getPackageName()));

        return weatherCode.get(code);
    }*/

}
