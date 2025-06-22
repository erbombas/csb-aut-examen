package petstore;

import com.intuit.karate.junit5.Karate;

public class apiTest {
    @Karate.Test
    Karate testAPI() {
        return Karate.run("api").relativeTo(getClass());
    }
}
