package com.example.mylogindrmo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userNameEditText,passwordEditText;
    private Button signupButton,signinButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper=new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        userNameEditText=findViewById(R.id.usernameId);
        passwordEditText=findViewById(R.id.passwordID);

        signinButton=findViewById(R.id.signInbuttonId);
        signupButton=findViewById(R.id.signUpHerebuttonId);

        signinButton.setOnClickListener(this);
        signupButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String username = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(v.getId()==R.id.signInbuttonId){

            Boolean result = databaseHelper.findPassword(username,password);
            if(result==true){
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(),"username password didn't match",Toast.LENGTH_LONG).show();
            }
        }
        if(v.getId()==R.id.signUpHerebuttonId){

            Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        }
    }
}