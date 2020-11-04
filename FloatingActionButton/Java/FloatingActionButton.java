package com.andoiddevop.animationassets.view.activity.ButtonAnimationExamples.floatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.andoiddevop.animationassets.R;
import com.google.android.material.button.MaterialButton;

//  //FloatingActionButton
//    implementation 'com.getbase:floatingactionbutton:1.10.1'


public class FloatingActionButton extends AppCompatActivity {

    MaterialButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}