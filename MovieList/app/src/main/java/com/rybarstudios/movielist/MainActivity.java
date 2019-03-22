package com.rybarstudios.movielist;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

    }

    private TextView genTextView(Movie movie) {
        TextView view = new TextView(context);
        view.setText(movie.getTitle());
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);

        if(movie.isWatched()) {
            view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        return view;
    }
}
