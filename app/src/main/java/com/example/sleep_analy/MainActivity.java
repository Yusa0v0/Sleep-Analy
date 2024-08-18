package com.example.sleep_analy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sleep_analy.Tools.ParseBak;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("123");

        Button button=findViewById(R.id.refreshBakFileButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ParseBak.RewriteBakFile("","",5);
//                ParseBak.testWriteMIUIFile();
//                writeDataFile("test.txt","content");
//                Toast.makeText(MainActivity.this,"按钮被点击了",Toast.LENGTH_SHORT).show();
            }
        });

    }


    //TODO
    //读取内置data目录下文件
    public String readDataFile(String fileName) {
        String res = "";
        try {
            FileInputStream fin = openFileInput(fileName);
            int length = fin.available();
            byte[] buffer = new byte[length];
            fin.read(buffer);
            res = new String(buffer);
            fin.close();

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", "readDataFile Error!" + e.getMessage());
        }
        return res;
    }

    //TODO
    //写入内置data目录下文件
    private void writeDataFile(String fileName, String content) {
        try {
            FileOutputStream fut = openFileOutput(fileName, Context.MODE_PRIVATE | Context.MODE_APPEND);
            byte[] bytes = content.getBytes();
            fut.write(bytes);
            fut.close();
            Toast.makeText(MainActivity.this,bytes.toString(),Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", "writeDataFile Error!" + e.getMessage());
        }
    }
}