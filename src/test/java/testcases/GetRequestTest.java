package testcases;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.qa.api.base.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import stepdefination.ReqresAPIStep;

@RunWith(SerenityRunner.class)
public class GetRequestTest extends TestBase{

	@Steps
	ReqresAPIStep api;

	@Title(value = "Sample test for get request")
	@Test
	public void getUserTest() {

		api.getUserDetails("1");
		api.checkStatusCode(200);

	}

}
