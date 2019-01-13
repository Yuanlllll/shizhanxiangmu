package bwie.com.shizhan2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwie.com.shizhan2.api.Api;
import bwie.com.shizhan2.presenter.LoginPresenterClass;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.jizhu)
    CheckBox jizhu;
    @BindView(R.id.reg)
    TextView reg;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;
    private String dian;
    private String pass;
    private SharedPreferences sp;
    private ObjectAnimator scaleX;
    private AnimatorSet animatorSet;
    Intent intent1;
    private LoginPresenterClass loginPresenterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        boolean b = sp.getBoolean("记住", false);
        if (b) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
        loginPresenterClass = new LoginPresenterClass(this);

    }

    @OnClick({R.id.reg, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reg:
                Intent intent = new Intent(MainActivity.this, RegActivity.class);
                startActivity(intent);
                break;
            case R.id.login:
                dian = phone.getText().toString();
                pass = pwd.getText().toString();
                loginPresenterClass.loginPresenter(dian,pass);
                if (dian.equals("") || pass.equals("")) {
                    Toast.makeText(MainActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (dian.length() < 10 || dian.length() > 12) {
                    Toast.makeText(MainActivity.this, "手机号必须是11位", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (dian.length() == 11) {
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Editor edit = sp.edit();
                    edit.putBoolean("记住", jizhu.isChecked());
                    edit.commit();
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(login, "translationY",login.getTranslationY(), 300);
                    ObjectAnimator objectAnimator1= ObjectAnimator.ofFloat(login,"rotation",0,360);
                    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(login,"alpha",0,1,0,1);
                    ObjectAnimator ObjectAnimator3 = ObjectAnimator.ofFloat(login, "scaleX", 0, 1);
                    animatorSet = new AnimatorSet();
                    animatorSet.play(objectAnimator).with(objectAnimator1).with(objectAnimator2).with(ObjectAnimator3);
                    animatorSet.setDuration(5000);
                    animatorSet.start();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            intent1 = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent1);
                        }
                    },5000);
                }
                break;
        }
    }
}
