package com.lemubit.lemuel.architecturalcomponentsample.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Entity: Represents a table within the database.
 */
@Entity
public class Course {
    public String courseName;
    public int courseWeight;
    @PrimaryKey(autoGenerate = true)
    int courseId;


}
