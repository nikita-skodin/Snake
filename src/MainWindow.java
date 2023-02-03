/*ТУТ ВСЕ ПОНЯТНО*/

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MainWindow extends JFrame {

    public MainWindow(){
        setTitle("Snake");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 335 + 39);
        setLocation(600, 200);
        add(new GameField());
        this.setResizable(false);   // запрет расширешия окна
        setVisible(true);
        File file = new File("C:\\java_projects\\snake\\1p.png");
        try {
            this.setIconImage(ImageIO.read(file));
        } catch (IOException e) {
            System.out.println("ERR");
        }

    }

    public static void main(String[] args) {
        MainWindow mn = new MainWindow();
    }
}
