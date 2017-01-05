package com.example.abo.weatherinfoproject.yahooweatherservice;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abo on 2016/12/29.
 */

public class WeatherInfo {
    private String title;
    private String link;
    private String description;
    private String lastBuildDate;
    private Units mUnits;
    private Location mLocation;
    private Wind mWind;
    private Atmosphere mAtmosphere;
    private Astronomy mAstronomy;
    private Image mImage;
    private Item mItem;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Units getmUnits() {
        return mUnits;
    }

    public void setmUnits(Units mUnits) {
        this.mUnits = mUnits;
    }

    public Location getmLocation() {
        return mLocation;
    }

    public void setmLocation(Location mLocation) {
        this.mLocation = mLocation;
    }

    public Wind getmWind() {
        return mWind;
    }

    public void setmWind(Wind mWind) {
        this.mWind = mWind;
    }

    public Atmosphere getmAtmosphere() {
        return mAtmosphere;
    }

    public void setmAtmosphere(Atmosphere mAtmosphere) {
        this.mAtmosphere = mAtmosphere;
    }

    public Astronomy getmAstronomy() {
        return mAstronomy;
    }

    public void setmAstronomy(Astronomy mAstronomy) {
        this.mAstronomy = mAstronomy;
    }

    public Image getmImage() {
        return mImage;
    }

    public void setmImage(Image mImage) {
        this.mImage = mImage;
    }

    public Item getmItem() {
        return mItem;
    }

    public void setmItem(Item mItem) {
        this.mItem = mItem;
    }

    public class Units{
        private String distance;
        private String pressure;
        private String speed;
        private String temperature;

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getPressure() {
            return pressure;
        }

        public void setPressure(String pressure) {
            this.pressure = pressure;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }
    }

    public class Location{
        private String city;
        private String country;
        private String region;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }

    public class Wind{
        private int chill;
        private int direction;
        private float speed;

        public int getChill() {
            return chill;
        }

        public void setChill(int chill) {
            this.chill = chill;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public float getSpeed() {
            return speed;
        }

        public void setSpeed(float speed) {
            this.speed = speed;
        }
    }

    public class Atmosphere{
        private int humidity;
        private float pressure;
        private int rising;
        private float visibility;

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public float getPressure() {
            return pressure;
        }

        public void setPressure(float pressure) {
            this.pressure = pressure;
        }

        public int getRising() {
            return rising;
        }

        public void setRising(int rising) {
            this.rising = rising;
        }

        public float getVisibility() {
            return visibility;
        }

        public void setVisibility(float visibility) {
            this.visibility = visibility;
        }
    }

    public class Astronomy{
        private String sunrise;
        private String sunset;

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }
    }

    public class Image{
        private String title;
        private int width;
        private int height;
        private String link;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public class Item{
        private String title;
        private String lat;

        @SerializedName("long")
        private String lng;

        private String link;
        private String pubDate;
        private Condition condition;
        private Forecast[] forecast;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        public Forecast[] getForecast() {
            return forecast;
        }

        public void setForecast(Forecast[] forecast) {
            this.forecast = forecast;
        }

        public class Condition{
            private String code;
            private String date;
            private String temp;
            private String text;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public class Forecast{
            private String code;
            private String date;
            private String day;
            private String high;
            private String low;
            private String text;


            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }

}
