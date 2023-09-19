package com.steps;

import io.cucumber.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = "", features = {"src/test/resources/Final/Project/Login.feature"}, glue = {"com.steps"},
                 plugin = {})
    
public class TestRunner extends AbstractTestNGCucumberTests {
    
}