package com.andoiddevop.animationassets.view.activity.ButtonAnimationExamples;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.andoiddevop.animationassets.R;

public class SubmitButton extends AppCompatActivity {

    com.spark.submitbutton.SubmitButton submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_button);


        submitButton = findViewById(R.id.SubmitButton);

        submitButton.setOnClickListener(v -> new Handler().postDelayed(() -> onBackPressed(),3200));


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}