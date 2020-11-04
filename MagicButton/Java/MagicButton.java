package com.andoiddevop.animationassets.view.activity.ButtonAnimationExamples.MagicButton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.andoiddevop.animationassets.R;
import com.google.android.material.button.MaterialButton;

//MagicButton
//    implementation 'com.github.bloder:magic:1.1'

public class MagicButton extends AppCompatActivity {


    MaterialButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_button);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(v -> onBackPressed());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}