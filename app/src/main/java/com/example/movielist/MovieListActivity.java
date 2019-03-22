package com.example.movielist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MovieListActivity extends AppCompatActivity {

    Button buttonAdd;
    LinearLayout ll;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context   = this;
        buttonAdd = findViewById(R.id.add_button);
        ll        = findViewById(R.id.ll_scrollview);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddMovieActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = this.getIntent();
        if(intent.getExtras() != null) {
            if (intent.getStringExtra("FirstKey").equals("add")) {
                TextView tv = new TextView(context);
                tv.setText("test");

               ll.addView(createTextView(MovieEntryRepo.getMovieEntry(intent.getIntExtra("key", 0)-1)));
            }
        }

    }

    public TextView createTextView(final MovieEntry entry){
        TextView tv = new TextView(context);
        tv.setText(entry.getTitle());
        tv.setPadding(15,7,15,7);
        tv.setTextSize(24);
        tv.setId(entry.getId());
      //  if(entry.isWatched()){
        //    tv.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
       // }

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AddMovieActivity.class);
                intent.putExtra(MovieEntry.TAG, entry);
                //ll.removeView(tv);
                startActivity(intent);
            }
        });
        return tv;
    }
}
