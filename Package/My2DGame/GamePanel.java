package My2DGame;

import Entity.Player;
import Tile.TileManager;

import java.awt.*;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{ // inheritance and data abstraction

    //SCREEN SETTINGS
    final int originalTileSize=16; // 16X16 tile size
    final int scale=3; // the scaling of the original tile size;

    public final int tileSize= originalTileSize*scale; // 48*48 tile (final size)

    public final int maxScreenCol=16; // 16 number of square in a row
    public final int maxScreenRow=12; // 12 number of rows so that the ratio could be 4:3

    public final int ScreenWidth=maxScreenCol*tileSize; // 16*48 =768 pixels
    public final int ScreenHeight=maxScreenRow*tileSize; // 12*48 = 576 pixels

    //WORLD SETTINGS
    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
    public final int worldWidth=maxWorldCol*tileSize;
    public final int worldHeight=maxWorldRow*tileSize;


    TileManager tileM=new TileManager(this);
    KeyHandler keyH=new KeyHandler(); // object for KeyHandler class
    Thread gameThreads;
    public Player player=new Player(this,keyH);

    int FPS=60;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // like flip-book (60 FPS)
        this.addKeyListener(keyH); // the key can be recognised
        this.setFocusable(true);
    }

    // Set the position and speed of the player (default)
    int playerX=100;
    int playerY=100;
    int playerSpeed=4;

    public void StartGameThread()
    {
        gameThreads=new Thread(this);
        gameThreads.start();
    }

    @Override
//    public void run() { // Function from Runnable
//        double drawInterval=1000000000.0/FPS; //0.0166666 SECONDS
//        double nextDrawInterval=System.nanoTime()+drawInterval;
//
//        while (gameThreads != null) {
//            /**Here in this loop we will do two things
//            1) UPDATE: Update information such as 'character positions'*/
//            update();
//            /** 2) DRAW: draw the screen with the updated information*/
//            repaint();
//            try {
//                double remainingTime = nextDrawInterval - System.nanoTime();
//                remainingTime/=1000000;
//                if(remainingTime<0) remainingTime=0;
//                Thread.sleep((long) remainingTime);
//
//                nextDrawInterval+=drawInterval;
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }
//
//    }
    public void run(){
        double drawInterval=1000000000.0/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        long drawCount=0;

        while(gameThreads!=null)
        {
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            timer+=currentTime-lastTime;
            lastTime=currentTime;
            if(delta>0) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer>=1000000000)
            {
                System.out.println("FPS: "+drawCount);
                drawCount=0;
                timer=0;
            }
        }
    }
    /** the movement stuff is handle here in this update block
     * in java
     * to move forward(north) y--
     * move backward(south) y++
     * move right x++
     * move left x--
     */
    public void update()
    {
       player.update();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
