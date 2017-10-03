package com.jjgo.education.education;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        /** Setting Button Attributes.. **/
        findViewById(R.id.btn_menu1).setOnClickListener(this);
        findViewById(R.id.btn_menu2).setOnClickListener(this);
        findViewById(R.id.btn_menu3).setOnClickListener(this);
        findViewById(R.id.btn_menu4).setOnClickListener(this);
        findViewById(R.id.btn_menu5).setOnClickListener(this);
        findViewById(R.id.btn_menu6).setOnClickListener(this);
        findViewById(R.id.btn_menu7).setOnClickListener(this);
        findViewById(R.id.btn_menu8).setOnClickListener(this);
        findViewById(R.id.btn_menu9).setOnClickListener(this);
        findViewById(R.id.btn_menu10).setOnClickListener(this);
        findViewById(R.id.btn_menu11).setOnClickListener(this);
        findViewById(R.id.btn_menu12).setOnClickListener(this);
        findViewById(R.id.btn_menu13).setOnClickListener(this);
        findViewById(R.id.btn_back).setOnClickListener(this);


    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btn_back:
                startActivity(new Intent(this, UserSettingActivity.class));
                break;
            case R.id.btn_menu1:
                startActivity(new Intent(this, Menu1Activity.class));
                finish();
                break;
            case R.id.btn_menu2:
                startActivity(new Intent(this, Menu2Activity.class));
                finish();
                break;
            case R.id.btn_menu3:
                startActivity(new Intent(this, Menu3Activity.class));
                finish();
                break;
            case R.id.btn_menu4:
                startActivity(new Intent(this, Menu4Activity.class));
                finish();
                break;
            case R.id.btn_menu5:
                startActivity(new Intent(this, Menu5Activity.class));
                finish();
                break;
            case R.id.btn_menu6:
                startActivity(new Intent(this, Menu6Activity.class));
                finish();
                break;
            case R.id.btn_menu7:
                startActivity(new Intent(this, Menu7Activity.class));
                finish();
                break;
            case R.id.btn_menu8:
                startActivity(new Intent(this, Menu8Activity.class));
                finish();
                break;
            case R.id.btn_menu9:
                startActivity(new Intent(this, Menu9Activity.class));
                finish();
                break;
            case R.id.btn_menu10:
                startActivity(new Intent(this, Menu10Activity.class));
                finish();
                break;
            case R.id.btn_menu11:
                startActivity(new Intent(this, Menu11Activity.class));
                finish();
                break;
            case R.id.btn_menu12:
                startActivity(new Intent(this, Menu12Activity.class));
                finish();
                break;
            case R.id.btn_menu13:
                startActivity(new Intent(this, Menu13Activity.class));
                finish();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림");
        builder.setMessage("앱을 종료하시겠습니까?");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.create().show();
    }
}
