package com.example.assignment9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    Button btnLogin;
    TextView twRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        // huomioi singleton?

        etUsername = (EditText) findViewById(R.id.UsernameET);
        etPassword = (EditText) findViewById(R.id.PasswordET);
        btnLogin = (Button) findViewById(R.id.LoginBTN);
        twRegister = (TextView) findViewById(R.id.registerTW);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // jotenkin hienosti kysyy Query joka tarkistaa että onko olemassa tietty käyttäjä ja salasana
                // muuten sanoo että kokeile uudestaan

                openContentActivity();
            }
        });

        twRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
            }
        });


    }

    public void openRegisterActivity() {
        Intent nextScreen = new Intent(this, RegisterActivity.class);
        startActivity(nextScreen);
    }

    public void openContentActivity() {
        Intent nextScreen = new Intent(this, ContentActivity.class);
        startActivity(nextScreen);
    }
}