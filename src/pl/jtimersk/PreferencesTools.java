package pl.jtimersk;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferencesTools {

        private Preferences prefs;

    public void setPreference(String key, String value) {

        prefs = Preferences.userRoot().node(this.getClass().getName());

        prefs.put(key, value);

    }

    public void deleteAllPreferences() throws BackingStoreException {

        prefs = Preferences.userRoot().node(this.getClass().getName());

        prefs.clear();
    }

    public String getPreference(String key){

        prefs = Preferences.userRoot().node(this.getClass().getName());

        return prefs.get(key, null);
    }

}
