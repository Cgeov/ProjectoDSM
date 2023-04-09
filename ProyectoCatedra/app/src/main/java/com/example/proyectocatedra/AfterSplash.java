package com.example.proyectocatedra;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

public class AfterSplash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_splash);

        Button btnName = findViewById(R.id.btnName);
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AfterSplash.this, Calculadora.class);
                startActivity(intent);
            }
        });
        LottieAnimationView animationView = findViewById(R.id.animation_view);
        animationView.setRepeatCount(-1);
        animationView.setSpeed(0.09f);
        animationView.playAnimation();
        animationView.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animationView.playAnimation();
                    }
                }, 15000);
            }
        });

    }
}
