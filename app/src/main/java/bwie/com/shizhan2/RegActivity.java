package bwie.com.shizhan2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataInput;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwie.com.shizhan2.presenter.RegPresenterClass;

public class RegActivity extends AppCompatActivity {
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.reg)
    Button reg;
    private String dian;
    private String pass;
    private RegPresenterClass regPresenterClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
        regPresenterClass = new RegPresenterClass(this);

    }

    @OnClick(R.id.reg)
    public void onViewClicked() {
        dian = phone.getText().toString();
        pass = pwd.getText().toString();
        if(dian.equals("") || pass.equals(""))
        {
            Toast.makeText(RegActivity.this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if(dian.length()<10 || dian.length() >12)
        {
            Toast.makeText(RegActivity.this,"手机号必须是11位",Toast.LENGTH_SHORT).show();
            return;
        }
        if(dian.length() ==11)
        {
            Toast.makeText(RegActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
            regPresenterClass.reg(dian,pass);
            Intent intent = new Intent(RegActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
