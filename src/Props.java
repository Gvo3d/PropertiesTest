import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Gvozd on 10.07.2016.
 */
public class Props {
    String propfile = "resources/counter.properties";
    Properties props = new Properties();
    int i=0;

    public String getCounter() {
        FileInputStream fis;
        String counter="";

        try {
            fis = new FileInputStream(propfile);
            props.load(fis);

            counter = props.getProperty("number");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");

        }
        return counter;
    }

    private void setCounter(){
        FileOutputStream fos;

        try{
            fos = new FileOutputStream(propfile);
            props.setProperty("number", Integer.toString(i));
            props.store(fos, "");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Props prtest = new Props();
        String text = prtest.getCounter();
        System.out.println(text);

        int nn = Integer.parseInt(text);
        prtest.i=nn+5;
        prtest.setCounter();
    }
}
