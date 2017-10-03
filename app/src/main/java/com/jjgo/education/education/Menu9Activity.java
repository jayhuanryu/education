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

import static android.view.View.GONE;

public class Menu9Activity extends AppCompatActivity {

    private LinearLayout ll_first;
    private LinearLayout ll_start;
    private LinearLayout ll_content;

    private LinearLayout ll_stop;

    private Button btnChemicalEducation;
    private Button btnChemicalGear;

    private ImageView imgBack;

    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu9);

        pdfView = (PDFView) findViewById(R.id.chemcial_pdf);

        ll_first = (LinearLayout) findViewById(R.id.ll_chemical_first);
        ll_start = (LinearLayout) findViewById(R.id.ll_chemical_start);
        ll_content = (LinearLayout) findViewById(R.id.ll_chemical_content);

        ll_stop = (LinearLayout) findViewById(R.id.ll_chemical_stop);

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
                    startActivity(new Intent(Menu9Activity.this, Main.class));
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

                Toast.makeText(Menu9Activity.this, "Stop Clicked", Toast.LENGTH_SHORT);
            }
        });

        btnChemicalEducation = (Button) findViewById(R.id.btn_chemical_education);
        btnChemicalEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("heaequipmentEducation.pdf");
            }
        });
        btnChemicalGear = (Button)findViewById(R.id.btn_chemical_gear);
        btnChemicalGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("heavyequipmentGear.pdf");
            }
        });
    }

    private void setPDF(String filelname) {
        ll_first.setVisibility(GONE);
        ll_content.setVisibility(View.VISIBLE);
        ll_start.setVisibility(GONE);

        pdfView.fromAsset(filelname).load();

    }
}
