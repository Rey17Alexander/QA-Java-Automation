import com.sun.org.glassfish.gmbal.Description;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson3_examples {
    private final Logger logger = LogManager.getLogger(Lesson3_examples.class);
    protected static WebDriver driver;

    @Before
    public void StartUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @After
    public void End(){
        if (driver!=null)
            driver.quit();
    }

    @Test
    @Description("Testing log4j2 logging level relatively to '<Root level = ?>' in log4j2.xml")
    public void LogExample(){
        logger.fatal("Test started. FATAL level");
        logger.error("Test started. ERROR level");
        logger.warn("Test started. WARN level");
        logger.info("Test started. INFO level");
        logger.debug("Test started. DEBUG level");
        logger.trace("Test started. TRACE level");
    }

    @Test
    public void WebDriverTest(){
        driver.get("https://otus.ru");
        logger.info("Сайт открыт");
    }
}
