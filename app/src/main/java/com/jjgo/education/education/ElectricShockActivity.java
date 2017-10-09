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

public class ElectricShockActivity extends AppCompatActivity {

    private Button btnEducation;
    private Button btnGear;
    private LinearLayout ll_stop;
    private ImageView imgReady;
    private ImageView imgStart;

    private LinearLayout ll_first;
    private LinearLayout ll_content;
    private LinearLayout ll_start;

    private ImageView imgBack;

    private TextView tv_title;
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_shock);


        pdfView = (PDFView) findViewById(R.id.shock_pdf);
        tv_title = (TextView)findViewById(R.id.tv_shock_title);

        ll_first = (LinearLayout)findViewById(R.id.ll_shock_first);
        ll_start = (LinearLayout)findViewById(R.id.ll_shock_start);
        ll_content = (LinearLayout)findViewById(R.id.ll_shock_content);

        ll_stop = (LinearLayout)findViewById(R.id.ll_shock_stop);
        ll_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(View.VISIBLE);
                ll_content.setVisibility(View.GONE);
                ll_start.setVisibility(View.GONE);

                Toast.makeText(ElectricShockActivity.this, "Stop Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        imgBack = (ImageView)findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll_content.getVisibility() == View.VISIBLE) {
                    ll_first.setVisibility(View.VISIBLE);
                    ll_content.setVisibility(View.GONE);
                    ll_start.setVisibility(View.GONE);
                } else if (ll_start.getVisibility() == View.VISIBLE) {
                    ll_first.setVisibility(View.VISIBLE);
                    ll_content.setVisibility(View.GONE);
                    ll_start.setVisibility(View.GONE);
                } else {
                    startActivity(new Intent(ElectricShockActivity.this, Menu11Activity.class));
                }
            }
        });

        imgReady = (ImageView)findViewById(R.id.img_shock_check);
        imgReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_start.setVisibility(View.VISIBLE);
                ll_content.setVisibility(View.GONE);
                ll_first.setVisibility(View.GONE);
            }
        });

        imgStart = (ImageView)findViewById(R.id.img_shock_start);
        imgStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ElectricShockActivity.this, "Start Clikced", Toast.LENGTH_SHORT).show();
            }
        });

        btnEducation = (Button)findViewById(R.id.btn_shock_education);
        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_title.setText("교육 매뉴얼");
                setPDF("electricshockEducation.pdf");
            }
        });

        btnGear = (Button)findViewById(R.id.btn_shock_gear);
        btnGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_title.setText("장비 매뉴얼");
                setPDF("electricshockGear.pdf");
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
