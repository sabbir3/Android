package com.example.mylogindrmo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//public class SignUpActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//    }
//}
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText,emailEditText,userNameEditText,passwordEditText;
    private Button signUpButton;
    DatabaseHelper databaseHelper;
    UserDetails userDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        databaseHelper=new DatabaseHelper(this);
        userDetails = new UserDetails();

        nameEditText=findViewById(R.id.textNameId);
        emailEditText=findViewById(R.id.emailId);
        userNameEditText=findViewById(R.id.usernameId);
        passwordEditText=findViewById(R.id.passwordID);

        signUpButton=findViewById(R.id.signUpButtonId);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String username = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
            userDetails.setName(name);
            userDetails.setEmail(email);
            userDetails.setUsername(username);
            userDetails.setPassword(password);
            long rowId = databaseHelper.insertData(userDetails);

            if (rowId > 0) {
                Toast.makeText(getApplicationContext(), "row " + rowId + " is successfully inserted", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(getApplicationContext(), "failed to insert", Toast.LENGTH_LONG).show();

            }
    }
}