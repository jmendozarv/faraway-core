package com.canvia.smartview.core.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component("bCryptPasswordEncoder")
public class PasswordEncoder extends BCryptPasswordEncoder {

}
