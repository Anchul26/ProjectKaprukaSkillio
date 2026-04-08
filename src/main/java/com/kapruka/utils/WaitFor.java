package com.kapruka.utils;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sourcePackage.Keyword;

/**
 * Utility wait helpers. Create a new WebDriverWait per call so it always uses the current thread's driver.
 */
public class WaitFor {

    private static WebDriverWait newWait() {
        WebDriverWait wait = new WebDriverWait(Keyword.threadLocal.get(), Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }

    private WaitFor() {
        // prevent instantiation
    }

    public static void elementToBeVisible(By element) {
        newWait().until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void elementToBeClickable(By element) {
        newWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void stalenessOfElement(WebElement element) {
        newWait().until(ExpectedConditions.stalenessOf(element));
    }

}