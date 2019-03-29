package com.lambda.movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


public class EditingPageActivity extends AppCompatActivity {
    static MovieList mlCurrent;
    Switch swWatched;
    EditText etInputData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_editing_page);
        super.onCreate(savedInstanceState);


        receiveData();

        swWatched.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView tvd=findViewById(R.id.text_debug_for_switch);
                if (isChecked) {
                    tvd.append("TRUE");// The toggle is enabled
                } else {
                    tvd.append("FALSE"); // The toggle is disabled
                }
            }
        });
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // search for drug by brand name
                TextView currentTextView =findViewById (R.id.input_data);
                sendData(currentTextView);

            }
        });
        findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // search for drug by brand name
                TextView currentTextView =findViewById (R.id.button_delete);
                sendDatatoDelete(currentTextView);
            }
        });
    }



    private void receiveData(){
       etInputData=findViewById(R.id.input_data);

        swWatched =findViewById(R.id.switch_watched);
        mlCurrent=(MovieList) getIntent().getSerializableExtra("DATA");
        swWatched.setChecked(mlCurrent.getWatched());

        etInputData.setText(mlCurrent.getName());


        swWatched.setOnCheckedChangeListener(null);
        swWatched.setChecked(mlCurrent.isWatched());
        swWatched.invalidate();

    }

    private void sendData(TextView tv){
        Context context = getApplicationContext();
        Switch sw=findViewById(R.id.switch_watched);
        mlCurrent.setName(tv.getText().toString());
        mlCurrent.setWatched(sw.isChecked());

        MovieList ml=mlCurrent;
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("DATA", ml);

        startActivity(intent);
    }

    private void sendDatatoDelete(TextView tv){
        Context context = getApplicationContext();
        Switch sw=findViewById(R.id.switch_watched);

        mlCurrent.setName(""); //Trigger to delete
    //    mlCurrent.setWatched(sw.isChecked()); //not necessary

        MovieList ml=mlCurrent;

        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("DATA", ml);

        startActivity(intent);
    }

}
