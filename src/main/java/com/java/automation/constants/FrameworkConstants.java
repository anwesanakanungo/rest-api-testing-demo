package com.java.automation.constants;

import java.io.File;

public class FrameworkConstants {
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String RESOURCES_FOLDER_PATH = PROJECT_PATH + File.separator + "src" + File.separator
            + "main" + File.separator + "resources";
    public static final String CONFIG_PROPERTIES_PATH = RESOURCES_FOLDER_PATH + File.separator + "config.properties";
    public static final String JSON_SCHEMA_PATH = RESOURCES_FOLDER_PATH + File.separator + "json" + File.separator + "json-schema.json";
    public static final int MAXRETRYCOUNT=3;
}
