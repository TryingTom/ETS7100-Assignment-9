package com.example.assignment9;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    EditText etNewUser;
    EditText etNewPass;
    Button btnReturn;
    Button btnAdd;

    LogRepository LogR;
    RoomEntity entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        etNewUser = (EditText) findViewById(R.id.newUserET);
        etNewPass = (EditText) findViewById(R.id.newPassET);

        btnReturn = (Button) findViewById(R.id.RreturnBTN);
        btnAdd = (Button) findViewById(R.id.addUserBTN);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if (!checkIfUser)
                final Calendar calendar = Calendar.getInstance();
                String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format((calendar.getTime()));

                entity = new RoomEntity(etNewPass.getText().toString(),etNewPass.getText().toString(), currentDate);
                // I guess this doesn't work either
                // Hyvinhän tämä menee :)
                LogR.insert(entity);

                finish();

                // else toast that the user is already stolen ;)
            }
        });
    }
}