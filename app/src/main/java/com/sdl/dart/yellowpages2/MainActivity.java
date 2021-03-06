package com.sdl.dart.yellowpages2;

import android.app.DialogFragment;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ArrowKeyMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity implements AddUserDialog.AddUserDialogListener {
    public static final String CHECK = "com.sdl.dart.yellowpages2.DatabaseHandler";
    Button btnAddUser, btnLogin, btnfgp, btnDet;
    DatabaseHandler db;
    int master = 0;
    private String TAG = "UserInfo";
    user u = new user();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHandler(this);

        btnAddUser = (Button) findViewById(R.id.button6);
        btnLogin = (Button) findViewById(R.id.button4);
        btnfgp = (Button) findViewById(R.id.button5);
        //btnDet = (Button) findViewById(R.id.button9);
        //btnDeleteInfo = (Button) findViewById(R.id.btnDeleteInfo);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddUserDialog dialog = new AddUserDialog();
                dialog.show(getFragmentManager(), TAG);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Choice.class);
                Intent intent2 = new Intent(v.getContext(), Display.class);
                EditText editText = (EditText) findViewById(R.id.editText3);
                EditText editText2 = (EditText) findViewById(R.id.editText4);
                if (editText.getText().toString().equals("master") && editText2.getText().toString().equals("bestproject")) {
                    master = 1;
                    startActivity(intent2);


                }
                u.setU_name(editText.getText().toString());
                u.setPass(editText2.getText().toString());
                if (db.searchUser(u)) {
                    //intent.putExtra(message,message2);
                    MyApplication.setSomeVariable(u.getU_name());
                    startActivity(intent);
                } else if (master == 0) {
                    Toast.makeText(MainActivity.this, "Invalid Credentials!",
                            Toast.LENGTH_LONG).show();
                }


            }
        });
        btnfgp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ForgetPassword.class);
                startActivity(intent);
            }
        });
       /* btnDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //View Block Number List in the Text View Widget
                tvUsrInfo = (TextView) findViewById(R.id.textView4);

                tvUsrInfo.setMovementMethod(ArrowKeyMovementMethod.getInstance());

                tvUsrInfo.setText("");	//	clear text area at each button press
                //tvStdInfo.setTextColor(Color.MAGENTA);
                tvUsrInfo.setPadding(5, 2, 5, 2);

                List<user> usersList = db.getAllUsersList();	//	fetch List of BlockedNumbers form DB  method - 'getAllBlockedNumbers'

                for (user usr: usersList) {

                    String stdDetail = "\n\tNAME:" + usr.getU_name() + "\n\tPassword:"+ usr.getPass();
                    tvUsrInfo.append("\n"+ stdDetail);

                    //	Log.i("TAG", log);
                }
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /* public void login(View view) {
         Intent intent = new Intent(this, DatabaseHandler.class);
         EditText editText = (EditText) findViewById(R.id.editText);
         String message = editText.getText().toString();
         intent.putExtra(CHECK, message);
         EditText pass = (EditText) findViewById(R.id.editText);
         String message2 = pass.getText().toString();
         intent.putExtra(CHECK, message2);
         startActivity(intent);


     }*/
    @Override
    public void onCancelButtonClick(DialogFragment dialog){

    }
    @Override
    public void onSaveButtonClick(DialogFragment dialog) {


//		Get Name
        EditText entName =  dialog.getDialog().findViewById(R.id.editText5);
        String name = entName.getText().toString();

        //		Get Phone Number
        EditText entPass =  dialog.getDialog().findViewById(R.id.editText6);
        String pass = entPass.getText().toString();
        EditText confPass =  dialog.getDialog().findViewById(R.id.editText7);
        String confpass = confPass.getText().toString();


        // boolean check_enrollNo = checkEnrollNo(enrollNo);

        boolean check_name = checkName(name);

        boolean check_password = checkPass(pass, confpass);

        if (check_name == false || check_password == false) {

            Toast.makeText(getApplicationContext(), "Enter Data Again.. :P", Toast.LENGTH_LONG).show();
        } else {

            db.addNewUser(new user(name, pass));

            Toast.makeText(getApplicationContext(), "Sign Up Successful!! O_o", Toast.LENGTH_LONG).show();
        }


        Toast.makeText(getApplicationContext(), "\nName: " + name + "\nPassword:" + pass, Toast.LENGTH_LONG).show();


    }

    //Check Name
    //Check Name
    public boolean checkName(String usrName) {

        if (usrName.isEmpty()) {
           // Toast.makeText(getApplicationContext(), "This executes", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }

    public boolean checkPass(String pass, String conf) {

        if (pass.equals(conf)&&(!pass.isEmpty())) {
            return true;
        } else {
            return false;
        }
    }


}