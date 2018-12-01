package com.example.lolaabudu.story_app_hw_abudu_omolola;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class ThirdActivity extends AppCompatActivity {

    private EditText mResponseEditText3;
    public static final String EXTRA_MESSAGE2 = "second_extra_message";
    public static final String EXTRA_MESSAGE1 = "first_extra_message";
    public static final String EXTRA_MESSAGE3 = "third_extra_message";
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "light_pink" };


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Random random = new Random();
        String backgroundColor = mColorArray[random.nextInt(20)];
        int colorResourceName = getResources().getIdentifier(backgroundColor,
                "color", getApplicationContext().getPackageName());
        int colorRes = ContextCompat.getColor(this, colorResourceName);
        ConstraintLayout layout = findViewById(R.id.third_activity);
        layout.setBackgroundColor(colorRes);

        Intent intent3 = getIntent();
        final String message1 = intent3.getStringExtra(SecondActivity.EXTRA_MESSAGE1);
        final String message2 = intent3.getStringExtra(SecondActivity.EXTRA_MESSAGE2);


        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResponseEditText3 = findViewById(R.id.editText3);

                if (mResponseEditText3.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "Enter Response", Toast.LENGTH_SHORT).show();
                }else {
                    String userInput = mResponseEditText3.getText().toString();
                    Intent intent = new Intent(v.getContext(), ForthActivity.class);
                    intent.putExtra(EXTRA_MESSAGE1, message1);
                    intent.putExtra(EXTRA_MESSAGE2, message2);
                    intent.putExtra(EXTRA_MESSAGE3, userInput);
                    startActivity(intent);
                }
            }
        });
    }
}
