package com.readjson.controller;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

@RestController
public class ReadJson {

    public static String getJsonFromFile(String fileName) {
        String jsonText = "";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                jsonText += line + "\n";
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonText;
    }

    public static String getJsonFromURL(String strUrl) {
        String jsonText = "";

        try {
            URL url = new URL(strUrl);
            InputStream is = url.openStream();

            BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(is));

            String line;

            while((line = bufferedReader.readLine()) != null) {
                jsonText += line + "\n";
            }
            is.close();
            bufferedReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return jsonText;
    }

    public ReadJson() {
       String strJson = getJsonFromFile("Files/ItemList.json");
        // String strJson = getJsonFromURL("https://raw.githubusercontent.com/BoostMyTool/JsonFile/master/example.json");
        System.out.println(strJson);
    }

}
