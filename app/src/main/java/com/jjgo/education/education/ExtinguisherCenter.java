package com.jjgo.education.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class ExtinguisherCenter extends AppCompatActivity {

    private PDFView pdfView;

    private LinearLayout ll_first;
    private LinearLayout ll_start;
    private LinearLayout ll_content;

    private LinearLayout ll_stop;

    private Button btnEducation;
    private Button btnGear;

    private ImageView imgReady;
    private ImageView imgStart;
    private ImageView imgBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extinguisher_center);

        ll_first = (LinearLayout) findViewById(R.id.ll_extinguisher_first);
        ll_start = (LinearLayout) findViewById(R.id.ll_extinguisher_start);
        ll_content = (LinearLayout) findViewById(R.id.ll_extinguisher__content);

        ll_stop = (LinearLayout) findViewById(R.id.ll_extinguisher_stop);
        ll_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExtinguisherCenter.this, "stop clicked", Toast.LENGTH_SHORT).show();
            }
        });

        pdfView = (PDFView) findViewById(R.id.extinguisher_pdf);

        imgBack = (ImageView)findViewById(R.id.img_back);
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
                    startActivity(new Intent(ExtinguisherCenter.this, Main.class));
                    finish();
                }
            }
        });

        imgReady =(ImageView)findViewById(R.id.img_extinguisher_check);
        imgReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(View.GONE);
                ll_start.setVisibility(View.VISIBLE);
                ll_content.setVisibility(View.GONE);
            }
        });
        imgStart = (ImageView)findViewById(R.id.img_extinguisher_start);
        imgStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExtinguisherCenter.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnEducation = (Button)findViewById(R.id.btn_extinguisher_education);
        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("extinguisherEducation.pdf");
            }
        });

        btnGear = (Button)findViewById(R.id.btn_extinguisher_gear);
        btnGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("extinguisherGear.pdf");
            }
        });
    }

    private void setPDF(String filename) {
        ll_content.setVisibility(View.VISIBLE);
        ll_first.setVisibility(View.GONE);
        ll_start.setVisibility(View.GONE);

        pdfView.fromAsset(filename).load();
    }
}
