package org.example;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import static org.example.Parser.getPage;

public class Main {
    public static void main(String[] args) throws IOException {
        Document page = getPage();
        //System.out.println(page);
        Element tableWeather = page.select("div[id=jm-content-top]").first();
        System.out.println(tableWeather + " HERE");
    }
}