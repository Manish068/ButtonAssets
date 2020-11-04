package com.andoiddevop.animationassets.view.activity.ButtonAnimationExamples.SparkButton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.andoiddevop.animationassets.R;
import com.google.android.material.button.MaterialButton;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


//SparkButton
//    implementation 'com.github.varunest:sparkbutton:1.0.6'

public class SparkButton extends AppCompatActivity {

    com.varunest.sparkbutton.SparkButton star_button;
    com.varunest.sparkbutton.SparkButton heart_button;
    com.varunest.sparkbutton.SparkButton facebook_button;
    com.varunest.sparkbutton.SparkButton twitter_button;

    MaterialButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spark_button);
        star_button = findViewById(R.id.star_button);
        heart_button = findViewById(R.id.heart_button);
        facebook_button = findViewById(R.id.facebook_button);
        twitter_button = findViewById(R.id.twitter_button);
        backButton = findViewById(R.id.backButton);



        star_button.performClick();
        heart_button.performClick();



        backButton.setOnClickListener(v -> onBackPressed());

        ScheduledExecutorService scheduledExecutorService =
                Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleAtFixedRate(() -> runOnUiThread(() -> {

            star_button.setChecked(true);
            star_button.playAnimation();
            heart_button.setChecked(true);
            heart_button.playAnimation();
            facebook_button.playAnimation();
            twitter_button.playAnimation();
        }),3,3, TimeUnit.SECONDS);
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}