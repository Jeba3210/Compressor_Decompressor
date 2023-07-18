package Compressor_Decompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompressor {
    public static void method(File file) throws IOException{

        String fileDirectory = file.getParent();

        FileInputStream fI = new FileInputStream(file);
        FileOutputStream fO = new FileOutputStream(fileDirectory+"/DecompressedFile.gz");
        GZIPInputStream gzip = new GZIPInputStream(fI);

        byte[] buffer = new byte[1024];

        int length;

        while ((length = gzip.read(buffer)) != -1) {
            fO.write(buffer,0,length);
        }

        gzip.close();
        fO.close();
        fI.close();
    }

    public static void main(String[] args) throws IOException{
        File path = new File("C:\\Users\\User\\Desktop\\CompressedFile");
    }
}
