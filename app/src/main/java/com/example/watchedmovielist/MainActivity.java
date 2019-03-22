package com.example.watchedmovielist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
    ArrayList<MovieListing> movies = new ArrayList<MovieListing>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        LinearLayout l = (LinearLayout) findViewById(R.id.line_man);

    }

    private TextView createMovieView(final MovieListing m){
        TextView view = new TextView(context);
        view.setText(m.getName());
        if(m.isWatched()) {
            view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailsActivityIntent = new Intent(context, EditActivity.class);
                detailsActivityIntent.putExtra("KEY",movies);
                startActivity(detailsActivityIntent);
            }
        });
        return view;
    }


}
