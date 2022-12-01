package APITestingDemo.APITestingDemo;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import Files.ReusableMethods;

public class JIRAApi {
	public static void main(String[] args) {
		RestAssured.baseURI= "http://localhost:8080";
		//Login to JIRA
		SessionFilter session = new SessionFilter();
		String res = given().relaxedHTTPSValidation().header("Content-Type","application/json").log().all()
				.body("{ \"username\": \"manishmanjhi214\", \"password\": \"Megatron@123\" }").filter(session)
				.when().post("/rest/auth/1/session").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		//Add comment to existing issue
		given().pathParam("key", "10101").header("Content-Type","application/json").log().all()
		.body("{\r\n"
				+ "    \"body\": \"hey comment1\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").
		filter(session).when().post("/rest/api/2/issue/{key}/comment").
		then().log().all().assertThat().statusCode(201);
		
		//Add Attachment
		given().header("X-Atlassian-Token","no-check").filter(session).pathParam("key", "10101").header("Content-Type","multipart/form-data").
		multiPart("file",new File("jira.txt")).
		when().post("/rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
		
		//Get Issue
		String issueDetails =given().filter(session).pathParam("key", "10101").queryParam("fields", "comment").log().all().
		when().get("/rest/api/2/issue/{key}").
		then().log().all().extract().response().asString();
		
		JsonPath js= ReusableMethods.rawToJson(issueDetails);
		
		int commentNum=js.getInt("fields.comment.comments.size()");
		System.out.println(commentNum);
		for(int i=0;i<commentNum;i++) {
			String id =js.get("fields.comment.comments["+i+"].id").toString();
			String comment =js.get("fields.comment.comments["+i+"].body").toString();
			System.out.print(id+":"+comment);
			System.out.println();
			
		}
		
	}
}
