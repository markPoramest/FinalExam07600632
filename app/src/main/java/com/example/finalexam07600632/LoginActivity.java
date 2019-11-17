package com.example.finalexam07600632;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalexam07600632.DB.loginRepository;
import com.example.finalexam07600632.model.login;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextView username_text = findViewById(R.id.username_edit_text);
        final TextView password_text = findViewById(R.id.password_edit_text);
        loginRepository log = new loginRepository(LoginActivity.this);
        log.getLogin(new loginRepository.callBack() {
            @Override
            public void getloginCallBack(List<login> loginItemList) {
                Log.i("head","====All username List====");
                for (int i=0;i<loginItemList.size();i++)
                {
                    String user = loginItemList.get(i).username;
                    Log.i("username",user);
                }
            }
        });
        Button login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = username_text.getText().toString();
                final String password = password_text.getText().toString();
                if(username.equals("") || password.equals(""))
                {
                    Toast.makeText(LoginActivity.this,"All fields are required",
                            Toast.LENGTH_SHORT).show();

                }
                else
                {
                    loginRepository log = new loginRepository(LoginActivity.this);
                    log.getLogin(new loginRepository.callBack() {
                        @Override
                        public void getloginCallBack(List<login> loginItemList) {
                            int found=0;
                            for(int i=0;i<loginItemList.size();i++)
                            {
                                if (username.equals(loginItemList.get(i).username) && password.equals(loginItemList.get(i).password))
                                {
                                    Toast.makeText(LoginActivity.this,"Welcome "+loginItemList.get(i).fullName,
                                            Toast.LENGTH_SHORT).show();
                                    found++;
                                }
                            }
                            if(found==0)
                            {
                                Toast.makeText(LoginActivity.this,"Invalid username or password",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        Button register  = findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i1);
            }
        });
    }
}
