package com.jjgo.education.education;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.view.View.GONE;

public class CPRCenter extends AppCompatActivity {

    /** View Attributes **/
    private LinearLayout ll_first;
    private LinearLayout ll_educationManual;
    private LinearLayout ll_gearManual;

    private TextView tv_education;
    private TextView tv_gear;

    private Button btnEducation;
    private Button btnGear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cprcenter);

        ll_first = (LinearLayout)findViewById(R.id.ll_cpr_first);
        ll_educationManual = (LinearLayout)findViewById(R.id.ll_cpr_education);
        ll_gearManual = (LinearLayout)findViewById(R.id.ll_cpr_gear);

        tv_education = (TextView) findViewById(R.id.tv_education);
        tv_gear = (TextView) findViewById(R.id.tv_gear);

        findViewById(R.id.btn_educationManual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_educationManual.setVisibility(View.VISIBLE);
                ll_gearManual.setVisibility(GONE);
                ll_first.setVisibility(GONE);
            }
        });

        findViewById(R.id.btn_gearManual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_gearManual.setVisibility(View.VISIBLE);
                ll_educationManual.setVisibility(GONE);
                ll_first.setVisibility(GONE);
            }
        });

        String education = ReadFiles.readText(this, "CPReducation.txt");
        String gear = ReadFiles.readText(this,"CPRgear.text");

        tv_education.setText(education);
        tv_gear.setText(gear);
    }


}
