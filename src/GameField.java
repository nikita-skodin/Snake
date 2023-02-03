import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {  // выше все ясно
    private final int SIZE = 320;   // длинна и ширина игрового поля
    private final int DOT_SIZE = 16;    // длинна и ширина игровой единицы
    private final int ALL_DOTS = 400;   // сколько всего игровых единиц может поместиться на поле
    private Image dot;  // единица змейки картинка
    private Image apple;    // единица яблока картинка
    private int appleX; // х позиция яблока
    private int appleY; // y позиция яблока
    private int [] x = new int [ALL_DOTS];  // массив позиций змейки x
    private int[] y = new int [ALL_DOTS];   // массив позиций змейки y
    private int dots;   // размер змейки в данный момент
    private Timer timer;    // таймер
    private boolean left = false;   // движение
    private boolean right = true;   // движение
    private boolean up = false;   // движение
    private boolean down = false;   // движение
    private boolean inGame = true;   // в игре ли
    private int count = -1;


    public GameField(){
        setBackground(Color.BLACK); // ok
        loadImages();   // ok
        initGame();
        addKeyListener(new FieldKeyListener());     // понятно
        setFocusable(true);     // нужна база
    }

    public void initGame(){   // ???
        dots = 3;   // тут понял
        for (int i = 0; i < dots; i++) {    // допустим понял
            x[i] = 48 - i * DOT_SIZE;    // допустим понял
            y[i] = 48;    // допустим понял
        }    // допустим понял
        timer = new Timer(100, this);   // не понял
        timer.start();   // тут понял
        createApple();   // тут понял
    }

    public void createApple(){      // понял
        count++;
        appleX = new Random().nextInt(20) * DOT_SIZE;   // понял
        appleY = new Random().nextInt(20) * DOT_SIZE;   // понял
    }

    public void loadImages(){   // тут все понятно
        ImageIcon iia = new ImageIcon("C:\\java_projects\\snake\\apple.png");   // тут все понятно
        apple = iia.getImage();   // тут все понятно

        ImageIcon iid = new ImageIcon("C:\\java_projects\\snake\\dot.png");   // тут все понятно
        dot = iid.getImage();   // тут все понятно
    }   // тут все понятно

    @Override
    protected void paintComponent(Graphics g) {      // понял
        super.paintComponent(g);      // понял
        if(inGame){      // понял
            g.drawImage(apple, appleX, appleY, this);      // понял
            for (int i = 0; i < dots; i++) {      // понял
                g.drawImage(dot, x[i], y[i], this);      // понял
            }
        }else{      // понял
            String str = "Game Over";      // понял
            //Font f = new Font("Arial",14,Font.BOLD);      // понял
            g.setColor(Color.white);      // понял
            // g.setFont(f);      // понял
            g.drawString(str + "\n"+ " you points " + count,105,SIZE/2 - 25);      // понял
        }      // понял
    }      // понял

    public void move(){     //не понял!!!!!!!!!!!!!!!!
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if(left){
            x[0] -= DOT_SIZE;
        }
        if(right){
            x[0] += DOT_SIZE;
        }
        if(up){
            y[0] -= DOT_SIZE;
        }
        if(down){
            y[0] += DOT_SIZE;
        }
    }

    public void checkApple(){   // понял
        if (x[0] == appleX && y[0] == appleY){   // понял
            dots++;   // понял
            createApple();   // понял
        }   // понял
    }   // понял

    public void checkCollisions(){      // понял
        for (int i = dots; i > 0; i--){      // понял
            if(i>4 && x[0] == x[i] && y[0] == y[i]){      // понял
                inGame = false;      // понял
            }      // понял
        }      // понял

        if(x[0]>SIZE){      // понял
            inGame = false;      // понял
        }      // понял
        if(x[0]<0){      // понял
            inGame = false;      // понял
        }      // понял
        if(y[0]>SIZE){      // понял
            inGame = false;      // понял
        }      // понял
        if(y[0]<0){      // понял
            inGame = false;      // понял
        }      // понял
    }      // понял

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){      // понял
            checkApple();      // понял
            checkCollisions();      // понял
            move();      // не понял!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        }      // понял
        repaint();  // понял
    }

    class FieldKeyListener extends KeyAdapter {     // понятно
        @Override     // понятно
        public void keyPressed(KeyEvent e) {     // понятно
            super.keyPressed(e);     // понятно
            int key = e.getKeyCode();     // понятно
            if (key == KeyEvent.VK_LEFT && !right) {     // понятно
                left = true;     // понятно
                up = false;     // понятно
                down = false;     // понятно
            }     // понятно
            if (key == KeyEvent.VK_RIGHT && !left) {     // понятно
                right = true;     // понятно
                up = false;     // понятно
                down = false;     // понятно
            }     // понятно

            if (key == KeyEvent.VK_UP && !down) {     // понятно
                right = false;     // понятно
                up = true;     // понятно
                left = false;     // понятно
            }     // понятно
            if (key == KeyEvent.VK_DOWN && !up) {     // понятно
                right = false;     // понятно
                down = true;     // понятно
                left = false;     // понятно
            }     // понятно
        }     // понятно
    }     // понятно

}
