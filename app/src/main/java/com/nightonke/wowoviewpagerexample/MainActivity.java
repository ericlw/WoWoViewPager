package com.nightonke.wowoviewpagerexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.wowo_translation_animation).setOnClickListener(this);
        findViewById(R.id.wowo_scale_animation).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SetEaseTypeActivity.class);
        switch (v.getId()) {
            case R.id.wowo_translation_animation:
                intent.putExtra("AnimationType", "WoWoTranslationAnimation");
                break;
            case R.id.wowo_scale_animation:
                intent.putExtra("AnimationType", "WoWoScaleAnimation");
                break;
        }
        startActivity(intent);
    }
}
