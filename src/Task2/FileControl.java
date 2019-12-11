package Task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileControl {
    private String name = "";
    public void write(ArrayList<Toy> b) throws Exception{
        System.out.println("Enter file name");
        Scanner in = new Scanner(System.in);
        name = in.next();

        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(name));

        for(Toy t : b){
            byte[] bbb = t.toByteArray();
            dataOut.write(bbb);
        }

        File f = new File(name);
        if (f.exists()){
            System.out.println("exists");
        }else{
            System.out.println("don't exist");
        }

        dataOut.close();
    }

    public ArrayList read(String company) throws Exception{
        DataInputStream dataIn = new DataInputStream(new FileInputStream(name));
        ArrayList<Toy> b = new ArrayList<Toy>();
        byte[] obj = new byte[Toy.byteLen()];
        while (dataIn.available() > 0){
            dataIn.read(obj);
            Toy t = new Toy(obj);
            if(t.getNameFirm().equals(company)){
                b.add(t);
            }
        }
        dataIn.close();
        return b;
    }

    public void raf(ArrayList<Toy> b) throws Exception{

        name +="1";
        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(name));

        for(Toy t : b){
            byte[] bbb = t.toByteArray();
            dataOut.write(bbb);
        }
        dataOut.close();

        RandomAccessFile raf = new RandomAccessFile(name, "rw");
        raf.seek(0);
        byte[] obj = new byte[Toy.byteLen()];
        int readedBytes = raf.read(obj);
        while(readedBytes != -1){
            Toy t = new Toy(obj);
            if(t.getDuration() == Toy.getMin()) {
                t.discont();
                byte[] bbb = t.toByteArray();
                long pointer = raf.getFilePointer() - Toy.byteLen();
                raf.seek(pointer);
                raf.write(bbb);
            }
            readedBytes = raf.read(obj);
        }
        raf.close();
    }
}
