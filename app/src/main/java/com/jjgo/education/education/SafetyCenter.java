package com.jjgo.education.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.barteksc.pdfviewer.PDFView;

import static android.view.View.GONE;

public class SafetyCenter extends AppCompatActivity {

    //Layout Attributes..
    private LinearLayout ll_content;
    private LinearLayout ll_first;

    //Button Attributes
    private Button btnShoes;
    private Button btnHelmet;
    private Button btnEducation;
    private Button btnGear;

    private PDFView pdfView;

    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_center);

        //Layout Attributes
        ll_first = (LinearLayout) findViewById(R.id.ll_safety_first);
        ll_content = (LinearLayout) findViewById(R.id.ll_safety_content);

        //pdf viewer
        pdfView = (PDFView)findViewById(R.id.pdf_safety);

        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll_content.getVisibility() == View.VISIBLE) {
                    ll_first.setVisibility(View.VISIBLE);
                    ll_content.setVisibility(GONE);
                } else {
                    startActivity(new Intent(SafetyCenter.this, Main.class));
                    finish();
                }
            }
        });

        //Button Attributes
        btnEducation = (Button) findViewById(R.id.btn_safety_education);
        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(GONE);
                ll_content.setVisibility(View.VISIBLE);
                setPDF("safetyEducation.pdf");
            }
        });

        btnGear = (Button) findViewById(R.id.btn_safety_gear);
        btnGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(GONE);
                ll_content.setVisibility(View.VISIBLE);
                setPDF("safetyGear.pdf");
            }
        });

        btnShoes = (Button)findViewById(R.id.btn_shoes);
        btnShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SafetyCenter.this, SafetyShoeActivity.class));
                finish();
            }
        });

        btnHelmet = (Button) findViewById(R.id.btn_helmet);
        btnHelmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SafetyCenter.this, SafetyHelmetActivity.class));
                finish();
            }
        });

    }

    private void setPDF(String filename) {
        pdfView.fromAsset(filename).load();
    }
}
