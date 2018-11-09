package com.example.joshh.sprint1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll;
    private Button addMovieButton;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = findViewById(R.id.parent_layout);
        addMovieButton = findViewById(R.id.add_movie_button);
        context = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        addMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
            }
        });
    }

    private TextView createDefaultTextView(String text){
        /*<TextView
        android:layout_width="368dp"
        android:layout_height="wrap_content"
        android:paddingLeft="15dp"
        android:text="TextView"
        android:textColor="@android:color/black"
        android:textSize="30sp"
        android:typeface="normal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        tools:layout_editor_absoluteY="16dp" />*/
        TextView tv = new TextView(context);
        return tv;
    }
}
