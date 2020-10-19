package com.andoiddevop.animationassets.view.activity.ButtonAnimationExamples

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.andoiddevop.animationassets.R
import kotlinx.android.synthetic.main.activity_login_button.*

 class ProgressBarButton :AppCompatActivity(){
    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_button)

        activity_main_btn.setOnClickListener {
            val progressbar = BtnLoadingProgressbar(it) // `it` is view of button
            progressbar.setLoading()
            handler.postDelayed({
                progressbar.setState(true) { // executed after animation end
                    handler.postDelayed({
                        startError(progressbar)
                    }, 1500)
                }
            }, 2000)
        }
    }

    private fun startError(progressbar: BtnLoadingProgressbar) {
        progressbar.reset()
        handler.postDelayed({
            progressbar.setLoading()
            handler.postDelayed({
                progressbar.setState(false) { // executed after animation end
                    handler.postDelayed({
                        progressbar.reset()
                        onBackPressed()
                    }, 1000)
                }
            }, 500)
        }, 200)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        finish()
    }
}