package com.lemubit.lemuel.architecturalcomponentsample.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * DAO: Contains the methods used for accessing the database.
 */

@Dao
public interface CourseDao {
    @Query("SELECT * FROM course")
    List<Course> getAll();

    @Query("SELECT * FROM course WHERE courseId IN (:courseIds)")
    List<Course> loadAllByIds(int[] courseIds);

    @Query("SELECT * FROM course WHERE courseName LIKE :name LIMIT 1")
    Course findByCourseName(String name);

    @Query("SELECT * FROM course WHERE courseWeight IN (:weight)")
    List<Course> findByCourseWeight(String[] weight);

    @Query("SELECT SUM(courseWeight) FROM course")
    int getCourseWeightTotal();

    @Insert
    void insertAll(Course... courses);

    @Delete
    void deleteCourse(Course courses);
}
