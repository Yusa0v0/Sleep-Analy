package com.example.sleep_analy;

import org.junit.Test;

import static org.junit.Assert.*;

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

}

