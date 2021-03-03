package stepdefination;

import java.util.HashMap;

import org.json.JSONObject;

import com.qa.api.base.TestBase;
import static com.qa.api.util.Utilities.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ReqresAPIStep extends TestBase {

	private Response httpResponse;

	@Step("To GET the user details having user id: {0}")
	public void getUserDetails(String uId) {
		System.out.println("User id Selected: " + uId);
		httpResponse = SerenityRest.given().when().get(uId);

		/**
		 * Print the Http response
		 */

		httpResponse.prettyPrint();
		JSONObject jsonInput = new JSONObject(httpResponse.toString());
		
		getKey(jsonInput, "id");

	}

	@Step("To CREATE the user with name : {0} and jobTitile : {1}")
	public void createUserWith(String eName, String jTitle) {

		System.out.println("Creating user via CREATE user API!");
		System.out.println("Email Id: " + eName + " Job Title: " + jTitle);

		HashMap<String, String> UserData = new HashMap<String, String>();
		UserData.put("name", eName);
		UserData.put("job", jTitle);

		httpResponse = SerenityRest.given().contentType(ContentType.JSON).body(UserData).log().all().post();
		httpResponse.prettyPrint();

	}

	@Step("To DELETE the user having the user id : {0}")
	public void deleteUserHavingUserIdAs(String uId) {
		System.out.println("Deleting the user with DELETE API");
		System.out.println("User id for the User: " + uId);

		httpResponse = SerenityRest.given().when().delete(uId);
		httpResponse.prettyPrint();
	}

	@Step("The status code for the request should be: {0}")
	public void checkStatusCode(int statCode) {
		System.out.println("Expected Status code: " + statCode);
		System.out.println("Actual Status code: " + httpResponse.getStatusCode());
		httpResponse.then().statusCode(statCode);
	}

}
