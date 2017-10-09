package com.jjgo.education.education;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class UserSettingActivity extends AppCompatActivity implements View.OnClickListener{

    PrefUtil prefUtil;

    Button btnEdit;
    Button btnCancel;
    ImageView imgBack;

    EditText etOldPw;
    EditText etNewPw;
    EditText etPwCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        prefUtil = new PrefUtil(this);

        findViewById(R.id.img_back).setOnClickListener(this);

        btnEdit = (Button)findViewById(R.id.btn_setting_edit);
        btnCancel = (Button) findViewById(R.id.btn_setting_cancel);

        etOldPw = (EditText)findViewById(R.id.et_setting_oldpw);
        etNewPw = (EditText)findViewById(R.id.et_setting_newpw);
        etPwCheck = (EditText)findViewById(R.id.et_setting_pwcheck);

        btnEdit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_setting_edit:
                boolean pwcheck = false;
                boolean pwmatch = false;
                Log.d("prefUtil password : " , prefUtil.getPassword().toString());
                if(etOldPw.getText().toString().equals(prefUtil.getPassword()))
                    pwcheck = true;
                if(etNewPw.getText().toString().equals(etPwCheck.getText().toString()))
                    pwmatch = true;

                Log.d("old pw : " , etOldPw.getText().toString());
                Log.d("new pw : " , etNewPw.getText().toString());
                Log.d("check pw : " , etPwCheck.getText().toString());

                if(pwcheck && pwmatch) {
                    prefUtil.setPassword(etNewPw.getText().toString());
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("알림");
                    builder.setMessage("비밀번호가 변경되었습니다.");
                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    builder.create().show();
                } else if (pwcheck) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("알림");
                    builder.setMessage("비밀번호가 틀렸습니다. \n 다시 입력해주세요");
                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            etNewPw.setText("");
                            etOldPw.setText("");
                            etPwCheck.setText("");
                            etOldPw.requestFocus();
                        }
                    });
                    builder.create().show();
                } else if (pwmatch) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("알림");
                    builder.setMessage("새로운 비밀번호가 일치하지 않습니다. \n 다시 입력해주세요");
                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            etNewPw.setText("");
                            etOldPw.setText("");
                            etPwCheck.setText("");
                            etOldPw.requestFocus();
                        }
                    });
                }
                break;
            case R.id.btn_setting_cancel:
                finish();
            case R.id.img_back:
                finish();
                break;
        }
    }
}
