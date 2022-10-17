package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//import com.cucumber.listener.ExtentCucumberFormatter;


@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/features"},
        tags = "@testing",
        glue= {"stepdefinition"},
        dryRun = false,
//       plugin ={ "pretty","json:target/cucumber-reports/AutoumationReport/priscillareports.json"
        plugin ={ "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                //"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/AutomationReports/EDBCreditCards.html"
               },

        monochrome = true)
public class TestRunner {}
