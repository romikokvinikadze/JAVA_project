package ge.tsu.project;

import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        final String sURL = "https://nbg.gov.ge/gw/api/ct/monetarypolicy/currencies/en/json";

        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonArray jsonArray = root.getAsJsonArray().get(0).getAsJsonObject().get("currencies").getAsJsonArray();

        Gson gson = new Gson();
        HashMap<String, Currency> map = new HashMap();
        map.put("GEL", new Currency("GEL", 1, 1.0, "GEORGIAN LARI"));

        for (int i=0; i<jsonArray.size(); i++){
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

            String code = jsonObject.get("code").getAsString();
            int quantity = jsonObject.get("quantity").getAsInt();
            double rate = jsonObject.get("rate").getAsDouble();
            String name = jsonObject.get("name").getAsString();

            Currency currency = new Currency(code, quantity, rate, name);

            map.put(code, currency);
        }

        Helper helper = new Helper(map);
        helper.getRate("USD", "EUR", 1500);
    }
}
