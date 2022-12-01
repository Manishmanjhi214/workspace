package Files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	public static JsonPath rawToJson(String res) {
		JsonPath js= new JsonPath(res);
		return js;
	}

}
