package com.example.jacob.android_sprint1_challenge;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private LinearLayout layoutList;
    private NoteViewModel viewModel;

    public static final int EDIT_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        layoutList = findViewById(R.id.layout_list);

    }
}
