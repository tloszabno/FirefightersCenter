package pl.agh.tomtom.firefighters.remote;

class FirefightersPostUrlProvider {

  static String getFullUrlValue(String ipAndPort, String path){
    return   "http://" + ipAndPort + "/firefightersPost/" + path;
  }
}
