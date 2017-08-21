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

public class SealedCenter extends AppCompatActivity {

    //Image Attributes
    private ImageView imgBack;
    private ImageView imgReady;
    private ImageView imgStart;

    //Button Attributes
    private Button btnEducation;
    private Button btnGear;

    //Layout Attributes;
    private LinearLayout ll_first;
    private LinearLayout ll_start;
    private LinearLayout ll_content;

    private LinearLayout ll_stop;

    //Text Attributes;
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sealed_center);

        //Setting Layouts
        ll_first = (LinearLayout) findViewById(R.id.ll_sealed_first);
        ll_start = (LinearLayout) findViewById(R.id.ll_sealed_start);
        ll_content = (LinearLayout) findViewById(R.id.ll_sealed_content);

        ll_stop = (LinearLayout)findViewById(R.id.ll_sealed_stop);

        //PDF content
        pdfView = (PDFView) findViewById(R.id.pdf_sealed);



        //돌아가기 버튼
        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ll_content.getVisibility() == View.VISIBLE) {
                    ll_first.setVisibility(View.VISIBLE);
                    ll_content.setVisibility(View.GONE);
                    ll_start.setVisibility(View.GONE);
                } else if (ll_start.getVisibility() == View.VISIBLE) {
                    ll_first.setVisibility(View.VISIBLE);
                    ll_content.setVisibility(View.GONE);
                    ll_start.setVisibility(View.GONE);
                } else {
                    startActivity(new Intent(SealedCenter.this, Main.class));
                    finish();
                }
            }
        });

        /** First Layout **/
        //교육매뉴얼
        btnEducation = (Button) findViewById(R.id.btn_education);
        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(View.GONE);
                ll_start.setVisibility(View.GONE);
                ll_content.setVisibility(View.VISIBLE);

                setPDF("sample.pdf");
            }
        });

        //장비
        btnGear = (Button) findViewById(R.id.btn_gear);
        btnGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(View.GONE);
                ll_start.setVisibility(View.GONE);
                ll_content.setVisibility(View.VISIBLE);

                setPDF("sample.pdf");
            }
        });

        //img_ready clicked
        imgReady = (ImageView) findViewById(R.id.img_check);
        imgReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_start.setVisibility(View.VISIBLE);
                ll_first.setVisibility(View.GONE);
                ll_content.setVisibility(View.GONE);
            }
        });


    }
    private void setPDF(String filename){
        pdfView.fromAsset(filename).load();
    }
}
