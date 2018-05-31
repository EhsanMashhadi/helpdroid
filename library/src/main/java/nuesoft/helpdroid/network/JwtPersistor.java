package nuesoft.helpdroid.network;

interface JwtPersistor {

    String get();

    boolean save(String jwt);

    boolean delete();
}
