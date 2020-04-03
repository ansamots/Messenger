package sample.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SaveSettingsClient {
    /**
     * КОнструктор без параметров вызывается для определения есть ли файл с настройками или нет.
     */
    public SaveSettingsClient(){
        readFile();
    }

    public SaveSettingsClient(String ip, String port){
        this.ip = ip;
        this.port = port;
        writeFile();

    }

    /**
     * Записываем данные сервера в файл где лежит проэкт.
     */
    private void writeFile(){
        File file = new File("severAddress.txt");
        try{
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(ip+"\n"+port+"\n");
            writer.flush();
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    /**
     * метод проверки существования файла, если файл ыуществует, то присваиваем значения переменным из файла
     */
    private void readFile(){
        try {
            File file = new File("severAddress.txt");
            FileReader fr = new FileReader(file);
            BufferedReader read = new BufferedReader(fr);
            ip = read.readLine();
            port = read.readLine();
            fileExists = true; // Присваиваем переменной истину, что файл с настройками существует.

        }catch (Exception e){
            fileExists = false;
        }
    }

    public boolean isFileExists() {
        return fileExists;
    }

    public String getIP(){
        return ip;
    }

    public String getPort(){
        return port;
    }

    private boolean fileExists;
    private String ip;
    private String port;
}
