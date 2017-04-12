package com.jenkinsunittest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "SignInActivity";
    private EditText user_gmail_et, user_password_et;
//    private TextView back_to_registration, forgot_signIn;
    private Button sign_in_btn;
    private EmailValidator mEmailValidator;
    private PasswordValidator mpasswordValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        user_gmail_et = (EditText) findViewById(R.id.user_gmail_et);
        user_password_et = (EditText) findViewById(R.id.user_password_et);
        sign_in_btn = (Button) findViewById(R.id.sign_in_btn);
        sign_in_btn.setOnClickListener(this);
        // Setup eamil field validators.
        mEmailValidator = new EmailValidator();
        user_gmail_et.addTextChangedListener(mEmailValidator);
        // Setup password field validators.it contains small,capital,Symbol,number and length(6-20) letters.
        mpasswordValidator = new PasswordValidator();
        user_password_et.addTextChangedListener(mpasswordValidator);

        user_gmail_et.setText("ramesh@gmail.com");
        user_password_et.setText("ream@123M");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_btn:
                String email = user_gmail_et.getText().toString();
                if (!isNetworkAvailable()) {
                    showToast("You're not connected to a Network...");
                    return;
                }
                if (user_gmail_et.getText().toString().length() == 0) {
                    showToast("Please enter email...");
                    return;
                }
                if (!mEmailValidator.isValid()) {
                    user_gmail_et.setError("Invalid email");
                    Log.w(TAG, "Not saving personal information: Invalid email");
                    return;
                }
                if (user_password_et.getText().toString().length() == 0) {
                    showToast("Please enter password...");
                    return;
                }
                if (!mpasswordValidator.PasswordValidator()) {
                    user_password_et.setError("Invalid email");
                    Log.w(TAG, "Not saving personal information: Invalid password");
                    return;
                }
                showToast(email);
                MainActivity.start(SignInActivity.this);
                finish();
                break;
        }
    }
}
