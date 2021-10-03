package com.yillint.spring5.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLog {

    private static final Logger log = LoggerFactory.getLogger(UserLog.class);

    public static void main(String[] args) {
        log.info("Hello log4j2");
        log.error("Hello log4j2");
    }
}
