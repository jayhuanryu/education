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

public class ManageHeavyCenter extends AppCompatActivity {

    private LinearLayout ll_first;
    private LinearLayout ll_start;
    private LinearLayout ll_content;

    private LinearLayout ll_stop;

    private Button btnEquipmentEducation;
    private Button btnEquipmentGear;

    private ImageView imgBack;

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_heavy_center);

        pdfView = (PDFView) findViewById(R.id.equipment_pdf);

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
                    ll_content.setVisibility(View.GONE);
                    ll_start.setVisibility(View.GONE);
                } else if (ll_start.getVisibility() == View.VISIBLE) {
                    ll_first.setVisibility(View.VISIBLE);
                    ll_content.setVisibility(View.GONE);
                    ll_start.setVisibility(View.GONE);
                } else {
                    startActivity(new Intent(ManageHeavyCenter.this, Main.class));
                    finish();
                }
            }
        });

        ll_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(View.VISIBLE);
                ll_content.setVisibility(View.GONE);
                ll_start.setVisibility(View.GONE);

                Toast.makeText(ManageHeavyCenter.this, "Stop Clicked", Toast.LENGTH_SHORT);
            }
        });

        btnEquipmentEducation = (Button) findViewById(R.id.btn_equipment_education);
        btnEquipmentEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("heaequipmentEducation.pdf");
            }
        });
        btnEquipmentGear = (Button)findViewById(R.id.btn_equipment_gear);
        btnEquipmentGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("heavyequipmentGear.pdf");
            }
        });
    }

    private void setPDF(String filelname) {
        ll_first.setVisibility(View.GONE);
        ll_content.setVisibility(View.VISIBLE);
        ll_start.setVisibility(View.GONE);

        pdfView.fromAsset(filelname).load();

    }
}
