package maria.clara.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import maria.clara.dto.RestaurantDto;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public final class JsonUtils {
    private static ObjectMapper jsonMapper = new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

    public static ObjectMapper getJsonMapper() {
        return jsonMapper;
    }

    public static String toJson(Object object) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(object);
    }

    public static Object fromJson(URL url, Object object) throws IOException {
        return jsonMapper.readValue(url, Object.class);
    }

    public static ArrayList<RestaurantDto> fromJsonToRestaurantDTO(String json) throws IOException {
        CollectionType typeReference = TypeFactory
                .defaultInstance()
                .constructCollectionType(ArrayList.class, RestaurantDto.class);

        return jsonMapper.readValue(json, typeReference);
    }

}

