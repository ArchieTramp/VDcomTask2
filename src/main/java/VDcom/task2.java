package VDcom;

import java.io.*;

/**
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
    public static void main(String[] args) throws IOException {
        System.out.println("ready steady go");

        File newFile = new File("C://Users//Artur//IdeaProjects//VDcomTask2", "out.txt");
        System.out.println(newFile.createNewFile());
        FileWriter fileWriter = new FileWriter("out.txt", false);
        int txt = 0;
        fileWriter.write(txt);
        fileWriter.flush();

            //как то запаралеллить их
            new createThread().start();
            new createThread().start();


    }
}


class createThread extends Thread {

    createThread() {

    }
    @Override
    public void run() {
        System.out.println("Start " + Thread.currentThread().getName());


        try {
            FileReader fileReader = new FileReader("out.txt");
            int c = fileReader.read();
            System.out.println(c + " взял поток " + Thread.currentThread().getName());

            //как то передать num
            while (c <= 10) {
                System.out.println(c);
                c = c + 1;
                System.out.println(c + " " + Thread.currentThread().getName());
                FileWriter fileWriter = new FileWriter("out.txt", true);
                String g = String.valueOf(c);
                fileWriter.write(g + " ");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
