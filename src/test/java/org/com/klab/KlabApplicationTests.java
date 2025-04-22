package org.com.klab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest(properties = "spring.profiles.active=test")
class KlabApplicationTests {
    @Test
    void contextLoads() {
    }

}
