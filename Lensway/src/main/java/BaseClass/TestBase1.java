package BaseClass;

package com.lensway;


import com.lensway.util.PropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.lensway.util.FileProvider.saveToFile;

public class BaseConfiguration {

    private URL gridHubUrl;
    protected String baseUrl;
    private Capabilities capabilities;
    protected WebDriver driver;
    protected String country;
    protected String browser;
    private static final Logger LOG = LogManager.getLogger(BaseConfiguration.class);
    protected static final String CATEGORIES_PATH = "/categories.properties";
    protected static final String FILTERS_PATH = "/search-filters.properties";

    public WebDriver getDriver() {
        return driver;
    }


    @BeforeMethod
    @Parameters({"browser", "country", "platform"})
    public void initWebDriver(String browser, String country, String platform) {
        baseUrl = PropertyLoader.loadBaseUrl(country);
        gridHubUrl = PropertyLoader.loadHubUrl();
        capabilities = PropertyLoader.loadCapabilities(browser, platform);
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        if (!browser.equals("iphone") && !browser.equals("ipad")) {
            driver.manage().window().maximize();
            if (driver.manage().window().getSize().getWidth() < 1200 || driver.manage().window().getSize().getHeight() < 1000) {
                driver.manage().window().setSize(new Dimension(1280, 1060));
            }
        }
        LOG.info("Window size is:" + driver.manage().window().getSize());
        this.country = country;
        this.browser = browser;
    }

    @AfterMethod()
    public void closeBrowser() {
        WebDriverPool.DEFAULT.dismissDriver(this.driver);
    }

    @AfterSuite
    public void tearDown() {
        WebDriverPool.DEFAULT.dismissAll();
    }

    protected String getFilter(String category, String filter, String filePath) {
        if ("price".equals(category)) {
            if ("se".equalsIgnoreCase(this.country) || "no".equalsIgnoreCase(this.country) || "dk".equalsIgnoreCase(this.country)) {
                return PropertyLoader.loadProperty(filter + "_kr", filePath);
            } else {
                return PropertyLoader.loadProperty(filter + "_eu", filePath);
            }
        } else if ("productType".equals(category) && ("glasses".equals(filter) || "sunglasses".equals(filter) || "lenses".equals(filter) || "solution".equals(filter))) {
            return PropertyLoader.loadProperty(this.country + "_" + filter, filePath);
        } else {
            return PropertyLoader.loadProperty(filter, filePath);
        }
    }

    protected void setFilter(String category, String subCategory) {
    }

    protected void selectFilters(List<List<String>> filters) {
        for (List<String> filter : filters) {
            String category = PropertyLoader.loadProperty(filter.get(0), CATEGORIES_PATH);
            String subCategory = getFilter(filter.get(0), filter.get(1), FILTERS_PATH);
            if (category.isEmpty() && subCategory.isEmpty()) {
                return;
            }
            setFilter(category, subCategory);
        }
    }

    protected void save(List<String> dataList, String fileName) {
        try {
            saveToFile(dataList, fileName);
        } catch (IOException e) {
            LOG.error(e.getLocalizedMessage());
        }
    }
}





