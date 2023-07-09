package managers;

import dataProviders.ConfigFileReader;

/**
 * File Reader Manager as Singleton Design Pattern to control object creation. The FileReaderManager
 * class maintains a static reference to its own instance, and returns that reference from the
 * static getInstance() method.
 */
public class FileReaderManager {

  //Private Instance of Class
  private static FileReaderManager fileReaderManager = new FileReaderManager();
  private static ConfigFileReader configFileReader;

  //Restrict Object Creation
  private FileReaderManager() {
  }

  //Public Methods to access the class
  public static FileReaderManager getInstance() {
    return fileReaderManager;
  }

  public ConfigFileReader getConfigFileReader() {
    return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
  }
}
