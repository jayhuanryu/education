package com.jjgo.education.education;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View Attributes
        final EditText et_pw1 = (EditText)findViewById(R.id.et_pw1);
        final EditText et_pw2 = (EditText)findViewById(R.id.et_pw2);
        final EditText et_pw3 = (EditText)findViewById(R.id.et_pw3);
        final EditText et_pw4 = (EditText)findViewById(R.id.et_pw4);

        et_pw4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String combined = et_pw1.getText().toString() + et_pw2.getText().toString() + et_pw3.getText().toString() + et_pw4.getText().toString();

                if (combined.equals(getResources().getString(R.string.p001_pw))) {
                    Intent intent = new Intent(MainActivity.this, Main.class);
                    startActivity(intent);
                }
            }
        });

    }
}
