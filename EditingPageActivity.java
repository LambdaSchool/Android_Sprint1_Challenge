package com.lambda.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class EditingPageActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing_page);






    }

    @Override

    protected void onStart() {

        super.onStart();
        setContentView(R.layout.activity_editing_page);
        Log.i("ActivityLifecycle", getLocalClassName() + " - onStart");

        setContentView(R.layout.activity_editing_page);
        TextView tv = findViewById(R.id.input_data);

        ArrayList<MovieList> aml=(ArrayList<MovieList>)getIntent().getSerializableExtra("DATA");
        String stringNew;
        if(aml==null) {
            stringNew="0";
        }else{
            stringNew=aml.get(0).toString();
        }


        tv.setText(stringNew);

        Log.i("ActivityLifecycle", getLocalClassName() + " - onResume");
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // search for drug by brand name
                EditText et=findViewById(R.id.input_data);


                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                String str= et.getText().toString();
                boolean bWatched=false;
                Button bt=findViewById(R.id.button_watched);

                if(bt.getText().equals("Watched")){
                    bWatched=true;
                }


                //      intent.putExtra("STRING_I_NEED", str);
                MovieList ml=new MovieList(str,bWatched);
                ArrayList<MovieList> aml=new ArrayList<MovieList>();
                aml.add(ml);
                intent.putExtra("DATA", aml);
                startActivity(intent);

            }
        });







    }


    @Override

    protected void onResume() {

        super.onResume();
        setContentView(R.layout.activity_editing_page);
        TextView tv = findViewById(R.id.input_data);

        ArrayList<MovieList> aml=(ArrayList<MovieList>)getIntent().getSerializableExtra("DATA");
        String stringNew;
        if(aml==null) {
            stringNew="0";
        }else{
            stringNew=aml.get(0).toString();
        }


        tv.setText(stringNew);

        Log.i("ActivityLifecycle", getLocalClassName() + " - onResume");
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // search for drug by brand name
                EditText et=findViewById(R.id.input_data);


                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                String str= et.getText().toString();
                boolean bWatched=false;
                Button bt=findViewById(R.id.button_watched);

                if(bt.getText().equals("Watched")){
                    bWatched=true;
                }


          //      intent.putExtra("STRING_I_NEED", str);
                MovieList ml=new MovieList(str,bWatched);
                ArrayList<MovieList> aml=new ArrayList<MovieList>();
                aml.add(ml);
                intent.putExtra("DATA", aml);
                startActivity(intent);

            }
        });
    }


    // user interacting with app


    @Override

    protected void onPause() {

        super.onPause();

        Log.i("ActivityLifecycle", getLocalClassName() + " - onPause");

    }


    @Override

    protected void onStop() {

        super.onStop();

        Log.i("ActivityLifecycle", getLocalClassName() + " - onStop");

    }


    @Override

    protected void onDestroy() {

        super.onDestroy();

        Log.i("ActivityLifecycle", getLocalClassName() + " - onDestroy");

    }



}
