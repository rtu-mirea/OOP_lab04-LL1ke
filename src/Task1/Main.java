package Task1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        try {
            //упражнение 1
            File MyFile1 = new File("MyFile1.txt");
            MyFile1.createNewFile();
            File MyFile2 = new File("C:\\repo\\MyFile2.txt");
            MyFile2.createNewFile();
            File MyFile3 = new File("C:\\Users\\tsapl\\Desktop\\WORK\\MIREA\\OOP\\OOPLAB4\\MyFile3.txt");
            MyFile3.createNewFile();
            File folders = new File("First\\Second\\Third");
            folders.mkdirs();

            //Упражнение 2
            System.out.println("Введите путь к файлу:");
            Scanner in = new Scanner(System.in);
            String way = in.next();
            File t2 = new File(way);
            System.out.println(t2.getName());
            System.out.println(t2.getParent());

            if (!way.contains(".")){
                System.out.println("Введена папка а не файл");
            }

            File check = new File("MyFile1.txt");
            if(check.exists()){
                System.out.println("MyFile1.txt существует");
            }else{
                System.out.println("MyFile1.txt не существует");
            }

            System.out.println(t2.getAbsolutePath());

            System.out.println(t2.length() + " байт");
            if (t2.isDirectory()){
                System.out.println("объект - папка");
            }else{
                System.out.println("объект - файл");
            }

            //Упражнение 3
            File ndir = new File("newDirectory");
            ndir.mkdir();
            File folder = new File("C:\\Users\\tsapl\\Desktop\\WORK\\MIREA\\OOP\\OOPLAB4");
            String[] listOfFiles_str = folder.list();
            File[] listOfFiles = folder.listFiles();

            System.out.println("содержимое папки приложения через list()");
            for(String y: listOfFiles_str){
                System.out.println(y);
            }

            System.out.println("содержимое папки приложения через listFiles()");
            int fi = 0, dir = 0;
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName());
                    fi++;
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println(listOfFiles[i].getName());
                    dir++;
                }
            }
            System.out.println("Количество файлов: " + fi);
            System.out.println("Количество папок: " + dir);

            MyFile1.delete();
            MyFile2.delete();
            MyFile3.delete();
            folders.delete();
            folders = new File ("First\\Second");
            folders.delete();
            folders = new File ("First");
            folders.delete();
            ndir.delete();

        }catch (Exception e){
            System.out.println("error");
        }
    }
}
