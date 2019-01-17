package com.lemubit.lemuel.architecturalcomponentsample.repository;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.lemubit.lemuel.architecturalcomponentsample.database.AppDatabaseManager;
import com.lemubit.lemuel.architecturalcomponentsample.database.Course;

import java.util.concurrent.CompletableFuture;

/**
 * Repository modules handle data operations. They provide a clean API so that the rest of the app can retrieve this data easily.
 * They know where to get the data from and what API calls to make when data is updated.
 * You can consider repositories to be mediators between different data sources, such as persistent models, web services, and caches.
 **/
public class CourseRepository {
    public MutableLiveData<Integer> getCourseWeightTotal(Context context) {
        final MutableLiveData<Integer> data = new MutableLiveData<>();
        final int[] value = new int[1];
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> AppDatabaseManager.getAppDatabase(context).courseDao().getCourseWeightTotal()).thenAccept(integer -> value[0] = integer);
        completableFuture.join();
        data.setValue(value[0]);
        return data;
    }

    public void saveNewCourse(Context context, String name, int weight) {
        Course course = new Course();
        course.courseName = name;
        course.courseWeight = weight;
        CompletableFuture.supplyAsync(() -> {
            AppDatabaseManager.getAppDatabase(context).courseDao().insertAll(course);
            return 0;
        });
    }
}
