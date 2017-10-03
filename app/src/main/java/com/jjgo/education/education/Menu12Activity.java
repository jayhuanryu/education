package com.jjgo.education.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.barteksc.pdfviewer.PDFView;

import static android.view.View.GONE;

public class Menu12Activity extends AppCompatActivity {

    /** View Attributes **/
    private ImageView imgBack;
    private PDFView pdfView;
    private LinearLayout ll_content;
    private RelativeLayout rl_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu12);

        pdfView = (PDFView) findViewById(R.id.firstaid_pdf);
        ll_content = (LinearLayout)findViewById(R.id.ll_firstaid_content);
        rl_first = (RelativeLayout)findViewById(R.id.rl_firstaid_selection);

        imgBack = (ImageView)findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.btn_firstaid_education).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("menu12Education.pdf");
            }
        });

        findViewById(R.id.btn_firstaid_gear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("menu12Gear.pdf");
            }
        });


    }

    private void setPDF(String filelname) {
        rl_first.setVisibility(GONE);
        ll_content.setVisibility(View.VISIBLE);

        pdfView.fromAsset(filelname).load();

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Menu12Activity.this, Main.class));
        finish();
    }


}