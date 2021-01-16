package com.example.mylogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText usernmeText,passwordText;
    private Button loginButton;
    private TextView textView;
    private int counter=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernmeText = findViewById(R.id.usernameId);
        passwordText = findViewById(R.id.passwordId);
        loginButton = findViewById(R.id.loginButtonId);
        textView = findViewById(R.id.textViewId);
        textView.setText("Number of attemps remaining: 3");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernmeText.getText().toString();
                String password =passwordText.getText().toString();

                if(username.equals("admin") && password.equals("123"))
                {
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                }else {

                    counter--;
                    textView.setText("Number of attemps remaining "+counter);
                    if(counter==0){
                        loginButton.setEnabled(false);
                    }
                }
            }
        });


    }
}