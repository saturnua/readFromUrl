package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

private static String getHTMLFrom(String urlAdress) throws MalformedURLException {
    String textFromUrl = "";
    List<String> resultText = new ArrayList<>();
    URL url = new URL(urlAdress);

    try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
        while ((textFromUrl = br.readLine()) != null) {
            resultText.add(textFromUrl + System.lineSeparator());
            }
        } catch (IOException e) {
        e.printStackTrace();
    }
    return resultText.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getHTMLFrom("http://www.espreso.tv"));
    }
}
