package com.andoiddevop.animationassets.view.activity.ButtonAnimationExamples.LiquidButton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.andoiddevop.animationassets.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

import butterknife.OnClick;

    //LiquidButton
//    implementation 'com.gospelware.liquidbutton:liquidButtonLib:1.1.5'




public class LiquidButton extends AppCompatActivity {

    com.gospelware.liquidbutton.LiquidButton liquidButton;
    TextView textView, tapScreenTextView;
    private final float progress=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquid_button);


        liquidButton = findViewById(R.id.liquid_button);
        textView = findViewById(R.id.progress_tv);
        tapScreenTextView = findViewById(R.id.tapScreen_tv);




        liquidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapScreenTextView.setVisibility(View.GONE);
                liquidButton.setAutoPlay(true);
                liquidButton.startPour();
            }
        });



        liquidButton.setPourFinishListener(new com.gospelware.liquidbutton.LiquidButton.PourFinishListener() {
            @Override
            public void onPourFinish() {
                Toast.makeText(LiquidButton.this, "Finish", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }

            @Override
            public void onProgressUpdate(float progress) {
                textView.setText(String.format("%.2f", progress * 100) + "%");
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