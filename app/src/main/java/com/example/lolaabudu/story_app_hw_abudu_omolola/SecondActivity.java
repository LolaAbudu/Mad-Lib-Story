package com.example.lolaabudu.story_app_hw_abudu_omolola;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private EditText mResponseEditText2;
    private Button button;

    public static final String EXTRA_MESSAGE1 = "first_extra_message";
    public static final String EXTRA_MESSAGE2 = "second_extra_message";
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "light_pink" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Random random = new Random();
        String backgroundColor = mColorArray[random.nextInt(20)];
        int colorResourceName = getResources().getIdentifier(backgroundColor,
                "color", getApplicationContext().getPackageName());
        int colorRes = ContextCompat.getColor(this, colorResourceName);
        ConstraintLayout layout = findViewById(R.id.second_activity);
        layout.setBackgroundColor(colorRes);

        mResponseEditText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button2);

        Intent intent2 = getIntent();
        final String message1 = intent2.getStringExtra(MainActivity.EXTRA_MESSAGE1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userResponse = mResponseEditText2.getText().toString();

                if (TextUtils.isEmpty(userResponse)) {
                    Toast.makeText(v.getContext(), "Enter Response", Toast.LENGTH_SHORT).show();
                }else {
                    String userInput = mResponseEditText2.getText().toString();
                    Intent intent = new Intent(v.getContext(), ThirdActivity.class);
                    intent.putExtra(EXTRA_MESSAGE1, message1);
                    intent.putExtra(EXTRA_MESSAGE2, userInput);
                    startActivity(intent);
                }
            }
        });
    }
}
