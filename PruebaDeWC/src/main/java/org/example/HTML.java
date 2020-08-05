package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTML {
    public void ExtrerHTML(String url) throws IOException {
        String patron = "</strong>.*?</p>";
        String patron2 = "<h2>.*?</h2>";
        String patron3 = ">.*?</a>";
        Connection.Response response = null;
        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (
                IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }

        Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        Element primerDiv = doc.getElementById("container");
        //System.out.println(primerDiv);
        if(primerDiv==null){
            return;
        }
        Elements articulos = primerDiv.getElementsByClass("sinopsis-box");
        Elements titulos = primerDiv.getElementsByClass("info-content");
        Elements genero = primerDiv.getElementsByClass("mobile");

        //System.out.println("A ver si jala esto: ___________________________________________"+articulos+" hasta aqui ");
        Pattern pattern= Pattern.compile(patron);
        Matcher matcher = pattern.matcher(String.valueOf(articulos));
        Pattern pattern2 = Pattern.compile(patron2);
        Matcher tituloMatcher = pattern2.matcher(String.valueOf(titulos));
        Pattern pattern3 = Pattern.compile(patron3);
        Matcher generoMatcher = pattern3.matcher(String.valueOf(genero));
        System.out.println(url);
        
        String match;
        //System.out.println("A ver si jala esto x2: _____________________________________________________");
        while(tituloMatcher.find()){
            //System.out.println(tituloMatcher.group());
            match = tituloMatcher.group();
            System.out.println(match);
        }
        while (matcher.find()){
            //System.out.println(matcher.group());
            match = matcher.group();
            System.out.println(match);
            System.out.print("Generos: ");
            while(generoMatcher.find()){
                //System.out.println(generoMatcher.group());
                match = generoMatcher.group();
                System.out.println(match);
            }
            System.out.println("");
        }
    }



}
