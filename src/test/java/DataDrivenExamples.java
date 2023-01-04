import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DataDrivenExamples {


    @DataProvider (name= "DataForPost")
    public Object[][] dataForPost() {

        Object[][] data = new Object[5][2];

//        data[0][0] = "Bhagyashree";
//        data[0][1] = "Tester";
//
//        data[1][0] = "Rahul";
//        data[1][1] = "Devops";
//
//        data[2][0] = "Rohan";
//        data[2][1] = "Tech";
//
//        data[3][0] = "Shruti";
//        data[3][1] = "Coder";
//
//        data[4][0] = "Shweta";
//        data[4][1] = "Devops";

        return new Object[][] {
                {"Bhagyashree", "Tester"},
                {"Rahul", "Devops"},
                {"Rohan", "Tech"}
        };
    }

    @Test (dataProvider = "DataForPost")
    public void test_1_post(String name, String job) {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", name);
        map.put("job", job);

        System.out.println("Without Json simple dependency:" + map);

        //to convert the response into json format-->json.simple dependency is added in pm.xml

        JSONObject request = new JSONObject(map);
        System.out.println("With Json simple dependency:" + request);

        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().
                statusCode(201).log().all();


    }

}
