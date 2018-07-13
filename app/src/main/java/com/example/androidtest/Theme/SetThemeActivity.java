package com.example.androidtest.Theme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.androidtest.R;

public class SetThemeActivity extends AppCompatActivity {
    private Button mSetRedButton;
    private Button mSetGreyButton;
    private static int sTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //必须在setContentView之前实现
        if(sTheme!=0){
            setTheme(sTheme);
        }
        setContentView(R.layout.activity_set_theme);

        mSetRedButton=(Button)findViewById(R.id.red);
        mSetGreyButton=(Button)findViewById(R.id.grey);

        mSetRedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sTheme=R.style.RedTheme;
                recreate();
            }
        });
        mSetGreyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sTheme=R.style.GreyTheme;
                recreate();
            }
        });
    }
}
