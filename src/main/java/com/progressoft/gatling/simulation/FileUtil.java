package com.progressoft.gatling.simulation;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.io.IOException;
import java.util.Set;
import java.util.regex.Pattern;

public class FileUtil {

    public static Object[] listFeatures() throws IOException {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("com.progressoft"))
                .setScanners(new ResourcesScanner())
                .filterInputsBy(new FilterBuilder().includePackage("com.progressoft"))
        );

        Set<String> properties =
                reflections.getResources(Pattern.compile(".*(hello1|hello2)\\.feature"));
        return properties.toArray();
    }

}
