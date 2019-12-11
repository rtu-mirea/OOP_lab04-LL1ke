package Task4;

public class Main {
    public static void main(String[] args) {
        //Задание 2
        try {
            ClassTextFile ctf = new ClassTextFile("task4.txt");
            User us1 = new User();
            ctf.fill(us1);
            System.out.println(us1.toString());

            ClassSeriyazableFile csf = new ClassSeriyazableFile("task42.txt");
            csf.record(us1);
            us1 = csf.read();
            System.out.println(us1.toString());
            csf.collection();
            csf.readfile();
            System.out.println(csf.gerArray().toString());

        } catch (Exception e) {
            System.out.println("Ошибка");
        }

    }
}