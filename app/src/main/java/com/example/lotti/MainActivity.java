package com.example.lotti;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.constraintlayout.motion.widget.MotionLayout;

import com.airbnb.lottie.LottieAnimationView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {

    LottieAnimationView thumb_down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thumb_down = findViewById(R.id.test);
        final MotionLayout motionLayout = findViewById(R.id.motion_layout);
//        r.addView(thumb_down);
//        thumb_down.setImageAssetsFolder("images/");
//        thumb_down.loop(true);
        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thumb_down.cancelAnimation();
                motionLayout.transitionToStart();
            }
        });

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thumb_down.playAnimation();

                motionLayout.transitionToEnd();

            }
        });


    }


    private Bitmap readFromAssets() {
        Bitmap bitmap;
        AssetManager asm=this.getAssets();
        try {
            InputStream is = asm.open("as.jpg");
            bitmap= BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            Log.e("MainActivity", "[*]failed to open " + "as.jpg");
            e.printStackTrace();
            return null;
        }
        return bitmap;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }

}