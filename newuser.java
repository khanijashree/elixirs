package com.project.sandesh.encrypteraes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class newuser extends AppCompatActivity {

    EditText u,p,m,s;
    DatabaseHelper db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);

        db = new DatabaseHelper(this);

        u = (EditText)findViewById(R.id.editText2);
        p = (EditText)findViewById(R.id.editText3);
        m = (EditText)findViewById(R.id.editText4);
        s = (EditText)findViewById(R.id.editText5);

    }

    public void store(View v){

        RegisterData usr = new RegisterData();

        String u1 = u.getText().toString();
        String p1 = p.getText().toString();
        String m1 = m.getText().toString();
        String s1 = s.getText().toString();

        if(u1.isEmpty() || p1.isEmpty() || m1.isEmpty()|| s1.isEmpty())

        {
            String msg = db.addregister(usr);
            Toast.makeText(this," Please enter all details ",Toast.LENGTH_SHORT).show();
        }
        else {

            usr.setname(u1);
            usr.setPassword(p1);
            usr.setmob(m1);
            usr.setsec(s1);

            String msg = db.addregister(usr);

            Toast.makeText(this, " New user has been added", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, login.class);
            startActivity(i);
        }


    }

}
