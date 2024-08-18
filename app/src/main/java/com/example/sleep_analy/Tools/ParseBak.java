package com.example.sleep_analy.Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ParseBak {

    public void RewriteBakFile(String inputPath,String outPath,int removeCharCount)  {
//        读文件
        File input_file = new File(inputPath);//"D:\\sleeping analysis\\test.txt"
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
//      去字符
        byte[] newFileContent = new byte[(int) input_file.length()-removeCharCount];
        System.arraycopy(fileContent, 5, newFileContent, 0, fileContent.length - removeCharCount);

//        写文件
        try {
            File file = new File(outPath);//"D:\\sleeping analysis\\test2.txt"
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(newFileContent);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
