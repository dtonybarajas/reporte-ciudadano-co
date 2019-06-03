package co.barajas.reporteciudadanoco.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.login.widget.LoginButton;

import co.barajas.reporteciudadanoco.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

    LoginButton login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_button = (LoginButton) findViewById(R.id.login_button);
        login_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                Intent in = new Intent(this, MainActivity.class);
                startActivity(in);
                finish();
                break;
        }
    }
}
