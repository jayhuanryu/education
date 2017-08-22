package com.jjgo.education.education;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class SeatbeltCenter extends AppCompatActivity {

    private LinearLayout ll_ready;
    private LinearLayout ll_start;
    private LinearLayout ll_content;
    private LinearLayout ll_stop;

    private ImageView imgBack;
    private ImageView imgReady;
    private ImageView imgUp;
    private ImageView imgDown;

    private Button btnEducation;
    private Button btnGear;

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seatbelt_center);

        pdfView = (PDFView)findViewById(R.id.pdf_seatbelt);

        ll_ready = (LinearLayout) findViewById(R.id.ll_seatbelt_first);
        ll_start = (LinearLayout) findViewById(R.id.ll_seatbelt_start);
        ll_content = (LinearLayout)findViewById(R.id.ll_seatbelt_content);

        ll_stop = (LinearLayout) findViewById(R.id.ll_seatbel_stop);
        ll_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SeatbeltCenter.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        imgBack = (ImageView)findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll_content.getVisibility() == View.VISIBLE) {
                    ll_ready.setVisibility(View.VISIBLE);
                    ll_start.setVisibility(View.GONE);
                    ll_content.setVisibility(View.GONE);
                } else if (ll_start.getVisibility() == View.VISIBLE) {
                    ll_ready.setVisibility(View.VISIBLE);
                    ll_start.setVisibility(View.GONE);
                    ll_content.setVisibility(View.GONE);
                } else {
                    startActivity(new Intent(SeatbeltCenter.this, Main.class));
                    finish();
                }
            }
        });

        btnEducation = (Button) findViewById(R.id.btn_seatbelt_education);
        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("seatbeltEducation.pdf");
            }
        });

        btnGear = (Button) findViewById(R.id.btn_seatbelt_gear);
        btnGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("seatbeltGear.pdf");
            }
        });

        imgReady = (ImageView) findViewById(R.id.img_seatbelt_check);
        imgReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_start.setVisibility(View.VISIBLE);
                ll_content.setVisibility(View.GONE);
                ll_ready.setVisibility(View.GONE);
            }
        });

        imgUp = (ImageView) findViewById(R.id.img_seatbelt_up);
        imgUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SeatbeltCenter.this, "Up clicked", Toast.LENGTH_SHORT).show();
            }
        });

        imgDown = (ImageView)findViewById(R.id.img_seatbelt_down);
        imgDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SeatbeltCenter.this, "Down Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        ll_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_ready.setVisibility(View.VISIBLE);
                ll_content.setVisibility(View.GONE);
                ll_start.setVisibility(View.GONE);
            }
        });
    }

    private void setPDF(String filename) {
        ll_content.setVisibility(View.VISIBLE);
        ll_start.setVisibility(View.GONE);
        ll_ready.setVisibility(View.GONE);

        pdfView.fromAsset(filename).load();
    }
}
