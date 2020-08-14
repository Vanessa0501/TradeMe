package ApiAutomation;

import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;

import io.restassured.authentication.FormAuthConfig;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MotorsApiTests {
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass
    public static void createRequestSpecification(){
        requestSpec = new RequestSpecBuilder().setBaseUri("https://api.tmsandbox.co.nz/v1").build();
    }

    @BeforeClass
    public static void createResponseSpecification(){
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }

    @Test
    public void test_one() {
        given().
            spec(requestSpec).
        when().
            get("TmAreas.json").
        then().
            spec(responseSpec).
            body("[0].LocalityId", equalTo(100)).
            assertThat().
            body("[0].LocalityId", equalTo(100)).and().body("[0].Name",equalTo("All"));
    }

    @Test
    public void test_two() {

    }
}
