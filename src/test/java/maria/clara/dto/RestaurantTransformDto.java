package maria.clara.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RestaurantTransformDto {

    @Test
    public void test1()  {

        ArrayList<String> specialization = new ArrayList<String>();
        specialization.add("savory");
        specialization.add("sweet");
        DetailDto detailDto = new DetailDto("New York", 4, specialization);

        RestaurantDto resultApi = new RestaurantDto("1", "Eleven Madison Park", detailDto);

        RestaurantResponseDto responseExpected = new RestaurantResponseDto(
                resultApi.getName(),
                resultApi.getDetail().getLocation(),
                resultApi.getDetail().getRating(),
                resultApi.getDetail().getSpecialization()
        );



    }
}
