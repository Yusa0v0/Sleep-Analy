package com.example.sleep_analy;

import org.junit.Test;

import static org.junit.Assert.*;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void RewriteBakFile()  {
        File input_file = new File("D:\\sleeping analysis\\test.txt");
        byte[] fileContent = new byte[(int) input_file.length()];

        try (FileInputStream fileInputStream = new FileInputStream(input_file)) {
            // 一次性读取整个文件到字节数组
            int bytesRead = fileInputStream.read(fileContent);
            if (bytesRead != fileContent.length) {
                throw new IOException("Could not completely read file " + input_file.getName());
            }

            // fileContent 现在包含了整个文件的内容
        } catch (IOException e) {
            e.printStackTrace();
        }


        int removeCharCount=5;
        byte[] newFileContent = new byte[(int) input_file.length()-removeCharCount];
        System.arraycopy(fileContent, 5, newFileContent, 0, fileContent.length - removeCharCount);

        try {
            File file = new File("D:\\sleeping analysis\\test2.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(newFileContent);
            fos.close(); System.out.println("字节数组已写入文件");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    @Test
    public static final void testLogPath(){
        File root = Environment.getExternalStorageDirectory();
        File[] files = root.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    Log.e("文件夹", files[i].toString());
                }
                if (files[i].isFile()) {
                    Log.e("文件", files[i].toString());
                }
            }
        }
    }
    @Test
    //    在DOWNLOAD路径下写文件,可用
    public static final void testWriteFile(){
//        String path = "\\storage\\emulated\\0/test.txt";
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();

        byte[] byteArray = {10, 20, 30, 40, 50}; // 创建一个字节数组

        try {
            File file = new File(path,"text.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(byteArray);
            fos.close();
//            Log.e("write finished.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

