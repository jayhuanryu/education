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

import static android.view.View.GONE;

public class Menu7Activity extends AppCompatActivity {

    private LinearLayout ll_first;
    private LinearLayout ll_start;
    private LinearLayout ll_content;

    private LinearLayout ll_stop;

    private Button btnEquipmentEducation;
    private Button btnEquipmentGear;

    private ImageView imgBack;

    private PDFView pdfView;
    private TextView pdfTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu7);

        pdfView = (PDFView) findViewById(R.id.equipment_pdf);
        pdfTitle = (TextView)findViewById(R.id.tv_title);

        ll_first = (LinearLayout) findViewById(R.id.ll_equipment_first);
        ll_start = (LinearLayout) findViewById(R.id.ll_equipment_start);
        ll_content = (LinearLayout) findViewById(R.id.ll_equipment_content);

        ll_stop = (LinearLayout) findViewById(R.id.ll_equipment_stop);

        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll_content.getVisibility() == View.VISIBLE) {
                    ll_first.setVisibility(View.VISIBLE);
                    ll_content.setVisibility(GONE);
                    ll_start.setVisibility(GONE);
                } else if (ll_start.getVisibility() == View.VISIBLE) {
                    ll_first.setVisibility(View.VISIBLE);
                    ll_content.setVisibility(GONE);
                    ll_start.setVisibility(GONE);
                } else {
                    startActivity(new Intent(Menu7Activity.this, Main.class));
                    finish();
                }
            }
        });

        ll_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(GONE);
                ll_start.setVisibility(View.VISIBLE);
            }
        });

        ll_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //협착시작
            }
        });

        ll_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(View.VISIBLE);
                ll_content.setVisibility(GONE);
                ll_start.setVisibility(GONE);

                Toast.makeText(Menu7Activity.this, "Stop Clicked", Toast.LENGTH_SHORT);
            }
        });

        btnEquipmentEducation = (Button) findViewById(R.id.btn_equipment_education);
        btnEquipmentEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("menu7Education.pdf");
            }
        });
//        btnEquipmentGear = (Button)findViewById(R.id.btn_equipment_gear);
//        btnEquipmentGear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setPDF("menu7Gear.pdf");
//            }
//        });
    }

    private void setPDF(String filelname) {
        ll_first.setVisibility(GONE);
        ll_content.setVisibility(View.VISIBLE);
        ll_start.setVisibility(GONE);

        if (filelname.contains("Gear"))
            pdfTitle.setText("장비메뉴얼");
        else
            pdfTitle.setText(getResources().getString(R.string.CPR_education));

        pdfView.fromAsset(filelname).load();

    }
}
