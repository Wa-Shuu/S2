package com.washuu.s2.util;

import java.net.URL;

public class getClassPathFileUrl {
    public static String getUrl(String fileName) {
        ClassLoader classLoader = getClassPathFileUrl.class.getClassLoader();
        URL url = classLoader.getResource(fileName);
        System.out.println(url.getFile());
        return url.getFile();
    }
}
