package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etUsername = findViewById(R.id.et_username);
        EditText etStdid = findViewById(R.id.et_stdid);
        EditText etEmail = findViewById(R.id.et_email);
        EditText etMobile = findViewById(R.id.et_mobile);
        EditText etPassword = findViewById(R.id.et_password);
        EditText etcPass = findViewById(R.id.et_confirm_password);
        Button register= findViewById(R.id.btn_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String stdId = etStdid.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString();
                String confirmPassword = etcPass.getText().toString();
                String mobile = etMobile.getText().toString();

                Pattern phonePattern = Pattern.compile("^(\\+88)?01[2-9][0-9]{8}$");
                Pattern emailPattern = Pattern.compile("^cse_[0-9]{16}@lus\\.ac\\.bd$");
                Pattern stdIdPattern = Pattern.compile("018[0-9]{13}$");
                Pattern usernamePattern = Pattern.compile("^[A-Za-z]+( [A-Za-z]+)*$");
                Pattern passPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d).{8,}$");

                if (username.isEmpty() || stdId.isEmpty() || email.isEmpty() || mobile.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!phonePattern.matcher(mobile).matches()) {
                    Toast.makeText(MainActivity.this, "Invalid phone number", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!emailPattern.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Invalid email", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!stdIdPattern.matcher(stdId).matches()) {
                    Toast.makeText(MainActivity.this, "Invalid student ID", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!usernamePattern.matcher(username).matches()) {
                    Toast.makeText(MainActivity.this, "Invalid Username", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!passPattern.matcher(password).matches()) {
                    Toast.makeText(MainActivity.this, "Password must be at least 8 characters and include letters and numbers", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(MainActivity.this, "Successfully sign up ", Toast.LENGTH_SHORT).show();


                }

            }
        });
    }
}