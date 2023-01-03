import static io.restassured.RestAssured.*; // static import of restassured libraries
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class Test01_GET {

    @Test
    void test_01() {
        Response response= get("https://reqres.in/api/users?page=2"); //w/o creatinfg restassured object
        System.out.println("response as a string :"+response.asString());
        System.out.println("Status code is :" +response.getStatusCode());
        System.out.println(response.getBody().asString());
        System.out.println("Status line is : " +response.getStatusLine());
        System.out.println("Response time is "   +response.getTime());

        int statuscode= response.getStatusCode();
        Assert.assertEquals(statuscode, 200);

    }

    @Test
    void test_02(){
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
                .body("data.id[0]", equalTo(7));
    }
}
