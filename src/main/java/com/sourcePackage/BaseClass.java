package com.sourcePackage;

import static com.sourcePackage.Keyword.*;
import com.kapruka.utils.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

	// public RemoteWebDriver driver;
	String appURL = "https://www.kapruka.com/";

	// Keyword keyword = new Keyword();
	@BeforeMethod
	public void setup() {
		//threadLocal.get();
		openBrowser(App.getBrowserName());
		launchUrl(App.getUrl("qa"));
		threadLocal.get().manage().window().maximize();
	}

	@AfterMethod
	public void logout() {
		RemoteWebDriver drv = threadLocal.get();
		if (drv != null) {
			try {
				drv.quit();
				System.out.println("Driver quit successfully....!");
			} catch (Exception e) {
				System.out.println("Exception while quitting driver: " + e.getMessage());
			} finally {
				threadLocal.remove();
			}
		}
	}

}