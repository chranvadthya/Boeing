

import java.io.FileReader;
public class Test {
    public static void main(String args[])throws Exception{
        FileReader fr=new FileReader("C:\\\\partner.wsdl");
        int i;
        while((i=fr.read())!=-1)
            System.out.print((char)i);
        fr.close();
    }
}

