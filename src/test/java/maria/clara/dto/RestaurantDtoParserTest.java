package maria.clara.dto;

import com.fasterxml.jackson.databind.JsonMappingException;
import maria.clara.utils.JsonUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantDtoParserTest {

    @Test
    public void parseCorrectly() throws IOException {
        String jsonExample = "[{\"id\":\"1\",\"name\":\"Eleven Madison Park\",\"detail\":{\"location\":\"New York\",\"rating\":4,\"specialization\":[\"savory\",\"sweet\"]}}]";

        ArrayList<String> specialization = new ArrayList<String>();
        specialization.add("savory");
        specialization.add("sweet");
        DetailDto detailDto = new DetailDto("New York", 4, specialization);

        ArrayList<RestaurantDto> expected = new ArrayList<>();
        expected.add(new RestaurantDto("1", "Eleven Madison Park", detailDto));
        ArrayList<RestaurantDto> result = JsonUtils.fromJsonToRestaurantDTO(jsonExample);

        assertEquals(expected.size(), result.size());
        assertEquals(expected.get(0).getId(), result.get(0).getId());
        assertEquals(expected.get(0).getName(), result.get(0).getName());
        assertEquals(expected.get(0).getDetail().getLocation(), result.get(0).getDetail().getLocation());
        assertEquals(expected.get(0).getDetail().getRating(), result.get(0).getDetail().getRating());
        assertEquals(expected.get(0).getDetail().getSpecialization().size(), result.get(0).getDetail().getSpecialization().size());
    }

    @Test
    public void parseIncorrectly() throws IOException {
        String jsonExample = "[{\"id\":\"2\",\"name\":\"Eleven Park\",\"detail\":{\"location\":\"New \",\"rating\":4,\"specialization\":[\"savory\",\"sweet\"]}}]";

        ArrayList<String> specialization = new ArrayList<String>();
        specialization.add("savory");
        specialization.add("sweet");
        DetailDto detailDto = new DetailDto("New York", 4, specialization);

        ArrayList<RestaurantDto> expected = new ArrayList<>();
        expected.add(new RestaurantDto("1", "Eleven Madison Park", detailDto));
        ArrayList<RestaurantDto> result = JsonUtils.fromJsonToRestaurantDTO(jsonExample);

        assertEquals(expected.size(), result.size());
        assertNotEquals(expected.get(0).getId(), result.get(0).getId());
        assertNotEquals(expected.get(0).getName(), result.get(0).getName());
        assertNotEquals(expected.get(0).getDetail().getLocation(), result.get(0).getDetail().getLocation());
        assertEquals(expected.get(0).getDetail().getRating(), result.get(0).getDetail().getRating());
        assertEquals(expected.get(0).getDetail().getSpecialization().size(), result.get(0).getDetail().getSpecialization().size());
    }

    @Test
    public void parseMissingArguments() throws IOException {
        String jsonExample = "[{\"name\":\"Eleven Park\",\"detail\":{\"location\":\"New \",\"rating\":4,\"specialization\":[\"savory\",\"sweet\"]}}]";

        ArrayList<String> specialization = new ArrayList<String>();
        specialization.add("savory");
        specialization.add("sweet");
        DetailDto detailDto = new DetailDto("New York", 4, specialization);

        ArrayList<RestaurantDto> expected = new ArrayList<>();
        expected.add(new RestaurantDto("1", "Eleven Madison Park", detailDto));
        ArrayList<RestaurantDto> result = JsonUtils.fromJsonToRestaurantDTO(jsonExample);

        assertEquals(expected.size(), result.size());
        assertNull(result.get(0).getId());
        assertNotEquals(expected.get(0).getName(), result.get(0).getName());
        assertNotEquals(expected.get(0).getDetail().getLocation(), result.get(0).getDetail().getLocation());
        assertEquals(expected.get(0).getDetail().getRating(), result.get(0).getDetail().getRating());
        assertEquals(expected.get(0).getDetail().getSpecialization().size(), result.get(0).getDetail().getSpecialization().size());
    }

    @Test
    public void parseInvalid() {
        String jsonExample = "[{\"name\"\"Eleven Park\",\"detail\":\"location\":New \",\"rating\":4,\"specialization\":[\"savory\",\"sweet\"]}}]";

        assertThrows(JsonMappingException.class, () -> {
            JsonUtils.fromJsonToRestaurantDTO(jsonExample);
        });
    }
}