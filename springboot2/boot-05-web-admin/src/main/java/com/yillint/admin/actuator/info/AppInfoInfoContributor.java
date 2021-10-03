package com.yillint.admin.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AppInfoInfoContributor implements InfoContributor {


    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("mesg","你好")
                .withDetail("hello","YilLint")
                .withDetails(Collections.singletonMap("world","666666"));
    }
}
