package org.example;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static org.example.Parser.getPage;

public class Main {

    public static void main(String[] args) throws Exception {
        Document page = getPage();
        //System.out.println(page);
        Parser pars = new Parser();
        Element tableWeather = page.select("div[class=current-weather-wrap]").first();
        Element date = tableWeather.select("div[class=current-time]").first();
        Element wind = tableWeather.select("div[class=weather-item weather-wind]").first();
        Element pressure = tableWeather.select("div[class=weather-item weather-pressure]").first();
        Element temperature = page.getElementsByClass("unit unit_temperature_c").first();
        Element event = tableWeather.select("div[class=weather-description]").first();
        System.out.println(pars.getDate(date.text()));
        System.out.println(pars.getWind(wind.text()));
        System.out.println(pars.getTemp(temperature.text()));
        System.out.println(pars.getPressure(pressure.text()));
        System.out.println(event.text());
    }
}