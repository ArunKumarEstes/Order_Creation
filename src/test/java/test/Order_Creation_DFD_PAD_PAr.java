package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Order_Creation_DFD_PAD_PAr {
	// PAD Order creation by changing Invoice Number
	@Test
	public static void PAD_Order_Creation() throws Exception {
		File file = new File(System.getProperty("user.dir") + "\\PAD.json");
		FileInputStream fis = new FileInputStream(file);

		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		LinkedHashMap<String, Object> value = objectMapper.readValue(fis,
				new TypeReference<LinkedHashMap<String, Object>>() {
				});
		String asString = objectMapper.writeValueAsString(value);

		JSONObject object = new JSONObject(asString);
		JSONObject jsonObject = object.getJSONObject("OrderRefs");
		jsonObject.put("InvoiceNumber", Math.ceil(Math.random() * 100000000));
		JsonNode readTree = objectMapper.readTree(object.toString());
		String prettyString = readTree.toPrettyString();
		// System.out.println(prettyString);

		RestAssured.baseURI = "https://epicuatlb.estes-express.com";
		Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
				.contentType("application/json").body(prettyString)
				.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
		String responseBody = response.getBody().asString();
		System.out.println("<------Result of PAD Json------>");
		System.out.println("Response Body: " + responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);

	}

	// DFD Order creation by changing Invoice Number
	@Test
	public static void DFD_Order_Creation() throws IOException, JSONException {
		// Change by BOL

		File file = new File(System.getProperty("user.dir") + "\\DFD.json");
		FileInputStream fis = new FileInputStream(file);
		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		LinkedHashMap<String, Object> value = objectMapper.readValue(fis,
				new TypeReference<LinkedHashMap<String, Object>>() {
				});
		String asString = objectMapper.writeValueAsString(value);
		JSONObject object = new JSONObject(asString);
		JSONObject jsonObject = object.getJSONObject("OrderRefs");
		jsonObject.put("BOL", Math.ceil(Math.random() * 100000000));
		JsonNode readTree = objectMapper.readTree(object.toString());
		String prettyString = readTree.toPrettyString();
		// System.out.println(prettyString);

		RestAssured.baseURI = "https://epicuatlb.estes-express.com";
		Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
				.contentType("application/json").body(prettyString)
				.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
		String responseBody = response.getBody().asString();
		String[] split = responseBody.split("Reference ");
		System.out.println(split[1]);
		System.out.println("<------Result of PAD Json------>");
		System.out.println("Response Body: " + responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);

	}

	// Automated PAD Case
	@Test
	public static void PAD_Automated_Case_Creation() throws IOException, JSONException {
		// Change by BOL

		File file = new File(System.getProperty("user.dir") + "\\DFD.json");
		FileInputStream fis = new FileInputStream(file);
		ObjectMapper objectMapper = new ObjectMapper();
//			objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//			objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		LinkedHashMap<String, Object> value = objectMapper.readValue(fis,
				new TypeReference<LinkedHashMap<String, Object>>() {
				});
		String asString = objectMapper.writeValueAsString(value);
		JSONObject object = new JSONObject(asString);
		JSONObject jsonObject = object.getJSONObject("OrderRefs");
		jsonObject.put("InvoiceNumber", Math.ceil(Math.random() * 100000000));
		JsonNode readTree = objectMapper.readTree(object.toString());
		String prettyString = readTree.toPrettyString();
		// System.out.println(prettyString);

		RestAssured.baseURI = "https://epicuatlb.estes-express.com";
		Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
				.contentType("application/json").body(prettyString)
				.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
		String responseBody = response.getBody().asString();
		System.out.println("<------Result of PAD Json------>");
		System.out.println("Response Body: " + responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);

	}

	@Test
	public static void PAR_Order_Creation() throws Exception {
		File file = new File(System.getProperty("user.dir") + "\\PAR.json");
		FileInputStream fis = new FileInputStream(file);

		ObjectMapper objectMapper = new ObjectMapper();
//			objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//			objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		LinkedHashMap<String, Object> value = objectMapper.readValue(fis,
				new TypeReference<LinkedHashMap<String, Object>>() {
				});
		String asString = objectMapper.writeValueAsString(value);

		JSONObject object = new JSONObject(asString);
		JSONObject jsonObject = object.getJSONObject("OrderRefs");
		jsonObject.put("InvoiceNumber", Math.ceil(Math.random() * 100000000));
		JsonNode readTree = objectMapper.readTree(object.toString());
		String prettyString = readTree.toPrettyString();
		// System.out.println(prettyString);

		RestAssured.baseURI = "https://epicuatlb.estes-express.com";
		Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
				.contentType("application/json").body(prettyString)
				.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
		String responseBody = response.getBody().asString();
		String[] split = responseBody.split("Reference is ");
		System.out.println(split[1]);
		System.out.println("<------Result of PAR Json------>");
		System.out.println("Response Body: " + responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);

		String string = split.toString();
	}

}
