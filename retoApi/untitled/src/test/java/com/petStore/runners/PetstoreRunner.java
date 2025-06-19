package com.petStore.runners;

import com.petStore.Utils.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(features = "src/test/resources/features/PetStore.feature",
        glue = "com.petStore.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class PetstoreRunner {

    @BeforeAll
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("src/test/resources/features/api");
    }
}
