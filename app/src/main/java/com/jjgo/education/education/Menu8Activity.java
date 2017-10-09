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

import static android.view.View.GONE;

public class Menu8Activity extends AppCompatActivity {

    private ImageView imgBack;
    private ImageView img_check;
    private ImageView imgUp;
    private ImageView imgDown;
    private Button btnEducation;
    private Button btnGear;
    private TextView tv_title;

    private LinearLayout ll_content;
    private LinearLayout ll_first;
    private LinearLayout ll_item;
    private RelativeLayout rl_move_content;
    private LinearLayout ll_stop;
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu8);

        pdfView = (PDFView)findViewById(R.id.crane_pdf);

        ll_first = (LinearLayout)findViewById(R.id.rl_crane_selection);
        ll_content = (LinearLayout) findViewById(R.id.ll_crane_content);
        rl_move_content = (RelativeLayout) findViewById(R.id.ll_moving_content);
        ll_item = (LinearLayout) findViewById(R.id.ll_crane_item);
        img_check = (ImageView)findViewById(R.id.img_falls_check);
        ll_stop = (LinearLayout)findViewById(R.id.ll_stop);
        imgUp = (ImageView)findViewById(R.id.img_up);
        imgDown = (ImageView)findViewById(R.id.img_down);

        imgUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        imgBack = (ImageView)findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });

        img_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_first.setVisibility(GONE);
                rl_move_content.setVisibility(View.VISIBLE);
                ll_content.setVisibility(GONE);
            }
        });

        tv_title = (TextView)findViewById(R.id.tv_crane_title);

        btnEducation = (Button) findViewById(R.id.btn_crane_education);
        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_title.setText(getResources().getString(R.string.CPR_education));
                setPDF("menu8Education.pdf");
            }
        });

//        btnGear = (Button) findViewById(R.id.btn_crane_gear);
//        btnGear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tv_title.setText("장비메뉴얼");
//                setPDF("menu8Gear.pdf");
//            }
//        });
    }

    private void setPDF(String filename) {
        ll_content.setVisibility(View.VISIBLE);
        ll_item.setVisibility(GONE);
        ll_first.setVisibility(GONE);

        pdfView.fromAsset(filename).load();

    }
    @Override
    public void onBackPressed() {
        if (ll_first.getVisibility() != View.VISIBLE) {
            ll_first.setVisibility(View.VISIBLE);
            ll_content.setVisibility(GONE);
            rl_move_content.setVisibility(GONE);
        } else {
            startActivity(new Intent(Menu8Activity.this, Main.class));
        }
    }
}
