package com.lemubit.lemuel.architecturalcomponentsample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Database: Contains the database holder and serves as the main access point for the underlying connection to your app's persisted, relational data.
 * <p>
 * The class that's annotated with @Database should satisfy the following conditions:
 * <p>
 * Be an abstract class that extends RoomDatabase.
 * Include the list of entities associated with the database within the annotation.
 * Contain an abstract method that has 0 arguments and returns the class that is annotated with @Dao.
 **/
@Database(entities = {Course.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CourseDao courseDao();
}
