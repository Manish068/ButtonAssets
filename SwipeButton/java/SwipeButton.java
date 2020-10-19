package com.andoiddevop.animationassets.view.activity.ButtonAnimationExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.andoiddevop.animationassets.R;
import com.ebanx.swipebtn.OnStateChangeListener;

public class SwipeButton extends AppCompatActivity {

    com.ebanx.swipebtn.SwipeButton swipeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_button);

        swipeBtn= findViewById(R.id.swipeBtn);
        swipeBtn.setOnStateChangeListener(active -> {
            onBackPressed();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}