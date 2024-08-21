package cars;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Work extends JPanel implements ActionListener,KeyListener {
   
    private int space;
    private int width=80;
    private int height=70;
    private int speed;
    private int WIDTH=500;
    private int HEIGHT=700;
    private int move=20;
    private int count=1;
    private ArrayList <Rectangle> ocars;
    private Random rand;
    private Rectangle car;
    Timer t;
    
    public Work() {
        t=new Timer(20,this);
        rand=new Random();
        ocars=new ArrayList<Rectangle>();
        car=new Rectangle(WIDTH/2-90,HEIGHT-100,width,height);
        space =300;
        speed=2;
        addKeyListener(this);
        setFocusable(true);
        addocars(true);
        addocars(true);
        addocars(true);
        addocars(true);
        addocars(true);
        addocars(true);
        addocars(true);
        
        
        
        
        
        t.start();
    }
    public void addocars(boolean first) {
        int positionx=rand.nextInt()%2;
        int x=0;
        int y=0;
        int Width=width;
        int Height=height;
        if(positionx==0) {
            x=WIDTH/2-90;
        }else {
            x=WIDTH/2+10;
        }
        if(first) {
            ocars.add(new Rectangle(x,y-100-(ocars.size()*space),Width,Height));
        }else {
           ocars.add(new Rectangle(x,ocars.get(ocars.size()-1).y-500,Width,Height));
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.gray);
        g.fillRect(WIDTH/2-100,0,200,HEIGHT);
        g.setColor(Color.red);
        g.fillRect(car.x, car.y, car.width, car.height);
        g.setColor(Color.blue);
        g.drawLine( WIDTH/2, 0, WIDTH/2, HEIGHT);
        g.setColor(Color.magenta);
        for(Rectangle rect:ocars) {
            g.fillRect(rect.x, rect.y, rect.width, rect.height);
        }
    }
public void actionPerformed(ActionEvent e) {
    Rectangle rect;
    count++;
    for(int i=0;i<ocars.size();i++) {
        rect=ocars.get(i);
        if(count%1000==0) {
            speed++;
            if(move<50) {
                move+=10;
        }
        }
        rect.y+=speed;
    }
    for(Rectangle r:ocars) {
        if(r.intersects(car)) {
            
            car.y=r.y+height;
             setVisible(false);
             
        }
    }
    for(int i=0;i<ocars.size();i++) {
        rect=ocars.get(i);
        if(rect.y+rect.height>HEIGHT) {
            ocars.remove(rect);
            addocars(false);
        
        }
    }
    
    
    repaint();
}
    
    public void moveup() {
        if(car.y-move<0) {
            System.out.println("\b");
        }else{
            car.y-=move;
        }
    }
    public void movedown() {
        if(car.y+move+car.height>HEIGHT-1) {  
            System.out.println("\b");
        }else{
            car.y+=move;
        }
    }
    public void moveleft() {
        if(car.x-move<WIDTH/2-90) {  
        System.out.println("\b");
        }else{
            car.x-=move;
        }
    }
    public void moveright() {
        if(car.x+move>WIDTH/2+10) {  
        System.out.println("\b");
        }else{
            car.x+=move;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key=e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_UP:
                moveup();
                break;
            case KeyEvent.VK_DOWN:
                movedown();
                break;
            case KeyEvent.VK_LEFT:
                moveleft();
                break;
            case KeyEvent.VK_RIGHT:
                moveright();
                break;
            default:
                break;
        }
    }
}