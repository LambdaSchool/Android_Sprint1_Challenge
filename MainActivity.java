package com.lambda.movie;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String stringMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras =getIntent().getExtras();
        if(extras!=null) {
            TextView tv = findViewById(R.id.text_list);

         //   String stringNew = extras.getString("STRING_I_NEED");
            MovieList[] ml;
            ml=(MovieList[])getIntent().getSerializableExtra("DATA");


            tv.setText(showResult(ml));
        }
        findViewById(R.id.text_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tva;
                TextView myTextView = (TextView)v;

                Context context;
                context=getApplicationContext();


                Intent intent=new Intent(context, EditingPageActivity.class);
                intent.putExtra("STRING_I_NEED", myTextView.getText());

                startActivity(intent);


            }
        });

        findViewById(R.id.button_edit_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               TextView tv=findViewById(R.id.text_list);
               String str=tv.getText().toString();
                Intent intent=new Intent(getApplicationContext(), EditingPageActivity.class);
                intent.putExtra("STRING_I_NEED", str);

                startActivity(intent);
            }


        });

    }

    private String showResult(MovieList[] ml){

            String str=null;

            for(int i=0;i<ml.length;i++) {
                str=(String)("["+ml[i].getIndex()+"] "+ml[i].getName());

            }






            return str;

    }
}


