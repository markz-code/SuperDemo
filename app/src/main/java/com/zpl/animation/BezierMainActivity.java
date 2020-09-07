package com.zpl.animation;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zpl.R;

public class BezierMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bezier);
    }

    public void secondBezierTest(View view) {
        startActivity(new Intent(this, SecondBezierActivity.class));
    }

    public void thirdBezierTest(View view) {
        startActivity(new Intent(this, ThirdBezierActivity.class));
    }

    public void drawPadBezierTest(View view) {
        startActivity(new Intent(this, DrawPadActivity.class));
    }

    public void pathMorthingBezierTest(View view) {
        startActivity(new Intent(this, PathMorthingActivity.class));
    }

    public void waveBezierTest(View view) {
        startActivity(new Intent(this, WaveActivity.class));
    }

    public void pathBezierTest(View view) {
        startActivity(new Intent(this, PathBezierActivity.class));
    }
}
