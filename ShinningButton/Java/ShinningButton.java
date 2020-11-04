package com.andoiddevop.animationassets.view.activity.ButtonAnimationExamples.ShinningButton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.andoiddevop.animationassets.R;
import com.google.android.material.button.MaterialButton;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ShinningButton extends AppCompatActivity {


    private ImageView iv_img, shine;
    private MaterialButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shinning_button);

        iv_img=findViewById(R.id.iv_img);
        shine = findViewById(R.id.shine);

        backButton = findViewById(R.id.backButton);


        ScheduledExecutorService scheduledExecutorService =
                Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleAtFixedRate(() -> runOnUiThread(this::shinestart),3,3, TimeUnit.SECONDS);

        backButton.setOnClickListener(v -> onBackPressed());

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }

    private void shinestart(){
        Animation animation = new TranslateAnimation(0, iv_img.getWidth()+shine.getWidth(), 0, 0);
        animation.setDuration(550);
        animation.setFillAfter(false);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        shine.startAnimation(animation);
    }

}