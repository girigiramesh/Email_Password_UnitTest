package com.jenkinsunittest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Hari Prasad on 3/17/17.
 */

public class MainActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
