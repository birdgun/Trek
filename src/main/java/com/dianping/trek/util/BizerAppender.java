package com.dianping.trek.util;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.PatternLayout;

import com.dianping.trek.spi.TrekContext;

public class BizerAppender extends DailyRollingFileAppender {
    private String basePath;
    private String appName;
    
    public BizerAppender(String basePath, String appName) {
        this.basePath = basePath;
        this.appName = appName;
        try {
            super.setFile(basePath + File.separator + appName, true, false, 1024);
        } catch (IOException e) {
            try {
                super.setFile(TrekContext.getDefaultBasePath() + File.separator + appName, true, false, 1024);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        super.setDatePattern("'.'yyyy-MM-dd.HH");
        super.setLayout(new PatternLayout());
        super.activateOptions();
    }

    @Override
    public String toString() {
        return "BizerAppender [basePath=" + basePath + ", appName=" + appName
                + "]";
    }
}
