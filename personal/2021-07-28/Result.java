import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.simple.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;


class Result {

    public static String readJsonFromUrl(String url) throws IOException{
      InputStream is = new URL(url).openStream();
      try {
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        return jsonText;
      } finally {
        is.close();
      }
    }
    
    private static String readAll(Reader rd) throws IOException {
      StringBuilder sb = new StringBuilder();
      int cp;
      while ((cp = rd.read()) != -1) {
        sb.append((char) cp);
      }
      return sb.toString();
    }
    
    private static String getData(int year, int countGoals) {
        String result = "";
        try {
            result =  readJsonFromUrl("https://jsonmock.hackerrank.com/api/football_matches?year=" + year +"&team1goals=" + countGoals + "&team2goals=" + countGoals);
        } catch(Exception e) {
          System.out.println("error");
        }
        return result;
    }

    public static int getNumDraws(int year) {
        int resultCount = 0;
        for (int i=0; i<16; i++) {
            String result = getData(year,i);
            JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
            int a = Integer.parseInt(jsonObject.get("total").toString());
            resultCount = resultCount+a;
        }
        return resultCount;
    }
}
