package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Parser {
    public static Document getPage() throws IOException {
        String url = "https://meteoinfo.ru/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

}
