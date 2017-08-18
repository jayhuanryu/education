package com.jjgo.education.education;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FourDCenter extends AppCompatActivity {

    //Image Attributes
    private ImageView imgBack;
    private ImageView imgReady;
    private ImageView imgStart;

    //Button Attributes
    private Button btnEducation;
    private Button btnGear;

    //Layout Attributes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_dcenter);

        //돌아가기 버튼
        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //교육매뉴얼
        btnEducation = (Button) findViewById(R.id.btn_education);
        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //장비
        btnGear = (Button) findViewById(R.id.btn_gear);
        btnGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}
