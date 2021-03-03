package testcases;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.qa.api.base.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import stepdefination.ReqresAPIStep;

@RunWith(SerenityRunner.class)
public class PostRequestTest extends TestBase {

	@Steps
	ReqresAPIStep api;

	@Ignore
	@Title(value = "Sample test for POST request")
	@Test
	public void createUserTest() {
		api.createUserWith("morpheus", "leader");
		api.checkStatusCode(201);
	}

}
