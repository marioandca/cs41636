package com.example.multithreading;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button create = (Button) findViewById(R.id._create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fout = openFileOutput("numbers.txt", Context.MODE_PRIVATE);
                    for (int i = 1; i <= 10; ++i) {
                        String str = Integer.toString(i) + "\n";
                        fout.write(str.getBytes());
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    fout.close();
                } catch (IOException e) {
                    System.out.println("1");
                }
            }
        });

        final Button load = (Button) findViewById(R.id._load);
        final ListView list = (ListView) findViewById(R.id._list);
        final List<String> text = new ArrayList<String>();
        final ArrayAdapter<String> _adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, text);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileInputStream fin = null;
                try {
                    fin = openFileInput("numbers.txt");
                } catch (FileNotFoundException e) {
                    System.out.println("2");
                }

                int c;
                try {
                    if (fin != null) {
                        while ((c = fin.read()) != -1) {
                            String str = Character.toString((char) c);
                            while ((char) (c = fin.read()) != '\n') {
                                str += Character.toString((char) c);
                            }
                            text.add(str);
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    try {
                        if (fin != null) {
                            fin.close();
                        }
                    } catch (IOException e) {
                        System.out.println("3");
                    }
                    setListView(text, list, _adapter, false);


                } catch (IOException e) {
                    System.out.println("4");
                }

            }
        });

        final Button clear = (Button) findViewById(R.id._clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setListView(text, list, _adapter, true);
            }
        });

    }
    void setListView (List<String> text, final ListView list, ArrayAdapter<String> _adapter, boolean isClear) {
        if (isClear) {
            _adapter.clear();
        }
        else if (_adapter.isEmpty()) {
            _adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, text);
        }
        list.setAdapter(_adapter);

    }
}
