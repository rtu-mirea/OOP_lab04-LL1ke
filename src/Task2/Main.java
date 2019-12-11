package Task2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Задание 2
        try {
            boolean c = true;
            Scanner in = new Scanner(System.in);
            ArrayList<Toy> t1 = new ArrayList<Toy>();
            ArrayList t2 = new ArrayList<Toy>();
            FileControl fi = new FileControl();
            while (c) {
                System.out.println("1.Добавить игрушку\n2.Записать массив игрушек\n3.Прочитать из файла 2го пункта и получить массив игрушек с заданной фирмой" +
                        "\n4.Уменьшить цену вдвое для детей\n5.Выход");
                int a = Integer.parseInt(in.next());
                switch (a) {
                    case 1:
                        System.out.println("Введите название фирмы, цену, минимальный возраст: ");
                        Toy t = new Toy(in.next(), Integer.parseInt(in.next()), Integer.parseInt(in.next()));
                        t1.add(t);
                        break;
                    case 2:
                        if (t1.isEmpty()) {
                            System.out.println("Массив пуст");
                            break;
                        }
                        fi.write(t1);
                        break;
                    case 3:
                        if (t1.isEmpty()) {
                            System.out.println("Массив пуст");
                            break;
                        }
                        System.out.println("Введите название фирмы");
                        String s = in.next();
                        t2 = fi.read(s);
                        System.out.println(t2.toString());
                        break;
                    case 4:
                        if (t2.isEmpty()) {
                            System.out.println("Массив пуст");
                            break;
                        }
                        fi.raf(t2);

                        break;
                    case 5:
                        c = false;
                        break;

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}