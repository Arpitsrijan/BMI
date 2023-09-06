package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmicalculation extends AppCompatActivity {
    android.widget.Button mrecalculatebmi;
    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout mbackground;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculation);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font colour=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable= new ColorDrawable((Color.parseColor("#1E1D1D")));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        intent=getIntent();

        mbmidisplay=findViewById(R.id.textbmi);
        mbmicategory=findViewById(R.id.textdeclaration);
        mgender=findViewById(R.id.textgender);
        mbackground=findViewById(R.id.relativelayout);

        mrecalculatebmi = findViewById(R.id.recalculatebmi);


        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;
        intbmi= intweight/(intheight*intheight);
        mbmi=Float.toString(intbmi);

        if(intbmi<16){
            mbmicategory.setText("Severe Thinness! Please take care of your health ");
           // mbackground.setBackgroundColor(Color.RED);

        }
        else if (intbmi>16 && intbmi<16.9){
            mbmicategory.setText("Moderate Thinness! Please take care of your health ");
            //mbackground.setBackgroundColor(Color.RED);
        }
        else if (intbmi>16.9 && intbmi<18.4){
            mbmicategory.setText("Mild Thinness! Please take care of your health ");
           // mbackground.setBackgroundColor(Color.RED);

        }
        else if (intbmi>18 && intbmi<25){
            mbmicategory.setText("Fit! You are absolutely perfect ");
            //mbackground.setBackgroundColor(Color.GREEN);

        }
        else if (intbmi>25){
            mbmicategory.setText("OverWeight! Please take care of your health ");
            //mbackground.setBackgroundColor(Color.RED);

        }

mgender.setText(intent.getStringExtra("gender"));
mbmidisplay.setText(mbmi);









        getSupportActionBar().hide();
        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bmicalculation.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }
}