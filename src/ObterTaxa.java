import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObterTaxa {
    private static String apikey = "69a775e7ec5f981cd8e4f2db";
    private static String urlBase = "https://v6.exchangerate-api.com/v6/";

    public static double consultar(String de, String para){
        try {
            String link = urlBase + apikey + "/latest/" + de;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(link))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            JsonObject taxasDeConversao = json.getAsJsonObject("conversion_rates");

            if (taxasDeConversao.has(para)) {
                return taxasDeConversao.get(para).getAsDouble();
            } else {
                System.out.println("Moeda não encontrada.");
                return -1;
            }

        }  catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return -1;
        }
    }
}
