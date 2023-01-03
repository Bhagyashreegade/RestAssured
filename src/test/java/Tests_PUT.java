import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Tests_PUT {


    @Test
    public void test_1_put(){

        Map<String, Object> map= new HashMap<String, Object>();

        map.put("name", "Bhagyashree");
        map.put("job", "Tester");

        System.out.println("Without Json simple dependency:"   +map);

        //to convert the response into json format-->json.simple dependency is added in pm.xml

        JSONObject request= new JSONObject(map);
        System.out.println("With Json simple dependency:"  +request);

        given().
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().
                statusCode(200).log().all();



    }
}
