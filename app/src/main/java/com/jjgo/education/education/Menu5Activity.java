package com.jjgo.education.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class Menu5Activity extends AppCompatActivity {

    private PDFView pdfView;
    private TextView pdfTitle;

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
        setContentView(R.layout.activity_menu5);

        ll_first = (LinearLayout) findViewById(R.id.ll_falls_first);
        ll_start = (LinearLayout) findViewById(R.id.ll_falls_start);
        ll_content = (LinearLayout) findViewById(R.id.ll_falls_content);

        ll_stop = (LinearLayout) findViewById(R.id.ll_falls_stop);
        ll_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Menu5Activity.this, "stop clicked", Toast.LENGTH_SHORT).show();
            }
        });

        pdfView = (PDFView) findViewById(R.id.falls_pdf);
        pdfTitle = (TextView) findViewById(R.id.tv_pdf_title);

        imgBack = (ImageView)findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });

        imgReady =(ImageView)findViewById(R.id.img_falls_check);
        imgReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(View.GONE);
                ll_start.setVisibility(View.VISIBLE);
                ll_content.setVisibility(View.GONE);
            }
        });
        imgStart = (ImageView)findViewById(R.id.img_falls_start);
        imgStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Menu5Activity.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnEducation = (Button)findViewById(R.id.btn_falls_education);
        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("menu5Education.pdf");
            }
        });

//        btnGear = (Button)findViewById(R.id.btn_falls_gear);
//        btnGear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setPDF("menu5Gear.pdf");
//            }
//        });


        ll_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(View.VISIBLE);
                ll_content.setVisibility(View.GONE);
                ll_start.setVisibility(View.GONE);
            }
        });
    }

    private void setPDF(String filename) {
        ll_content.setVisibility(View.VISIBLE);
        ll_first.setVisibility(View.GONE);
        ll_start.setVisibility(View.GONE);

        if (filename.contains("Gear"))
            pdfTitle.setText("장비매뉴얼");
        else
            pdfTitle.setText(getResources().getString(R.string.CPR_education));

        pdfView.fromAsset(filename).load();
    }

    @Override
    public void onBackPressed(){
        if(ll_content.getVisibility() == View.VISIBLE) {
            ll_first.setVisibility(View.VISIBLE);
            ll_content.setVisibility(View.GONE);
            ll_start.setVisibility(View.GONE);
        } else if (ll_start.getVisibility() == View.VISIBLE) {
            ll_first.setVisibility(View.VISIBLE);
            ll_content.setVisibility(View.GONE);
            ll_start.setVisibility(View.GONE);
        } else {
            startActivity(new Intent(Menu5Activity.this, Main.class));
            finish();
        }
    }
}
