package com.example.lolaabudu.story_app_hw_abudu_omolola;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class EighthActivity extends AppCompatActivity {

    private EditText emailEditText8;
    private Button button;
    private ConstraintLayout layout;
    private TextView textView;
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "light_pink"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth);
        Random random = new Random();
        String backgroundColor = mColorArray[random.nextInt(20)];
        int colorResourceName = getResources().getIdentifier(backgroundColor,
                "color", getApplicationContext().getPackageName());
        textView = findViewById(R.id.story_textView);
        emailEditText8 = findViewById(R.id.editText8);
        button = findViewById(R.id.button8);
        layout = findViewById(R.id.eighth_activity);
        int colorRes = ContextCompat.getColor(this, colorResourceName);
        layout.setBackgroundColor(colorRes);

        final String concatenatedMessage = getStrings();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = emailEditText8.getText().toString();

                if (TextUtils.isEmpty(emailAddress)) {
                    Toast.makeText(v.getContext(), "Enter Email Address", Toast.LENGTH_SHORT).show();
                } else {
                    Uri uri = Uri.fromParts(
                            "mailto", emailAddress, null);
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Mad-Lib! What a Story!");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, concatenatedMessage);
                    startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));
                }
            }
        });
    }

    @NonNull
    private String getStrings() {
        Intent intent = getIntent();
        String message1 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE1);
        String message2 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE2);
        String message3 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE3);
        String message4 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE4);
        String message5 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE5);
        String message6 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE6);
        String message7 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE7);
        String concatenatedMessage = getString(R.string.concatenated_message,
                message1,
                message2,
                message3,
                message4,
                message5,
                message6,
                message7);

        textView.setText(concatenatedMessage);
        return concatenatedMessage;
    }
}
