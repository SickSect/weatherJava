package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    String getDate(String dateStr) throws Exception {
        //\d{2}\s\D{3, 13} \d{2}\s\w{3,10}
        Pattern pattern = Pattern.compile("\\d{2}\\s\\X+[,]");
        Matcher match = pattern.matcher(dateStr);
        //Сб, 15 октября, 17:40
        if(match.find()) {
            String date = match.group();
            return date.substring(0,date.length() - 1);
        }
        throw new Exception("Cant extract date from string in method Parser.getDate");
    }
    public static Document getPage() throws IOException {
        String url = "https://www.gismeteo.ru/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public String getWind(String windStr) throws Exception {
        Pattern pattern = Pattern.compile("\\D{5}\\s\\d{1,2}");
        Matcher match  = pattern.matcher((windStr));
        if(match.find()){
            String wind = match.group() + " м/с";
            return wind;
        }
        //return windStr;
        throw new Exception("Cant extract wind from string in method getWind");
    }

    public String getTemp(String tempStr) throws Exception{
        Pattern pattern = Pattern.compile("[+-]\\d{1,2}");
        Matcher match = pattern.matcher(tempStr);
        if(match.find())
        {
            return "Температура " + match.group() + " C";
        }
        throw new Exception("Cant extract temperature from string in method getTemp");
    }
    //Давление 752 мм рт.ст. 1002 гПа
    public String getPressure(String pressStr) throws Exception{
        //Давление 752 мм рт.ст. 1002 гПа
        Pattern pattern = Pattern.compile("\\D{8}\\s\\d{3}\\s");
        Matcher match = pattern.matcher(pressStr);
        if (match.find())
            return match.group() + "мм рт.ст.";
        throw new Exception("Cant extract pressure from string in method getTemp");
    }
}
