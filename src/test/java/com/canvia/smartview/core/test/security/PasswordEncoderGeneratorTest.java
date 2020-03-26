package com.canvia.smartview.core.test.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PasswordEncoderGeneratorTest {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordEncoderGeneratorTest.class);

    @Test
    public void generatePasswordEncoded() {

        int i = 0;
        while (i < 10) {
            String password = "123456";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);

            System.out.println(hashedPassword);
            LOG.info(i + ": hashedPassword==> " + hashedPassword);
            i++;
        }

    }
}
