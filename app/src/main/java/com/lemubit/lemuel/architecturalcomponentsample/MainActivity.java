package com.lemubit.lemuel.architecturalcomponentsample;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lemubit.lemuel.architecturalcomponentsample.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    TextView courseName;
    TextView courseWeight;
    TextView totalWeight;
    Button addNewCourse;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalWeight = findViewById(R.id.txt_total_weights);
        courseName = findViewById(R.id.etxt_course_name);
        courseWeight = findViewById(R.id.etxt_course_weight);
        addNewCourse = findViewById(R.id.btn_add_new_course);

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        viewModel.init(getApplicationContext());

        addNewCourse.setOnClickListener(v -> {
            viewModel.saveNewCourse(getApplicationContext(), courseName.getText().toString(), Integer.valueOf(courseWeight.getText().toString()));
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        viewModel.getCourseWeightTotal().observe(MainActivity.this, integer -> {
            Toast.makeText(this, "New stuffs", Toast.LENGTH_SHORT).show();
            totalWeight.setText(String.valueOf(integer));
        });
    }

}
