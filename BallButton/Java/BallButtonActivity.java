package com.andoiddevop.animationassets.view.activity.ButtonAnimationExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.andoiddevop.animationassets.R;
import com.andoiddevop.animationassets.view.activity.MainActivity;

import java.util.ArrayList;

public class BallButtonActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] res = {R.id.ballButton_icon, R.id.twitter_icon, R.id.camera_icon, R.id.music_icon, R.id.setting_icon, R.id.facebook_icon, R.id.location_icon, R.id.message_icon, R.id.contact_icon};
    private final ArrayList<ImageView> imageViewList = new ArrayList<ImageView>();
    private boolean flag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_button);


        for (int re : res) {
            ImageView imageView = findViewById(re);
            imageView.setOnClickListener(this);
            imageViewList.add(imageView);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ballButton_icon:
                if (!flag) {
                    startAnim(v);
                } else {
                    closeAnim();
                }
                break;

            case R.id.twitter_icon:
                Toast.makeText(BallButtonActivity.this, "Twitter", Toast.LENGTH_SHORT).show();
                break;
            case R.id.camera_icon:
                Toast.makeText(BallButtonActivity.this, "Camera", Toast.LENGTH_SHORT).show();
                break;
            case R.id.music_icon:
                Toast.makeText(BallButtonActivity.this, "Music", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_icon:
                Toast.makeText(BallButtonActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.facebook_icon:
                Toast.makeText(BallButtonActivity.this, "Facebook", Toast.LENGTH_SHORT).show();
                break;
            case R.id.location_icon:
                Toast.makeText(BallButtonActivity.this, "Location", Toast.LENGTH_SHORT).show();
                break;
            case R.id.message_icon:
                Toast.makeText(BallButtonActivity.this, "Message", Toast.LENGTH_SHORT).show();
                break;

            case R.id.contact_icon:
                Toast.makeText(BallButtonActivity.this, "Contacts", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void startAnim(View view) {

        for (int i = 1; i < res.length; i++) {

            ObjectAnimator o1 = ObjectAnimator.ofFloat(imageViewList.get(i), "translationX", 0F, 200F);
            ObjectAnimator o2 = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", 0F, 200F);
            ObjectAnimator o3 = ObjectAnimator.ofFloat(imageViewList.get(i), "translationX", 0F, -200F);
            ObjectAnimator o4 = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", 0F, -200F);
            AnimatorSet set = new AnimatorSet();

            if (i <= 2) {
                set.play(o2);
                if (i == 2) {
                    set.play(o1);
                }
            } else if (i <= 4) {
                set.play(o1);
                if (i == 4) {
                    set.play(o4);
                }
            } else if (i <= 6) {
                set.play(o4);
                if (i == 6) {
                    set.play(o3);
                }
            } else if (i <= 8) {
                set.play(o3);
                if (i == 8) {
                    set.play(o2);
                }
            }
            set.setStartDelay(i * 100);
            set.setInterpolator(new BounceInterpolator());
            set.setDuration(1000);
            set.start();
            flag = true;
            Log.d("tag", "Open");
        }
    }

    private void closeAnim() {
        for (int i = 1; i < res.length; i++) {

            ObjectAnimator o1 = ObjectAnimator.ofFloat(imageViewList.get(i), "translationX", 200F, 0F);
            ObjectAnimator o2 = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", 200F, 0F);
            ObjectAnimator o3 = ObjectAnimator.ofFloat(imageViewList.get(i), "translationX", -200F, 0F);
            ObjectAnimator o4 = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", -200F, 0F);

            AnimatorSet set = new AnimatorSet();
            if (i <= 2) {
                set.play(o2);

                if (i == 2) {
                    set.play(o1);
                }
            } else if (i <= 4) {
                set.play(o1);
                if (i == 4) {
                    set.play(o4);
                }
            } else if (i <= 6) {
                set.play(o4);
                if (i == 6) {
                    set.play(o3);
                }
            } else if (i <= 8) {
                set.play(o3);
                if (i == 8) {
                    set.play(o2);
                }
            }
            set.setStartDelay(i * 100);
            set.setInterpolator(new AnticipateInterpolator());
            set.setDuration(1000);
            set.start();
            flag = false;
            new Handler().postDelayed(this::onBackPressed,2000);
            Log.d("tag", "close");
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }

}