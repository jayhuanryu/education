package com.jjgo.education.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class AlcoNicoCenter extends AppCompatActivity {

    private ImageView imgBack;
    private Button btnEducation;
    private Button btnGear;

    private LinearLayout ll_first;
    private LinearLayout ll_content;

    private TextView tv_title;
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alco_nico_center);

        pdfView = (PDFView)findViewById(R.id.alco_pdf);
        tv_title = (TextView)findViewById(R.id.tv_alco_title);

        ll_first = (LinearLayout)findViewById(R.id.ll_alco_first);
        ll_content = (LinearLayout)findViewById(R.id.ll_alco_content);

        imgBack = (ImageView)findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll_content.getVisibility() ==VISIBLE) {
                    ll_first.setVisibility(VISIBLE);
                    ll_content.setVisibility(GONE);
                } else {
                    startActivity(new Intent(AlcoNicoCenter.this, Main.class));
                    finish();
                }
            }
        });

        btnEducation = (Button)findViewById(R.id.btn_alco_education);
        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_title.setText("교육 매뉴얼");
                setPDF("alcoEducation.pdf");
            }
        });

        btnGear = (Button)findViewById(R.id.btn_alco_gear);
        btnGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_title.setText("장비 매뉴얼");
                setPDF("alcoGear.pdf");
            }
        });
    }
    private void setPDF(String filename) {
        ll_content.setVisibility(VISIBLE);
        ll_first.setVisibility(GONE);

        pdfView.fromAsset(filename).load();
    }
}
