package VDcom;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Artur Gilyazov
 * задание 2 для VDcom
 * На вход передается целое число, больше 0, кратное 2 (n). Создается файл с именем
 * out.txt, в который пишется значение 0. Создается два потока, работающих
 * параллельно, каждый поток в цикле, считывает значение из файла out.txt увеличивает
 * его на 1, выводит в консоли старое значение, новое значение и идентификатор потока
 * (идентификатор может быть произвольным), и записывает обратно в файл.
 * В конечном итоге оба потока должны успешно завершить свою работу, и в консоль
 * должно вывестись содержимое файла out.txt (которое должно быть равно заданному
 * на входе n).
 */

public class task2 {
    public static void main(String[] args) throws IOException, InputMismatchException {

        try {
            System.out.println("Ввести четное число");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();

            File newFileForNum = new File(".src/main/num.txt");
            FileWriter fW = new FileWriter("num.txt", false);
            fW.write(num);
            fW.flush();

            File newFile = new File(".src/main/out.txt");
            FileWriter fileWriter = new FileWriter("out.txt", false);
            int txt = 0;
            fileWriter.write(txt);
            fileWriter.flush();

            for (int i = 0; i < 2; i++) {
                new createThread().start();
            }


        } catch (InputMismatchException e) {
            System.out.println("Введено не числовое значение или слишком большое число");

        }
    }
}


class createThread extends Thread {


    @Override
    public void run() {

        System.out.println("Start " + Thread.currentThread().getName());


        try {
            FileReader fileReader = new FileReader("out.txt");
            int c = fileReader.read();
            FileReader numSender = new FileReader("num.txt");

            int z = numSender.read();
            if (z % 2 == 0) {
                while (c < z) {
                    System.out.println(c);
                    c = c + 1;
                    System.out.println(c + " " + Thread.currentThread().getName());
                    FileWriter fileWriter = new FileWriter("out.txt", false);
                    String g = String.valueOf(c);
                    fileWriter.write(g);
                    fileWriter.flush();
                }
            } else System.out.println("нечетное число");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


