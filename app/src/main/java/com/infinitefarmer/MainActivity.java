package com.infinitefarmer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.PhoneNumber;
import com.infinitefarmer.volley.DataCallback;
import com.infinitefarmer.volley.DataManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int PHONE_VERIFICATION = 789;
    public static int APP_REQUEST_CODE = 99;
    String phone;
    Button btnLogin, btnRegister;
    String userTypeString;
    EditText etAge, etAadhar;

    ArrayList<String> languages = new ArrayList<>();
    ArrayList<String> userType = new ArrayList<>();

    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btn_login);
        etAge = findViewById(R.id.etAge);
        etAadhar = findViewById(R.id.etAadhar);

        dialog=new ProgressDialog(this);
        dialog.setMessage("Registering User");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent, PHONE_VERIFICATION);
            }
        });

        Spinner spinner = findViewById(R.id.spinner);

        Spinner spinnerType = findViewById(R.id.spinnerType);

        userType.add("Choose User Type");
        userType.add("Farmer");
        userType.add("Buyer");

        languages.add("Choose Language");
        languages.add("English");
        languages.add("Hindi");
        languages.add("Gujarati");
        languages.add("Tamil");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, languages);

        ArrayAdapter<String> dataAdapterType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, userType);

        spinner.setAdapter(dataAdapter);
        spinnerType.setAdapter(dataAdapterType);


        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               PrefManager.setUserType(userType.get(i), MainActivity.this);
                        userTypeString=userType.get(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User();
                user.setAadhar(etAadhar.getText().toString());
                user.setAge(etAge.getText().toString());
                user.setType(userTypeString);
                user.setPhone(btnLogin.getText().toString());

                dialog.show();

                register(user);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PHONE_VERIFICATION:
                if (data != null) {
                    phone = data.getStringExtra("phone");
                    btnLogin.setText(phone);

                }
        }
    }


    public void register(User user) {
        DataManager dataManager = new DataManager(this);
        DataCallback callback = new DataCallback() {
            @Override
            public void onError(String message, Integer... statuscode) {
                super.onError(message, statuscode);

            }

            @Override
            public void onError(String message) {
                super.onError(message);
            }

            @Override
            public void onResponse(JSONObject response) {
                super.onResponse(response);
                Log.d("ResponseType", response.toString());



                        Intent intent = new Intent(MainActivity.this, ImageUploadActivity.class);
                        startActivity(intent);
                        PrefManager.setLoggedIn(true, MainActivity.this);
                        dialog.dismiss();


            }
        };
        dataManager.registerUser(user,callback);
    }
}
