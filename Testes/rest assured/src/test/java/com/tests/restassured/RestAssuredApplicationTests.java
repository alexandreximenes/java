package com.tests.restassured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class RestAssuredApplicationTests {

    /**
     * @see <a href="http://api.zippopotam.us/">http://api.zippopotam.us/</a>
     * @see <a href="http://hamcrest.org/JavaHamcrest/">http://hamcrest.org/JavaHamcrest/</a>
     */

    private static RequestSpecification requestSpecification;

    @BeforeClass
    public static void createRequestSpecification() {

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://api.zippopotam.us")
                .build();
    }

    @Test
    public void requestZipCode90210_Desirialization(){

        Location location =

        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .as(Location.class);

        Assert.assertEquals("Bervely Hills", location.getPlaces().get(0).getPlaceName());
    }

    @Test
    public void requestZipCode90210_Serialization(){

        Location location = new Location();
        location.setPostCode("90210");

                given()
                        .contentType(ContentType.JSON)
                        .body(location)
                        .log().body()
                        .when()
                        .post("http://localhost:8080/api/search")
                        .then()
                        .assertThat()
                        .statusCode(200);

        Assert.assertEquals("Bervely Hills", location.getPlaces().get(0).getPlaceName());
    }

    @Test
    public void requestZipCode90210_requestSpec(){

        given()
                .spec(requestSpecification)
                .when()
                .get("/us/90210")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void requestZipCode90210_statusOK(){

        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void requestZipCode90210_statusError(){

        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .statusCode(not(equalTo(201)));
    }


    @Test
    public void requestZipCode90210_contentTypeJSON(){

        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .assertThat()
                .contentType(ContentType.JSON);
//                .contentType("application/json");
    }


    @Test
    public void requestZipCode90210_logs(){

        given()
                .when()
                .log().all()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .assertThat()
                .log().body()
                .contentType(ContentType.JSON);
    }

    @Test
    public void requestZipCode90210_EqualTo(){

        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .assertThat()
                .body("places[0].'place name'", equalTo("Beverly Hills"));

    }


    @Test
    public void requestZipCode90210_body(){

        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .assertThat()
                .body("'post code'", equalTo("90210"))
                .body("country", equalTo("United States"))
                .body("'country abbreviation'", equalTo("US"))
                .body("places[0].'place name'", equalTo("Beverly Hills"))
                .body("places[0].'longitude'", equalTo("-118.4065"))
                .body("places[0].'state abbreviation'", equalTo("CA"))
                .body("places[0].'latitude'", equalTo("34.0901"))
                .log().all();

    }



    @Test
    public void requestZipCode90210_notPlace(){

        given()
                .when()
                .log().all()
                .get("http://api.zippopotam.us/BR/81920650")
                .then()
                .assertThat()
                .body("places.'place name'", not(hasItem("Beverly Hills")));


    }

    @Test
    public void requestZipCode90210_hasSize(){

        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .assertThat()
                .body("places.'place name'", hasSize(1))
                .log().body();
    }

}
