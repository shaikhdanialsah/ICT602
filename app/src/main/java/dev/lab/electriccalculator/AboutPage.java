package dev.lab.electriccalculator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import java.time.*;




public class AboutPage extends AppCompatActivity {

    TextView copyRighttext;

   CardView buttonGithub;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_page);
        copyRighttext = findViewById(R.id.copyRightText);
        buttonGithub = findViewById(R.id.buttonGithub);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Developer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int copyrightSymbolCodePoint = 169 ;
        String s = Character.toString((char) copyrightSymbolCodePoint);

        Year thisYear = Year.now();
        copyRighttext.setText(s+" "+thisYear+" MyTNB, All Rights Reserved");

        buttonGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLink("https://github.com/shaikhdanialsah/ICT602");
            }
        });
    }

    private void goLink(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @SuppressLint("MissingSuperCall")
    @Override
    //When user click on back button
    public void onBackPressed() {
        Intent intent = new Intent(AboutPage.this, MainActivity.class);
        startActivity(intent);


    }
}
