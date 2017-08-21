package com.jjgo.education.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SafetyShoeActivity extends AppCompatActivity {

    private RelativeLayout rl_start;
    private RelativeLayout rl_awl;
    private RelativeLayout rl_hammer;

    private LinearLayout ll_stop;

    private ImageView imgBack;
    private ImageView imgReady;
    private ImageView imgawl;
    private ImageView imgHammer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_shoe);

        ll_stop = (LinearLayout) findViewById(R.id.ll_shoes_stop);
        ll_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SafetyShoeActivity.this, "stop clicked", Toast.LENGTH_SHORT).show();
            }
        });

        rl_start = (RelativeLayout)findViewById(R.id.rl_shoes_ready);
        rl_awl = (RelativeLayout) findViewById(R.id.rl_shoes_awl);
        rl_hammer = (RelativeLayout)findViewById(R.id.rl_shoes_hammer);

        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rl_hammer.getVisibility() == View.VISIBLE) {
                    rl_awl.setVisibility(View.VISIBLE);
                    rl_start.setVisibility(View.GONE);
                    rl_hammer.setVisibility(View.GONE);
                } else if (rl_awl.getVisibility() == View.VISIBLE) {
                    rl_awl.setVisibility(View.GONE);
                    rl_hammer.setVisibility(View.GONE);
                    rl_start.setVisibility(View.VISIBLE);
                } else {
                    startActivity(new Intent(SafetyShoeActivity.this, SafetyCenter.class));
                    finish();
                }
            }
        });

        imgReady = (ImageView) findViewById(R.id.img_shoes_ready);
        imgReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl_awl.setVisibility(View.VISIBLE);
                rl_start.setVisibility(View.GONE);
                rl_hammer.setVisibility(View.GONE);
            }
        });

        imgawl = (ImageView) findViewById(R.id.img_shoes_awl);
        imgawl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl_awl.setVisibility(View.GONE);
                rl_hammer.setVisibility(View.VISIBLE);
                rl_start.setVisibility(View.GONE);
            }
        });

        imgHammer = (ImageView)findViewById(R.id.img_shoes_hammer);
        imgHammer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SafetyShoeActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
