package com.example.vaishnavi.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.vaishnavi.myapplication.R.string.tvInfo;

public class MainActivity extends AppCompatActivity {
    private EditText Name ;
    private EditText Password ;
    private TextView Info ;
    private TextView Fp;
    private Button Login ;
    private Button Back;
    private int counter = 4;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);
        counter = 4;

        Fp = (TextView)findViewById(R.id.tvForgot);
        Back = (Button)findViewById(R.id.btn2);
        //Info.setText(tvInfo);
        Fp.setText("Forgot Password");
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }

    private void validate(String Name, String Password) {
    Log.i("name",Name);
    Log.i("pwd",Password);
        if (Name.equals("abc") && Password.equals("9999")) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

        else {
            counter--;
            Info.setText("No of attempts remaining:" + String.valueOf(counter));
            if (counter == 0) {
                Login.setEnabled(false);
            }
        }
    }
}
