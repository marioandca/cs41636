package com.example.scripturereference;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import res.layout.ReceiverActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button btn = (Button) findViewById(R.id.Share);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText book = (EditText) findViewById(R.id.Book);
                final EditText chapter = (EditText) findViewById(R.id.Chapter);
                final EditText verse = (EditText) findViewById(R.id.Verse);
                Intent intent = new Intent(MainActivity.this, ReceiverActivity.class);
                intent.putExtra("Book", book.getText().toString());
                intent.putExtra("Chapter", chapter.getText().toString());
                intent.putExtra("Verse", verse.getText().toString());

                startActivity(intent);
            }
        });
    }

    public void display() {
        System.out.println("IT WORKS!\n IT'S ALIIIVE");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
