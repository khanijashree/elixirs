package com.project.sandesh.encrypteraes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText e1, e2;
    DatabaseHelper db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1 = (EditText)findViewById(R.id.editText6);
        e2 = (EditText)findViewById(R.id.editText8);

    }

    public void show (String s){

        Toast.makeText(this, s , Toast.LENGTH_SHORT).show();
    }

    public void log(View v){
        String[] arr = new String[10];
        String usr = e1.getText().toString();
        String pwd = e2.getText().toString();

        db = new DatabaseHelper(this);

        arr = db.validate(usr);

        if ( usr.equals(arr[0]) && pwd.equals(arr[1])){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

        else
            show(" Please check the credentials ");

    }

    public void reg(View v){
        Intent i = new Intent(this, newuser.class);
        startActivity(i);
    }

}
