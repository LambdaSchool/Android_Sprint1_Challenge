package com.lambda.movie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    static MovieList mlCurrent;

    private static ArrayList<MovieList> alMovieList = new ArrayList<MovieList>(100);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button_edit_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData(null);
            }
        });

        findViewById(R.id.text_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView currentTextView = (TextView)v;
                sendData(currentTextView);
            }
        });
    }

    private void receiveData(){
        MovieList ml=(MovieList) getIntent().getSerializableExtra("DATA");
        if(ml==null)return;
        findMovieListAPI fml=new findMovieListAPI(alMovieList);

        if(ml.getName().equals("")){//Delete
            alMovieList=fml.deleteMovieList(ml);

                  //  if(mlCurrent==null)
        }else{

            alMovieList=fml.updateMovieList(ml);
        }
    }





    @Override

    protected void onResume () {

        super.onResume();

        Log.i("ActivityLifecycle", getLocalClassName() + " - onResume");

        setContentView(R.layout.activity_main);


        receiveData();

        if (mlCurrent == null) {

            //these are initial dummy
            MovieList ml=new MovieList(1,"test1",true);

            this.alMovieList.add(ml);
            MovieList ml1=new MovieList(2,"test2",false);
            this.alMovieList.add(ml1);
            MovieList ml2=new MovieList(3,"test3",true);
            this.alMovieList.add(ml2);
            mlCurrent=ml2;

        }

        if (alMovieList != null){

           showResult(alMovieList);
        }



        findViewById(R.id.button_edit_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendEmptyData();
            }
        });
    }

    private void sendData(TextView tv){
        Context context = getApplicationContext();

       findMovieListAPI fml=new findMovieListAPI(alMovieList);
        mlCurrent=fml.findMovieListByIndex(indexExtractedFromString(tv.getText().toString()));

        Intent intent = new Intent(context, EditingPageActivity.class);
        intent.putExtra("DATA", mlCurrent);
        startActivity(intent);
    }

    private int indexExtractedFromString(String stringName){
        int start=0;
        for(int i=0;i<stringName.length();++i){
            switch(stringName.charAt(i)) {
                case '[':
                    start = i + 1;
                    break;
                case ']':
                    String test=stringName.substring(start,i);
                    return Integer.parseInt(stringName.substring(start,i));
            }

        }
        return 0;
    }

    private void sendEmptyData(){ //to add
        Context context = getApplicationContext();

        MovieList ml=new MovieList(-1,"",true);


        Intent intent = new Intent(context, EditingPageActivity.class);
        intent.putExtra("DATA", ml);
        startActivity(intent);
    }

    private void showResult(ArrayList<MovieList> aml) {

        Context     context= getApplicationContext();
        String str = "";
        LinearLayout ll = findViewById(R.id.scrolling_view);

        MovieList ml;
        for (int i = 0; i < aml.size(); i++) {

            ml = aml.get(i);
            if(ml==null){
                str=" /n";
                return;
            }else{
                str = ml.toString();
            }
            TextView tv = new TextView(context);

           SpannableString spannable = new SpannableString(str);
            if(ml.getWatched()==true) {
                spannable.setSpan(new StrikethroughSpan(), 0, str.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                tv.setText(spannable);
            }else{
                tv.setText(str);

            }

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView currentTextView = (TextView)v;
                    sendData(currentTextView);
                }
            });

            ll.addView(tv);
        }
    }
}


