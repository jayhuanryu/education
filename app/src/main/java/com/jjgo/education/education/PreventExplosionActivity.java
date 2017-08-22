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

public class PreventExplosionActivity extends AppCompatActivity {

    private Button btnEducation;
    private Button btnGear;
    private ImageView imgBack;
    private ImageView imgReady;
    private ImageView imgStart;

    private LinearLayout ll_first;
    private LinearLayout ll_start;
    private LinearLayout ll_content;

    private LinearLayout ll_stop;

    private PDFView pdfView;
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevent_explosion);


        pdfView = (PDFView)findViewById(R.id.explode_pdf);
        ll_first = (LinearLayout)findViewById(R.id.ll_explode_first);
        ll_start = (LinearLayout)findViewById(R.id.ll_explode_start);
        ll_content = (LinearLayout)findViewById(R.id.ll_explode__content);
        tv_title = (TextView)findViewById(R.id.tv_explosion_title);
        btnEducation = (Button)findViewById(R.id.btn_explode_education);
        btnGear = (Button)findViewById(R.id.btn_explode_gear);
        ll_stop = (LinearLayout) findViewById(R.id.ll_explode_stop);
        imgBack = (ImageView)findViewById(R.id.img_back);
        imgReady = (ImageView) findViewById(R.id.img_explode_check);
        imgStart = (ImageView) findViewById(R.id.img_explode_start);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll_content.getVisibility() == View.VISIBLE) {
                    ll_start.setVisibility(View.VISIBLE);
                    ll_content.setVisibility(View.GONE);
                    ll_start.setVisibility(View.GONE);
                } else if(ll_start.getVisibility() == View.VISIBLE) {
                    ll_start.setVisibility(View.GONE);
                    ll_first.setVisibility(View.VISIBLE);
                    ll_content.setVisibility(View.GONE);
                } else {
                    startActivity(new Intent(PreventExplosionActivity.this, GasExplodeCenter.class));
                    finish();
                }
            }
        });

        imgReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_start.setVisibility(View.VISIBLE);
                ll_content.setVisibility(View.GONE);
                ll_first.setVisibility(View.GONE);

            }
        });

        imgStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PreventExplosionActivity.this, "Start Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ll_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PreventExplosionActivity.this, "Stop Clicked", Toast.LENGTH_SHORT).show();
                ll_first.setVisibility(View.VISIBLE);
                ll_content.setVisibility(View.GONE);
                ll_start.setVisibility(View.GONE);
            }
        });

        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_title.setText("교육 매뉴얼");
                setPDF("gasEducation.pdf");
            }
        });

        btnGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_title.setText("장비 매뉴얼");
                setPDF("gasGear.pdf");
            }
        });


    }

    private void setPDF(String filename){
        ll_content.setVisibility(View.VISIBLE);
        ll_start.setVisibility(View.GONE);
        ll_first.setVisibility(View.GONE);

        pdfView.fromAsset(filename).load();
    }
}
