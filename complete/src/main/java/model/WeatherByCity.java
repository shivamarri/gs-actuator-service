package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherByCity {

    private Integer visibility;
    private String name;
    private Integer id;
    private Integer cod;
    private String base;
    private Wind wind;
    private Weather[] weather;


    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherByCity{" +
                "visibility=" + visibility +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", cod=" + cod +
                ", base='" + base + '\'' +
                ", wind=" + wind +
                ", weather=" + Arrays.toString(weather) +
                '}';
    }
}
