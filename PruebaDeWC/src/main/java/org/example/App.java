package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        String url = "https://jkanime.net/letra/A/";
        ParserEngine parser = new ParserEngine();
        //String url = "http://elfreneticoinformatico.com";
        parser.listAllLinks(url);

    }

}
