import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileCheckSum {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        File file = new File("c:/soap/abc.docx");
        File file1 = new File("c:/soap/copy/abc.docx");
        Long l=file.length();
        Long l1=file1.length();
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");

        String checksum = getFileChecksum(md5Digest, file);
        String checksum1 = getFileChecksum(md5Digest, file1);

        System.out.println( "MD5 Value abc file ="+checksum+ " length="+ l +" bytes");
        System.out.println(  "MD5 Value bcd file ="+checksum1+ " length="+ l1 + " bytes");

    }

    private static String getFileChecksum(MessageDigest digest, File file) throws IOException, IOException {
        FileInputStream filestream = new FileInputStream(file);

        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        while ((bytesCount = filestream.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };

        filestream.close();
        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}