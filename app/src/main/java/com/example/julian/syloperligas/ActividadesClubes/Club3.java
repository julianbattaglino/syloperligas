package com.example.julian.syloperligas.ActividadesClubes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.julian.syloperligas.R;
import com.tomer.fadingtextview.FadingTextView;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Club3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club3);

        String[] texts = {"Club Actual: Manchester City"};
        FadingTextView FTV = (FadingTextView) findViewById(R.id.fadingTextView);
        FTV.setTexts(texts);
        FTV.setTimeout(1, SECONDS);

    }
}
