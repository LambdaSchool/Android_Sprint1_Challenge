package com.lambda.movie;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    String stringMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         TextView tv = findViewById(R.id.text_list);
        ArrayList<MovieList> aml=new ArrayList<MovieList>(3);

         //   String stringNew = extras.getString("STRING_I_NEED");
        aml=(ArrayList<MovieList>)getIntent().getSerializableExtra("DATA");
        MovieList ml=new MovieList("",true);
            if(aml==null){

                aml=new ArrayList<MovieList>(3);
            }
/*

            aml.add(ml);
            ml.fromString("[2] safsafsad", true);
        aml.add(ml);
        ml.fromString("fsfafsasafdsafsafsad", false);
        aml.add(ml);*/
            if(aml!=null)showResult(aml);
        findViewById(R.id.button_edit_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tva;
                TextView myTextView = (TextView)v;

                Context context;
                context=getApplicationContext();
                ArrayList<MovieList>[] aml=(ArrayList<MovieList>[])getIntent().getSerializableExtra("DATA");


                Intent intent=new Intent(context, EditingPageActivity.class);
                intent.putExtra("DATA", aml);

                startActivity(intent);
            }
        });

        findViewById(R.id.text_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tva;
                TextView myTextView = (TextView) v;



                Context context;
                context = getApplicationContext();
                ArrayList<MovieList>[] aml = (ArrayList<MovieList>[]) getIntent().getSerializableExtra("DATA");


                Intent intent = new Intent(context, EditingPageActivity.class);
                intent.putExtra("DATA", aml);

                startActivity(intent);

            }
        });

    }



    private void showResult(ArrayList<MovieList> aml) {


        String str = "";

        MovieList ml;
        TextView tva=findViewById(R.id.text_list);

        for (int i = 0; i < aml.size(); i++) {

            ml = aml.get(i);
            str = ml.toString();
            TextView tv = new TextView(getApplicationContext());



            tv.setText(str);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView tva = findViewById(R.id.text_list);
                    TextView myTextView = (TextView) v;
                    String stringAml = (String) myTextView.getText();
                    //MovieList ml=new MovieList(0, stringAml, true);
                    ArrayList<MovieList> aml=extractAMLfromTextview();
                    findMovieListAPI fpi=new findMovieListAPI();
                    aml=fpi.findMovieList(aml, stringAml);

                   // ml.setWatched(false);

                    Intent intent = new Intent(getApplicationContext(), EditingPageActivity.class);
                    intent.putExtra("DATA", aml);

                    startActivity(intent);
                    //  imageData.getUri();

                }


            });

/*
            if(ml.getWatched()==true){
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
                tva.setText(spannableString);

            }*/

            tva.append(tv.getText());

        }



    }


    private ArrayList<MovieList> extractAMLfromTextview(){
        MovieList ml=new MovieList(" ",false);
        ArrayList<MovieList> aml=new ArrayList<MovieList>();
        TextView tv=findViewById(R.id.text_list);
        String str=tv.getText().toString();
        char[] charTemp=str.toCharArray();;
        String stringTemp="";
        for(int i=0;i<str.length();i++){
            if(charTemp[i]=='\n'){
                ml.setName(stringTemp);
                stringTemp="";
                aml.add(ml);
            }else {
                stringTemp += charTemp[i];
            }

        }
        return aml;
    }


}


