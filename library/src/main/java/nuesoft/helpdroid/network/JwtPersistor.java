package nuesoft.helpdroid.network;

interface JwtPersistor {

    String get();

    String get(String identifier);

    boolean save(String jwt);

    boolean save(String jwt, String identifier);

    boolean delete();

    boolean delete(String identifier);
}
