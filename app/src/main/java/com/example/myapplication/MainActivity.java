package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.text);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
    public void read(View v) {

        try{
            FileInputStream fileInputStream =
                    new FileInputStream(Environment.getExternalStorageDirectory()+
                            "/Download/text.txt");
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder stringBuilder = new StringBuilder();
            String str;

            while ((str = bufferedReader.readLine()) != null){
                stringBuilder.append(str+"\n");
            }
            textView.setText(stringBuilder.toString());
        }catch (IOException e){
            e.printStackTrace();
        }

        Toast.makeText(getBaseContext(),"Text read", Toast.LENGTH_LONG).show();
    }
    public void write(View v) throws IOException {
        File file = new File(Environment.getExternalStorageDirectory()+
                "/Download/text.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream =
                new FileOutputStream(Environment.getExternalStorageDirectory()+
                        "/Download/text.txt");
        fileOutputStream.write((editText.getText()+"\n").getBytes());
        fileOutputStream.close();
        Toast.makeText(getBaseContext(),"Text save", Toast.LENGTH_LONG).show();
    }
}