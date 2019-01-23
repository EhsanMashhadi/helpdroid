package com.ehsanmashhadi.helpdroid.network;

import java.util.List;

interface JwtPersistor {

    String get();

    String get(String identifier);

    boolean save(String jwt);

    boolean save(String jwt, String identifier);

    boolean delete();

    boolean delete(String identifier);

    List<String> getAll();

    boolean deleteAll();

    int size();

    String getIdentifier(String jwt);

    boolean contains(String identifier);
}
