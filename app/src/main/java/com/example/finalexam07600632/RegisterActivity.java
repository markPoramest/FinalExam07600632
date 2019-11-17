package com.example.finalexam07600632;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalexam07600632.DB.loginRepository;
import com.example.finalexam07600632.model.login;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText fullName_Text = findViewById(R.id.full_name_edit_text);
        final EditText userName_Text = findViewById(R.id.username_edit_text);
        final EditText password_Text = findViewById(R.id.password_edit_text);
        Button register = findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = fullName_Text.getText().toString();
                String username = userName_Text.getText().toString();
                String password = password_Text.getText().toString();
                if(fullName.equals("") || username.equals("") || password.equals(""))
                {
                    Toast.makeText(RegisterActivity.this,"All fields are required",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    login l1 = new login(0, fullName, username, password);
                    loginRepository log = new loginRepository(RegisterActivity.this);
                    log.InsertLogin(l1, new loginRepository.insertCallBack() {
                        @Override
                        public void onInsertCallBack() {
                            finish();
                        }
                    });
                    Toast.makeText(RegisterActivity.this,"All fields are required",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }

}
