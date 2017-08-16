package com.jjgo.education.education;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String pw = getResources().getString(R.string.p001_pw);

        //View Attributes
        EditText et_pw1 = (EditText)findViewById(R.id.et_pw1);
        EditText et_pw2 = (EditText)findViewById(R.id.et_pw2);
        EditText et_pw3 = (EditText)findViewById(R.id.et_pw3);
        EditText et_pw4 = (EditText)findViewById(R.id.et_pw4);

    }
}
