package serenity;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;


@RunWith(SerenityRunner.class)
public class SimpleTest {

	@Managed
	private WebDriver driver;
	
	
	public static class MySteps {				
		@Step
		public void firstStep() {			
			TestRT.current().getDriver().get("https://google.com");
		}
	}
	
	@Steps MySteps mysteps;
	
	@Test
	public void sampleFunction() throws IOException {
		try (TestRT rt = new TestRT(driver)) {
			mysteps.firstStep();
		}
	}
}
