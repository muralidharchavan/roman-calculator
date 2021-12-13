package application.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static Properties props = new Properties();

    static {
        try {
            ClassLoader classLoader = Config.class.getClassLoader();
            InputStream input = classLoader.getResourceAsStream("env.properties");
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private static String url = Config.props.getProperty("url");

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Config.url = url;
    }
}
