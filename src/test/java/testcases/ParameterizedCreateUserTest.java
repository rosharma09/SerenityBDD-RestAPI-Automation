package testcases;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import stepdefination.ReqresAPIStep;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/testdata/CreateUserData.csv")
public class ParameterizedCreateUserTest {

	private String name;
	private String job;

	public void setName(String name) {
		this.name = name;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Steps
	ReqresAPIStep api;

	@Title(value = "Parameterized Create user test using POST request")
	@Test
	public void createUserParameterizedTest() {
		api.createUserWith(name, job);
		api.checkStatusCode(201);
	}

}
