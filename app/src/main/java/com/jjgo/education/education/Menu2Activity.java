package com.jjgo.education.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import static android.view.View.GONE;

public class Menu2Activity extends AppCompatActivity {

    //Layout Attributes..
    private LinearLayout ll_content;
    private LinearLayout ll_first;

    //Button Attributes
    private Button btnShoes;
    private Button btnHelmet;
    private Button btnEducation;
    private Button btnGear;

    private PDFView pdfView;
    private TextView tvPdfTitle;

    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

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
                    startActivity(new Intent(Menu2Activity.this, Main.class));
                    finish();
                }
            }
        });

        tvPdfTitle = (TextView)findViewById(R.id.tv_pdf_title);
        //Button Attributes
        btnEducation = (Button) findViewById(R.id.btn_safety_education);
        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(GONE);
                ll_content.setVisibility(View.VISIBLE);
                setPDF("menu2Education.pdf");
            }
        });

        btnGear = (Button) findViewById(R.id.btn_safety_gear);
        btnGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(GONE);
                ll_content.setVisibility(View.VISIBLE);
                setPDF("menu2Gear.pdf");
            }
        });

        btnShoes = (Button)findViewById(R.id.btn_shoes);
        btnShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu2Activity.this, Menu2_1Activity.class));
                finish();
            }
        });

        btnHelmet = (Button) findViewById(R.id.btn_helmet);
        btnHelmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu2Activity.this, Menu2_2Activity.class));
                finish();
            }
        });

    }

    private void setPDF(String filename) {

        Log.d("Menu2Activity", "filename ; " + filename);

        if (!filename.contains("Gear"))
            tvPdfTitle.setText("교육매뉴얼");
        else
            tvPdfTitle.setText("장비매뉴얼");

        pdfView.fromAsset(filename).load();
    }
}
