package serenity;

import java.io.Closeable;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class TestRT implements Closeable {
	private static final ThreadLocal<TestRT> LOCAL = new ThreadLocal<TestRT>();
	private final WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public TestRT(WebDriver driver) {
		this.driver = driver;
		
		LOCAL.set(this);
	}
	
	public static TestRT current() {
		return LOCAL.get();
	}

	public void close() throws IOException {
		LOCAL.remove();
	}
}
