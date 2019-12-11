package Task3;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Main {
    public static void num1 () throws IOException {
        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("T2.txt"));
        DataInputStream dataIn = new DataInputStream(new FileInputStream("T1.txt"));
        int i;
        while ((i = dataIn.read()) != -1){
            dataOut.write(i);
        }
        dataIn.close();
        dataOut.close();
    }

    public static void num2() throws Exception{
        BufferedReader inb = new BufferedReader(new FileReader("A.txt"), 128);
        BufferedWriter outb = new BufferedWriter(new FileWriter("B.txt"));
        char[] buf = new char[128];

        while ((inb.read(buf)) != -1){
            outb.write(buf);
            outb.newLine();
        }
        outb.flush();
        outb.close();
        inb.close();
    }

    public static void num3() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("src\\A.txt"), "UTF-8"));
        System.out.println(Charset.defaultCharset().name());
        String s = "";
        while ((s = in.readLine()) != null){
            System.out.println(s);
        }
        System.out.println();
        in = new BufferedReader(new InputStreamReader(new FileInputStream("src\\B.txt"), "UTF-16"));
        while ((s = in.readLine()) != null){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        try {
            num1();
            num2();
            num3();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
