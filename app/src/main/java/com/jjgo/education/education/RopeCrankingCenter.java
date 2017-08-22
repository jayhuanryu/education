package com.jjgo.education.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class RopeCrankingCenter extends AppCompatActivity {

    private ImageView imgBack;
    private Button btnEducation;
    private Button btnGear;
    private TextView tv_title;

    private LinearLayout ll_content;
    private RelativeLayout rl_first;

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rope_cranking_center);

        pdfView = (PDFView)findViewById(R.id.crane_pdf);

        rl_first = (RelativeLayout)findViewById(R.id.rl_crane_selection);
        ll_content = (LinearLayout) findViewById(R.id.ll_crane_content);

        imgBack = (ImageView)findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll_content.getVisibility() == View.VISIBLE) {
                    rl_first.setVisibility(View.VISIBLE);
                    ll_content.setVisibility(View.GONE);
                } else {
                    startActivity(new Intent(RopeCrankingCenter.this, Main.class));
                }
            }
        });

        tv_title = (TextView)findViewById(R.id.tv_crane_title);

        btnEducation = (Button) findViewById(R.id.btn_crane_education);
        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_title.setText("교육 매뉴얼");
                setPDF("craneEducation.pdf");
            }
        });

        btnGear = (Button) findViewById(R.id.btn_crane_gear);
        btnGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_title.setText("장비 매뉴얼");
                setPDF("craneGear.pdf");
            }
        });
    }

    private void setPDF(String filename) {
        ll_content.setVisibility(View.VISIBLE);
        rl_first.setVisibility(View.GONE);

        pdfView.fromAsset(filename).load();

    }
}
