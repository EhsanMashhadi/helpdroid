package nuesoft.helpdroid.network;

import android.content.Context;
import android.content.SharedPreferences;

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

        return this.mSharedPreferences.getString(identifier, null);
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
        sharesPreferencesEditor.putString(identifier, jwt);
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
        sharesPreferencesEditor.remove(identifier);
        return sharesPreferencesEditor.commit();
    }
}
