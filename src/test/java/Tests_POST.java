import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Tests_POST {


    @Test
    public void test_1_post(){

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
                post("https://reqres.in/api/users?page=2").
        then().
                statusCode(201).log().all();



    }
}
