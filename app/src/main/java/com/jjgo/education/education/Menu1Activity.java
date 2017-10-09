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

public class Menu1Activity extends AppCompatActivity {

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
    private TextView pdfTitle;
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        //Setting Layouts
        ll_first = (LinearLayout) findViewById(R.id.ll_sealed_first);
        ll_start = (LinearLayout) findViewById(R.id.ll_sealed_start);
        ll_content = (LinearLayout) findViewById(R.id.ll_sealed_content);

        ll_stop = (LinearLayout)findViewById(R.id.ll_sealed_stop);

        //PDF content
        pdfView = (PDFView) findViewById(R.id.pdf_sealed);
        pdfTitle = (TextView) findViewById(R.id.tv_pdf_title);



        //돌아가기 버튼
        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           onBackPressed();
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

                setPDF("menu1Education.pdf");
            }
        });

        //장비
//        btnGear = (Button) findViewById(R.id.btn_gear);
//        btnGear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ll_first.setVisibility(View.GONE);
//                ll_start.setVisibility(View.GONE);
//                ll_content.setVisibility(View.VISIBLE);
//
//                setPDF("menu1Gear.pdf");
//            }
//        });

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


        ll_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(View.VISIBLE);
                ll_content.setVisibility(View.GONE);
                ll_start.setVisibility(View.GONE);
            }
        });

        imgStart = (ImageView)findViewById(R.id.img_start);
        imgStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Menu1Activity.this, "Start Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void setPDF(String filename){
        if (filename.contains("Education"))
            pdfTitle.setText(getResources().getString(R.string.CPR_education));
        else
            pdfTitle.setText("장비매뉴얼");

        pdfView.fromAsset(filename).load();
    }

    @Override
    public void onBackPressed() {
        if(ll_content.getVisibility() == View.VISIBLE) {
            ll_first.setVisibility(View.VISIBLE);
            ll_content.setVisibility(View.GONE);
            ll_start.setVisibility(View.GONE);
        } else if (ll_start.getVisibility() == View.VISIBLE) {
            ll_first.setVisibility(View.VISIBLE);
            ll_content.setVisibility(View.GONE);
            ll_start.setVisibility(View.GONE);
        } else {
            startActivity(new Intent(Menu1Activity.this, Main.class));
            finish();
        }
    }
}
