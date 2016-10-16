package res.layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.scripturereference.R;

public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();

        String book = extras.getString("Book");
        String chapter = extras.getString("Chapter");
        String verse = extras.getString("Verse");

        final TextView scripture = (TextView) findViewById(R.id.Scripture);
        scripture.setText("Your favorite scripture is: " + book + " " + chapter + ": " + verse);
    }

}
