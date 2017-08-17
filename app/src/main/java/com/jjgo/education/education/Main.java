package com.jjgo.education.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        /** Setting Button Attributes.. **/
        findViewById(R.id.btn_4d_center).setOnClickListener(this);
        findViewById(R.id.btn_sealed_center).setOnClickListener(this);
        findViewById(R.id.btn_safety_center).setOnClickListener(this);
        findViewById(R.id.btn_seatbelt_center).setOnClickListener(this);
        findViewById(R.id.btn_extinguisher_center).setOnClickListener(this);
        findViewById(R.id.btn_falls_center).setOnClickListener(this);
        findViewById(R.id.btn_prevent_falling_center).setOnClickListener(this);
        findViewById(R.id.btn_manage_heavy_center).setOnClickListener(this);
        findViewById(R.id.btn_rope_craking_center).setOnClickListener(this);
        findViewById(R.id.btn_gas_explode_center).setOnClickListener(this);
        findViewById(R.id.btn_electricity_center).setOnClickListener(this);
        findViewById(R.id.btn_CPR_center).setOnClickListener(this);
        findViewById(R.id.btn_alco_nico_center).setOnClickListener(this);
        findViewById(R.id.btn_heavy_lifting_center).setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btn_4d_center:
                startActivity(new Intent(this, FourDCenter.class));
                finish();
                break;
            case R.id.btn_sealed_center:
                startActivity(new Intent(this, SealedCenter.class));
                finish();
                break;
            case R.id.btn_safety_center:
                startActivity(new Intent(this, SafetyCenter.class));
                finish();
                break;
            case R.id.btn_seatbelt_center:
                startActivity(new Intent(this, SeatbeltCenter.class));
                finish();
                break;
            case R.id.btn_extinguisher_center:
                startActivity(new Intent(this, ExtinguisherCenter.class));
                finish();
                break;
            case R.id.btn_falls_center:
                startActivity(new Intent(this, FallsCenter.class));
                finish();
                break;
            case R.id.btn_prevent_falling_center:
                startActivity(new Intent(this, PreventFallCenter.class));
                finish();
                break;
            case R.id.btn_manage_heavy_center:
                startActivity(new Intent(this, ManageHeavyCenter.class));
                finish();
                break;
            case R.id.btn_rope_craking_center:
                startActivity(new Intent(this, RopeCrankingCenter.class));
                finish();
                break;
            case R.id.btn_gas_explode_center:
                startActivity(new Intent(this, GasExplodeCenter.class));
                finish();
                break;
            case R.id.btn_electricity_center:
                startActivity(new Intent(this, ElectricityCenter.class));
                finish();
                break;
            case R.id.btn_CPR_center:
                startActivity(new Intent(this, CPRCenter.class));
                finish();
                break;
            case R.id.btn_alco_nico_center:
                startActivity(new Intent(this, AlcoNicoCenter.class));
                finish();
                break;
            case R.id.btn_heavy_lifting_center:
                startActivity(new Intent(this, HeavyLiftingCenter.class));
                finish();
                break;

        }
    }
}
