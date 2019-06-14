package com.example.mychef_orwima;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity  {

    private Button about_btn;

    private FragmentAbout mFragment;
    FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        about_btn=findViewById(R.id.about_btn);

        about_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment();
            }
        });


        TextView textView = findViewById(R.id.heading_tv);
        Typeface typeface = ResourcesCompat.getFont(this,R.font.vibes);
        textView.setTypeface(typeface);
    }

    public void setFragment() {
        mFragment=new FragmentAbout();
        fManager = getSupportFragmentManager();
        FragmentTransaction ft = fManager.beginTransaction();
        ft.add(R.id.frame_cnt,mFragment);
        ft.commit();
    }



    public void BtnClick(View v) {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
