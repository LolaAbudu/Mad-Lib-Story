package com.example.lolaabudu.story_app_hw_abudu_omolola;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class SixthActivity extends AppCompatActivity {

    private EditText mResponseEditText6;
    private Button button;

    public static final String EXTRA_MESSAGE1 = "first_extra_message";
    public static final String EXTRA_MESSAGE2 = "second_extra_message";
    public static final String EXTRA_MESSAGE3 = "third_extra_message";
    public static final String EXTRA_MESSAGE4 = "forth_extra_message";
    public static final String EXTRA_MESSAGE5 = "fifth_extra_message";
    public static final String EXTRA_MESSAGE6 = "sixth_extra_message";
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "light_pink" };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        Random random = new Random();
        String backgroundColor = mColorArray[random.nextInt(20)];
        int colorResourceName = getResources().getIdentifier(backgroundColor,
                "color", getApplicationContext().getPackageName());
        int colorRes = ContextCompat.getColor(this, colorResourceName);
        ConstraintLayout layout = findViewById(R.id.sixth_activity);
        layout.setBackgroundColor(colorRes);

        mResponseEditText6 = findViewById(R.id.editText6);
        button = findViewById(R.id.button6);

        Intent intent = getIntent();
        final String message1 = intent.getStringExtra(FifthActivity.EXTRA_MESSAGE1);
        final String message2 = intent.getStringExtra(FifthActivity.EXTRA_MESSAGE2);
        final String message3 = intent.getStringExtra(FifthActivity.EXTRA_MESSAGE3);
        final String message4 = intent.getStringExtra(FifthActivity.EXTRA_MESSAGE4);
        final String message5 = intent.getStringExtra(FifthActivity.EXTRA_MESSAGE5);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userResponse = mResponseEditText6.getText().toString();

                if (TextUtils.isEmpty(userResponse)) {
                    Toast.makeText(v.getContext(), "Enter Response", Toast.LENGTH_SHORT).show();
                }else {
                    String userInput = mResponseEditText6.getText().toString();
                    Intent intent = new Intent(v.getContext(), SeventhActivity.class);
                    intent.putExtra(EXTRA_MESSAGE1, message1);
                    intent.putExtra(EXTRA_MESSAGE2, message2);
                    intent.putExtra(EXTRA_MESSAGE3, message3);
                    intent.putExtra(EXTRA_MESSAGE4, message4);
                    intent.putExtra(EXTRA_MESSAGE5, message5);
                    intent.putExtra(EXTRA_MESSAGE6, userInput);
                    startActivity(intent);
                }
            }
        });
    }
}
