package com.yillint.hello.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("yillint.hello")
public class HelloPeoperties {

    private String prefix;
    private String suffix;
            
        public String getPrefix() {
            return prefix;
        }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffi) {
        this.suffix = suffi;
    }
}
