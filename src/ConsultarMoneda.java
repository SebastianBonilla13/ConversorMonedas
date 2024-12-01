import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {

    MonedaOmdb buscaMoneda (String divisaMoneda){

        String direccion = "https://v6.exchangerate-api.com/v6/e15fe93578fbd3680ff112ba/latest/"+divisaMoneda;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(URI.create( direccion ))
                .build();

        HttpResponse<String> response = null;

        try {

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(), MonedaOmdb.class);
    }


}
