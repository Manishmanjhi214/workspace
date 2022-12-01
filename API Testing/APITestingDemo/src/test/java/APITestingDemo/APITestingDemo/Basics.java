package APITestingDemo.APITestingDemo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Files.Payload;

public class Basics {

	public static void main(String[] args) throws IOException {
		//given - all input details 
				//when - Submit the API -resource,http method
				//Then - validate the response
				RestAssured.baseURI= "https://rahulshettyacademy.com";
				//Add Place
				String response= given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				//.body(Payload.addPlace())
				.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\manis\\OneDrive\\Desktop\\AddPlace.json"))))
				.when().post("maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
				
				JsonPath j= new JsonPath(response);
				String placeId = j.getString("place_id");
				String newPlace= "70 winter walk, USA";
				
				//Update Place
				given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body("{\r\n"
						+ "\"place_id\":\""+placeId+"\",\r\n"
						+ "\"address\":\""+ newPlace +"\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n"
						+ "}\r\n"
						+ "")
				.when().put("maps/api/place/update/json")
				.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
				
				//Get Place 
				String GetPlaceresponse=given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id",placeId)
				.when().get("maps/api/place/get/json")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
				JsonPath getAdd= new JsonPath(GetPlaceresponse);
				String address = getAdd.getString("address");
				assertEquals(address, newPlace);
				
				
	}

}
