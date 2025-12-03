package com.OrangeHRMTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test",
        glue = "com.OrangeHRMTests",
        plugin = {"pretty","json:target/CucumberReport.json","html:target/CucumberReport.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests
{

}
