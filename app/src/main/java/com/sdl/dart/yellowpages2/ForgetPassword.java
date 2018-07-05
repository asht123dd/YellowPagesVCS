package com.sdl.dart.yellowpages2;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgetPassword extends AppCompatActivity implements DeleteUserPrompt.DeleteUserPromptListener{
    DatabaseHandler db;
    Button next;
    user u = new user();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        db = new DatabaseHandler(this);
        next=(Button)findViewById(R.id.Next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText8);
                u.setU_name(editText.getText().toString());
                db.deleteUser(u);
                DeleteUserPrompt dialog = new DeleteUserPrompt();
                dialog.show(getFragmentManager(), "prompt");
            }
        });
    }
    @Override
    public void onHomeClick(DialogFragment dialog) {
        Intent intent=new Intent(ForgetPassword.this,MainActivity.class);
        startActivity(intent);
    }
}
