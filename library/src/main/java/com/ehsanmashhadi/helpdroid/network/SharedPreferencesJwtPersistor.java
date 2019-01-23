package com.ehsanmashhadi.helpdroid.network;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SharedPreferencesJwtPersistor implements JwtPersistor {

    private final SharedPreferences mSharedPreferences;

    public SharedPreferencesJwtPersistor(Context context) {

        this(context.getSharedPreferences("JwtPersistence", Context.MODE_PRIVATE));
    }

    public SharedPreferencesJwtPersistor(Context context, String name) {

        this(context.getSharedPreferences(name, Context.MODE_PRIVATE));
    }

    public SharedPreferencesJwtPersistor(SharedPreferences sharedPreferences) {

        this.mSharedPreferences = sharedPreferences;
    }

    @Override
    public String get() {

        return this.mSharedPreferences.getString("jwt", null);
    }

    @Override
    public String get(String identifier) {

        return this.mSharedPreferences.getString("jwt" + identifier, null);
    }

    @Override
    public boolean save(String jwt) {

        SharedPreferences.Editor sharesPreferencesEditor = this.mSharedPreferences.edit();
        sharesPreferencesEditor.putString("jwt", jwt);
        return sharesPreferencesEditor.commit();
    }

    @Override
    public boolean save(String jwt, String identifier) {

        SharedPreferences.Editor sharesPreferencesEditor = this.mSharedPreferences.edit();
        sharesPreferencesEditor.putString("jwt" + identifier, jwt);
        return sharesPreferencesEditor.commit();
    }

    @Override
    public boolean delete() {

        SharedPreferences.Editor sharesPreferencesEditor = this.mSharedPreferences.edit();
        sharesPreferencesEditor.remove("jwt");
        return sharesPreferencesEditor.commit();
    }

    @Override
    public boolean delete(String identifier) {

        SharedPreferences.Editor sharesPreferencesEditor = this.mSharedPreferences.edit();
        sharesPreferencesEditor.remove("jwt" + identifier);
        return sharesPreferencesEditor.commit();
    }

    @Override
    public List<String> getAll() {

        List<String> jwtList = new ArrayList<>();
        for (Map.Entry<String, ?> entry : mSharedPreferences.getAll().entrySet()) {
            if (entry.getKey().startsWith("jwt")) {
                jwtList.add((String) entry.getValue());
            }
        }
        return jwtList;
    }

    @Override
    public boolean deleteAll() {

        SharedPreferences.Editor sharesPreferencesEditor = this.mSharedPreferences.edit();
        for (Map.Entry<String, ?> entry : mSharedPreferences.getAll().entrySet()) {
            if (entry.getKey().startsWith("jwt")) {
                sharesPreferencesEditor.remove(entry.getKey());
            }
        }
        return sharesPreferencesEditor.commit();
    }

    @Override
    public int size() {

        int i = 0;
        for (String string : mSharedPreferences.getAll().keySet()) {
            if (string.startsWith("jwt")) {
                i++;
            }
        }
        return i;
    }

    @Override
    public String getIdentifier(String jwt) {

        for (Map.Entry<String, ?> entry : mSharedPreferences.getAll().entrySet()) {
            String value = (String) entry.getValue();
            if (value.equals(jwt)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public boolean contains(String identifier) {

        return mSharedPreferences.contains(identifier);
    }
}