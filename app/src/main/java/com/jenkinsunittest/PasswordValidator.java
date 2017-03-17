package com.jenkinsunittest;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.regex.Pattern;

/**
 * Created by Hari Prasad on 3/17/17.
 */

public class PasswordValidator implements TextWatcher {

    public static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})"
    );

    private boolean mIsValid = false;

    public boolean PasswordValidator() {
        return mIsValid;
    }

    /**
     * Validate password with regular expression
     *
     * @param password password for validation
     * @return true valid password, false invalid password
     */
    public static boolean isValidPassword(CharSequence password) {
        return password != null && PASSWORD_PATTERN.matcher(password).matches();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        mIsValid = isValidPassword(s);
    }
}
