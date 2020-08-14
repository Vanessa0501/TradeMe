package ApiAutomation;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;


public class ApiTests {
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass
    public static void createRequestSpecification(){
        requestSpec = new RequestSpecBuilder().setBaseUri("http://api.zippopotam.us").build();
    }

    @BeforeClass
    public static void createResponseSpecification(){
        responseSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();

    }


    @Test
    public void example1(){
        String placeName =
        given().
                spec(requestSpec).
                when().
                get("/us/90210").
                then().
                extract().
                path("places[0].'place name'");

        Assert.assertEquals(placeName,"Beverly Hills");
    }

    @Test
    public void verifyStatusCode200IsReturned(){
        given().when().get("http://api.zippopotam.us/us/90210").then().log().all().assertThat().statusCode(200).log().all();
    }

    @Test
    public void verifyJsonContentTypeIsReturned(){
        given().when().get("http://api.zippopotam.us/us/90210").then().assertThat().contentType(ContentType.JSON).statusCode(200).log().body();
    }

    @Test
    public void verifyTheResponseContainsTheCorrectValue(){
        given().when().get("http://api.zippopotam.us/us/90210").then().assertThat().body("places[0].'place name'",equalTo("Beverly Hills"));
    }
}
