package dataProviders;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Class to read the .properties file Advantage of using properties file is we can store
 * configurable things that are prone to change. It doesn't require recompiling of project after
 * making changes in the .properties file
 */
public class ConfigFileReader {

  private Properties properties;
  private static final String propertyFilePath = "src/test/resources/configs/Configuration.properties";

  //Read Properties File
  public ConfigFileReader() {
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(propertyFilePath));
      properties = new Properties();
      try {
        properties.load(reader);
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
    }
  }

  //Getter Methods
  public long getImplicitWait() {
    String implicitlyWait = properties.getProperty("implicitWaitTime");
    if (implicitlyWait != null) {
      return Long.parseLong(implicitlyWait);
    } else {
      throw new RuntimeException(
          "implicitWaitTime not specified in Configuration.properties file @ " + propertyFilePath);
    }
  }

  public String getApplicationURL() {
    String urlAddress = properties.getProperty("AUT_url");
    if (urlAddress != null) {
      return urlAddress;
    } else {
      throw new RuntimeException(
          "prod_url key not specified in Configuration.properties file @ " + propertyFilePath);
    }
  }

  public DriverType getBrowser() {
    String browserName = properties.getProperty("browser");
    if (browserName == null || browserName.equalsIgnoreCase("chrome")) {
      return DriverType.CHROME;
    } else if (browserName.equalsIgnoreCase("firefox")) {
      return DriverType.FIREFOX;
    } else if (browserName.equalsIgnoreCase("edge")) {
      return DriverType.EDGE;
    } else if (browserName.equalsIgnoreCase("safari")) {
      return DriverType.SAFARI;
    } else {
      throw new RuntimeException(
          "Browser Name Key is not specified in Configuration.properties file @ "
              + propertyFilePath);
    }
  }

  public EnvironmentType getEnvironment() {
    String environmentName = properties.getProperty("environment");
    if (environmentName == null || environmentName.equalsIgnoreCase("local")) {
      return EnvironmentType.LOCAL;
    } else if (environmentName.equalsIgnoreCase("remote")) {
      return EnvironmentType.REMOTE;
    } else {
      throw new RuntimeException(
          "Environment Type Key is not specified in Configuration.properties file @ "
              + propertyFilePath);
    }
  }

  public boolean getWindowSize() {
    String windowSize = properties.getProperty("windowMaximize");
    if (windowSize != null) {
      return Boolean.parseBoolean(windowSize);
    } else {
      return true;
    }
  }

  public String getToEmailAddress() {
    String toEmail = properties.getProperty("to_email_address");
    if (toEmail != null) {
      return toEmail;
    } else {
      throw new RuntimeException(
          "to_address key not specified in Configuration.properties file @ " + propertyFilePath);
    }
  }

  public String getFromEmailAddress() {
    String fromEmail = properties.getProperty("from_email_address");
    if (fromEmail != null) {
      return fromEmail;
    } else {
      throw new RuntimeException(
          "from_address key not specified in Configuration.properties file @ " + propertyFilePath);
    }
  }

  public String getFromEmailAddressPassword() {
    String fromPassword = properties.getProperty("from_email_address_password");
    if (fromPassword != null) {
      return fromPassword;
    } else {
      throw new RuntimeException(
          "from_address_password key not specified in Configuration.properties file @ "
              + propertyFilePath);
    }
  }
}
