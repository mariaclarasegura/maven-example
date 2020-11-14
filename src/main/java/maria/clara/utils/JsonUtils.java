package maria.clara.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public final class JsonUtils {
    private static ObjectMapper jsonMapper = new ObjectMapper();

    public static String toJson(Object object) throws JsonProcessingException {
        return jsonMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE).writeValueAsString(object);
    }
}

