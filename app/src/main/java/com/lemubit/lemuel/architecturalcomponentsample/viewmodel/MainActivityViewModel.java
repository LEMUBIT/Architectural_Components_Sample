package com.lemubit.lemuel.architecturalcomponentsample.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.lemubit.lemuel.architecturalcomponentsample.repository.CourseRepository;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<Integer> courseWeightTotal;
    private CourseRepository courseRepository;

    public MainActivityViewModel() {
        courseRepository = new CourseRepository();
    }

    public void init(Context context) {
        if (this.courseWeightTotal != null) {
            // ViewModel is created on a per-Fragment basis, so the userId
            // doesn't change.
            return;
        }
        courseWeightTotal = courseRepository.getCourseWeightTotal(context);
    }

    public LiveData<Integer> getCourseWeightTotal() {
        return this.courseWeightTotal;
    }

    public void saveNewCourse(Context context, String name, int weight) {
        courseRepository.saveNewCourse(context, name, weight);
        courseWeightTotal.setValue(courseWeightTotal.getValue() + weight);
    }
}
