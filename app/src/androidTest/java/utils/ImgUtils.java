package utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by pateo on 18-3-12.
 */

public class ImgUtils {
    public static byte[] image2Bytes(String imagePath){
        byte[] data = null;
        FileInputStream input = null;
        try{
            input = new FileInputStream(new File(imagePath));
            ByteArrayOutputStream output  = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1){
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();

        }catch (FileNotFoundException ex1){
            ex1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


}
