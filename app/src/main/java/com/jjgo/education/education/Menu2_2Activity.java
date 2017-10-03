package com.jjgo.education.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Menu2_2Activity extends AppCompatActivity {

    private RelativeLayout rl_ready;
    private RelativeLayout rl_start;
    private LinearLayout ll_stop;

    private ImageView imgBack;
    private ImageView img_ready;
    private ImageView img_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2_2);

        rl_ready = (RelativeLayout) findViewById(R.id.rl_helmet_ready);
        rl_start = (RelativeLayout) findViewById(R.id.rl_helmet_start);
        ll_stop = (LinearLayout)findViewById(R.id.ll_helmet_stop);

        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rl_start.getVisibility() == View.VISIBLE) {
                    rl_start.setVisibility(View.GONE);
                    rl_ready.setVisibility(View.VISIBLE);
                } else {
                    startActivity(new Intent(Menu2_2Activity.this, Menu2Activity.class));
                    finish();
                }
            }
        });

        ll_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Menu2_2Activity.this, "stop clicked ", Toast.LENGTH_LONG).show();
            }
        });

        img_ready = (ImageView) findViewById(R.id.img_helmet_ready);
        img_ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl_start.setVisibility(View.VISIBLE);
                rl_ready.setVisibility(View.GONE);
            }
        });

        img_start = (ImageView) findViewById(R.id.img_helmet_start);
        img_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
