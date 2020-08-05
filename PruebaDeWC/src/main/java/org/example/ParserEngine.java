package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ParserEngine {

    public void listAllLinks(String url) throws IOException {
        System.out.println("Parsing page " + url + "...");
        ArrayList sinopsis = new ArrayList();
        int contador = 0;
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");

        print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            
            if(contador <= 2){
                contador++;
                sinopsis.add(link.attr("abs:href"));
            }else{
                if(contador > 2){
                    if(!(sinopsis.get(contador-1).equals(link.attr("abs:href")))){
                        sinopsis.add(link.attr("abs:href"));
                        contador++;
                    }
                }
            }
        }

        /*for(int i =0;i<sinopsis.size();i++){
            System.out.println(sinopsis.get(i));
        }*/

        HTML html = new HTML();

        for(int i =0;i<sinopsis.size();i++){
            html.ExtrerHTML(String.valueOf(sinopsis.get(i)));
        }

    }


    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }

}
