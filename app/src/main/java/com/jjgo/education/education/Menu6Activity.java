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

public class Menu6Activity extends AppCompatActivity {

    private ImageView imgBack;
    private Button btnCulgol;
    private Button btnGoso;
    private PDFView pdfView;
    private TextView tv_title;

    private RelativeLayout rl_first;
    private LinearLayout ll_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu6);

        rl_first = (RelativeLayout) findViewById(R.id.rl_prevent_selection);
        ll_content = (LinearLayout)findViewById(R.id.ll_prevent_content);
        pdfView = (PDFView) findViewById(R.id.prevent_pdf);
        tv_title = (TextView) findViewById(R.id.tv_title);

        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll_content.getVisibility() == View.VISIBLE) {
                    rl_first.setVisibility(View.VISIBLE);
                    ll_content.setVisibility(View.GONE);
                } else {
                    startActivity(new Intent(Menu6Activity.this, Main.class));
                    finish();
                }
            }
        });

        btnGoso = (Button) findViewById(R.id.btn_prevent_goso);

        btnGoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPDF("menu6Education.pdf", getResources().getString(R.string.CPR_education));
            }
        });


    }

    private void setPDF(String filename, String text) {
        ll_content.setVisibility(View.VISIBLE);
        rl_first.setVisibility(View.GONE);
        tv_title.setText(text);
        pdfView.fromAsset(filename).load();
    }
}
