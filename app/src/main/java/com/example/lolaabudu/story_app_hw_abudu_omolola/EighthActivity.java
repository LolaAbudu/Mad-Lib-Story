package com.example.lolaabudu.story_app_hw_abudu_omolola;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class EighthActivity extends AppCompatActivity {

    private EditText emailEditText8;
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
        int colorRes = ContextCompat.getColor(this, colorResourceName);
        ConstraintLayout layout = findViewById(R.id.eighth_activity);
        layout.setBackgroundColor(colorRes);

        Intent intent = getIntent();
        final String message1 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE1);
        final String message2 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE2);
        final String message3 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE3);
        final String message4 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE4);
        final String message5 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE5);
        final String message6 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE6);
        final String message7 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE7);
        final String concatenatedMessage = "So I wanted to tell a story about something but had no idea what to write about, so I decided to just make 'something\' up. Everyday I wake up thinking why is it " +
                message1 + " already, then I realize that I am a whole day older today. I lay there and think about my " +
                message2 + " and what the hell I am doing here. So I close my eyes and go right back to sleep. Dream time! Yaaaay! My favorite time of day. Jumping over " +
                message3 + " and flying through " +
                message4 + ", I realize how amazing dream-land can really be. Finding myself typing on a " +
                message5 + ", click click click is all I hear. As he drinks his bottle and hums a rhythm. Hurry up and eat little boy, so I can get this " +
                message6 + " done. Okay. Stop! Its play time. Time for mental release and " +
                message7 + " talk. I love these moments of time. Am I awake or still asleep? Not quite sure but time keeps flying and so do I.";

        TextView textView = findViewById(R.id.story_textView);
        textView.setText(concatenatedMessage);


        Button button = findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailEditText8 = findViewById(R.id.editText8);

                if (emailEditText8.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "Enter Email Address", Toast.LENGTH_SHORT).show();
                } else {
                    String emailAddress = emailEditText8.getText().toString();

                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Mad-Lib! What a Story!");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, concatenatedMessage);
                    emailIntent.setType("message/text");
                    startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));
                }
            }
        });
    }
}
