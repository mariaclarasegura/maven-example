package maria.clara.clients;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonMappingException;
import maria.clara.dto.RestaurantDto;
import maria.clara.utils.JsonUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestaurantClient {

    private OkHttpClient client = new OkHttpClient();
    private String url = "https://my-json-server.typicode.com/emanueldamianpaz/demo/restaurants";

    public ArrayList<RestaurantDto> getRestaurant() throws IOException, JsonMappingException {
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            return JsonUtils.fromJsonToRestaurantDTO(response.body().string());
        }
    }
}