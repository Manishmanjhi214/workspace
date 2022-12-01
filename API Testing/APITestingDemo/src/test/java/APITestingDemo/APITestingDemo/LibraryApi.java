package APITestingDemo.APITestingDemo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.ReusableMethods;

public class LibraryApi {
	@Test(dataProvider = "BooksData")
	public void addBook(String TITLE, String ISBN, String AISLE) {
		RestAssured.baseURI= "http://216.10.245.166";
		Response addBookResponse = given().header("Content-Type","application/json")
		.body(Payload.addBook(TITLE, ISBN, AISLE)).
		when().post("Library/Addbook.php").
		then().assertThat().statusCode(200).extract().response();
		
		JsonPath js= ReusableMethods.rawToJson(addBookResponse.asString());
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData(){
		
		return new Object[][] { {"Learn API with Java","dfg", "98"},
	    {"Learn Appium Automation with Java", "uio","98"} };
	}
}
