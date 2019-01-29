package com.hundsun.operation.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ryan
 * @date 2018-12-29.
 */
@Configuration
public class CommonConfig {

    @Value("${des.salt:8js$endl}")
    private String encodeSalt;
    @Value("${jwt.secret:hundsun}")
    private String jwtSecret;

    public String getEncodeSalt() {
        return encodeSalt;
    }

    public void setEncodeSalt(String encodeSalt) {
        this.encodeSalt = encodeSalt;
    }

    public String getJwtSecret() {
        return jwtSecret;
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }
}
