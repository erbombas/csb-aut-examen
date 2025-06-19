package com.demoblaze.runners;

import com.demoblaze.utils.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(features = "src/test/resources/features/GestionProductos.feature",
        glue = "com.demoblaze.stepsDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class AutenticacionRunner {
    @BeforeAll
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("src/test/resources/features");
    }
}
