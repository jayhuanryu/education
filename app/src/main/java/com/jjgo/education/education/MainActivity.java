package com.jjgo.education.education;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private PrefUtil prefUtil;
    String password = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefUtil = new PrefUtil(this);

        if(prefUtil.getPassword() == null) {
            password = getResources().getString(R.string.p001_pw);
            prefUtil.setPassword(password);
        }
        else
            password = prefUtil.getPassword();

        //View Attributes
        final EditText et_pw1 = (EditText)findViewById(R.id.et_pw1);
        final EditText et_pw2 = (EditText)findViewById(R.id.et_pw2);
        final EditText et_pw3 = (EditText)findViewById(R.id.et_pw3);
        final EditText et_pw4 = (EditText)findViewById(R.id.et_pw4);

        final String[] passwordarray = {"0","0","0","0"};

        et_pw1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et_pw1.getText().length() > 0 ) {
                    et_pw2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                passwordarray[0] = String.valueOf(s);
                for (int i = 0 ; i < passwordarray.length; i++) {
                    Log.d("JAY", "password array " + i + " : " + passwordarray[i]);
                }
            }
        });

        et_pw2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et_pw2.getText().length() > 0)
                    et_pw3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {
                passwordarray[1] = String.valueOf(s);
                for (int i = 0 ; i < passwordarray.length; i++) {
                    Log.d("JAY", "password array " + i + " : " + passwordarray[i]);
                }
            }
        });

        et_pw3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et_pw3.getText().length() > 0)
                    et_pw4.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {
                passwordarray[2] = String.valueOf(s);
                for (int i = 0 ; i < passwordarray.length; i++) {
                    Log.d("JAY", "password array " + i + " : " + passwordarray[i]);
                }
            }
        });

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
                Log.d("input password", combined);
                Log.d("saved password", password);

                if (combined.equals(password)) {
                    Intent intent = new Intent(MainActivity.this, Main.class);
                    startActivity(intent);
                    finish();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("알림");
                    builder.setMessage("비밀번호가 틀렸습니다. 재입력 하시겠습니까?");
                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            et_pw1.setText("");
                            et_pw2.setText("");
                            et_pw3.setText("");
                            et_pw4.setText("");
                            et_pw1.requestFocus();
                        }
                    });
                }
            }
        });

    }
}
