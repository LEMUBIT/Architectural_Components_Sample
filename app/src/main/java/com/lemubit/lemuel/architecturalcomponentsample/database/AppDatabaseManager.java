package com.lemubit.lemuel.architecturalcomponentsample.database;

import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDatabaseManager {
    private static AppDatabase appDatabase;

    private static boolean initialized = false;

    private AppDatabaseManager() {

    }

    public static AppDatabase getAppDatabase(Context context) {
        if (initialized) {
            return appDatabase;
        }
        initialized = true;
        appDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "app-database-name").build();
        return appDatabase;
    }
}
