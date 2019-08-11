package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpAndLogInActivity extends AppCompatActivity {
    private EditText signupName,signupPassword,loginName,loginPassword;
    private Button btnSign,btnLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_and_log_in);
        signupName=findViewById(R.id.edtSignUpUsername);
        signupPassword=findViewById(R.id.edtSignUpPass);
        loginName=findViewById(R.id.edtLoginUsername);
        loginPassword=findViewById(R.id.edtLoginPass);
        btnLog=findViewById(R.id.btnLogIn);
        btnSign=findViewById(R.id.btnSignUp);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ParseUser appUser=new ParseUser();
                appUser.setUsername(signupName.getText().toString());
                appUser.setPassword(signupPassword.getText().toString());

                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            Toast.makeText(SignUpAndLogInActivity.this, appUser.get("name") + " sign up successful", Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(SignUpAndLogInActivity.this,WelcomeActivity.class);
                            startActivity(intent);

                        }else {
                            Toast.makeText(SignUpAndLogInActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logInInBackground(loginName.getText().toString(), loginPassword.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user!=null && e==null){
                            Toast.makeText(SignUpAndLogInActivity.this, user.get("name") + " login successful", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(SignUpAndLogInActivity.this,WelcomeActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SignUpAndLogInActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
