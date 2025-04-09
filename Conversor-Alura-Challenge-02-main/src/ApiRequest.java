import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

        public ExchangeRate searchRate(String base_code, String target_code){
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request =HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/37b253b5414ffc92507038fd/pair/"+base_code+"/"+target_code))
                    .build();
            try{
                HttpResponse<String>response =client.send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), ExchangeRate.class);
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }
}
