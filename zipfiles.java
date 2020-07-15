import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class zipfiles {
    public static void main(String args[]) {
    try {
        FileOutputStream fos = new FileOutputStream("sample.zip");
        ZipOutputStream zipOS = new ZipOutputStream(fos);
        String file1 = "names.txt";
        String file2 = "java7.txt";
        addToZipFile(file1, zipOS);
        addToZipFile(file2, zipOS);
        fos.close();
        zipOS.close();
    } catch (FileNotFoundException e){
     e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace(); } }


    }
}
public static void addToZipFile(String path, ZipOutputStream zipStream) throws FileNotFoundException, IOException { System.out.println("Writing file : '" + path + "' to zip file");
File aFile = new File(path);
FileInputStream fis = new FileInputStream(aFile);
ZipEntry zipEntry = new ZipEntry(path);
zipStream.putNextEntry(zipEntry);
byte[] bytes = new byte[1024];
int length;
while ((length = fis.read(bytes)) >= 0) {
    zipStream.write(bytes, 0, length);
}
zipStream.closeEntry(); fis.close();
}

