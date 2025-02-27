import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JFrame {

    //定义双缓存图片
    Image offScreenImage = null;
    int width = 800,height = 610;
    Image select = Toolkit.getDefaultToolkit().getImage("images/choose.jpg");
    int y = 170;
    int state = 0;//1双人，2单人
    int a = 1;

    int count = 0;
    //敌人数量
    int enemyCount = 0;
    //玩家一
    PlayerOne playerOne = new PlayerOne("images/redu.jpg",125,510,this,"images/redu.jpg","images/redd.jpg","images/redl.jpg","images/redr.jpg");
    //玩家二
    PlayerTwo playerTow = new PlayerTwo("images/redu.jpg",525,510,this,"images/redu.jpg","images/redd.jpg","images/redl.jpg","images/redr.jpg");

    //子弹列表
    ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
    //敌人列表
    ArrayList<Bot> botList = new ArrayList<Bot>();
    ArrayList<Bullet> removeList = new ArrayList<Bullet>();
    //围墙列表
    ArrayList<Wall> wallList = new ArrayList<Wall>();
    //玩家列表
    ArrayList<Tank> playerList = new ArrayList<Tank>();
    //基地列表
    ArrayList<Base> baseList = new ArrayList<Base>();
    //爆炸列表
    ArrayList<Blast> blastList = new ArrayList<Blast>();
    //Base
    Base base =new Base("images/心.png",355,550,this);

    public void launch(){
        setTitle("Game Panel");
        setSize(width,height);
        setLocationRelativeTo(null);//设置窗口居中
        setResizable(false);//用户不能自己调整大小
        setVisible(true);//设置窗口可见
        this.addKeyListener(new GamePanel.KeyMonitor());//添加键盘监视器
        //添加围墙
        for(int i = 0;i < 12;i++){
            wallList.add(new Wall("images/walls.png", i * 70,300,this));
        }
        wallList.add(new Wall("images/walls.png",285,550,this));
        wallList.add(new Wall("images/walls.png",285,481,this));
        wallList.add(new Wall("images/walls.png",355,481,this));
        wallList.add(new Wall("images/walls.png",425,481,this));
        wallList.add(new Wall("images/walls.png",425,550,this));

        //添加心
        baseList.add(base);

        while(true){
            //游戏胜利判定
            if(botList.size() == 0 && enemyCount == 6){
                state = 5;
            }
            //游戏失败判定
            if(playerList.size() == 0 && (state == 1 || state == 2) || baseList.size() == 0){
                state = 4;
            }
            //添加敌人(每绘制100次添加一个敌人)
            if(count % 10 == 1 && enemyCount < 6 && (state == 1 || state == 2)){
                Random random = new Random();
                int rnum = random.nextInt(700);
                botList.add(new Bot("images/greenl.jpg",rnum,150,this,"images/greenu.jpg","images/greend.jpg","images/greenl.jpg","images/greenr.jpg"));
                enemyCount++;
            }
            repaint();
            try{
                Thread.sleep(200);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public void paint(Graphics g){
        System.out.println(bulletList.size());
        //创建和容器一样大小的Image图片
        if(offScreenImage == null){
            offScreenImage = this.createImage(width, height);
        }
        //获取该图片的画笔
        Graphics gImage = offScreenImage.getGraphics();

        gImage.setColor(Color.gray);//设置画笔颜色
        gImage.fillRect(0,0,width,height);
        gImage.setColor(Color.yellow);
        gImage.setFont(new Font("仿宋",Font.BOLD,30));
        if(state == 0){
            gImage.drawString("按1，2键选择游戏模式,按回车键开始游戏",100,100);
            gImage.drawString("1，单人模式",100,200);
            gImage.drawString("2，双人模式",100,300);
            gImage.drawString("保护爱心不被敌方摧毁同时消灭敌方坦克",100,400);
            gImage.drawString("玩家一：ADSW移动,空格射击；",100,450);
            gImage.drawString("玩家二：上下左右键移动，k射击",100,500);
            gImage.drawString("按P键暂停",100,550);
            gImage.drawImage(select,50,y,null);
        }
        else if(state == 1 || state == 2){
            gImage.setFont(new Font("仿宋",Font.BOLD,30));
            gImage.setColor(Color.red);
            gImage.drawString("剩余敌人:" + botList.size(),20,50);
            //绘制游戏元素
            for(Tank player: playerList){
                player.paintSelf(gImage);
            }
            for(Bullet bullet : bulletList){
                bullet.paintSelf(gImage);
            }

            bulletList.removeAll(removeList);

            for(Bot bot : botList){
                bot.paintSelf(gImage);
            }
            for(Wall wall : wallList){
                wall.paintSelf(gImage);
            }
            for(Base base: baseList){
                base.paintSelf(gImage);
            }
            for(Blast blast : blastList){
                blast.paintSelf(gImage);
            }
            //重绘一次
            count++;
        }
        else if(state == 3){
            gImage.drawString("游戏暂停",300,300);
        }
        else if(state == 4){
            gImage.drawString("游戏失败",300,300);
        }
        else if(state == 5){
            gImage.drawString("游戏胜利",300,300);
        }
        g.drawImage(offScreenImage,0,0,null);
    }

    class KeyMonitor extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            //通过switch方法来判断键值
            switch(key){
                case KeyEvent.VK_1:
                    a = 1;
                    y = 170;
                    break;
                case KeyEvent.VK_2:
                    a = 2;
                    y = 270;
                    break;
                case KeyEvent.VK_ENTER:


                    state = a;
                    playerList.add(playerOne);
                    if(state == 2){
                        playerList.add(playerTow);
                        playerTow.alive = true;
                    }
                    playerOne.alive = true;
                    break;
                case KeyEvent.VK_P:
                    if(state != 3){
                        a = state;
                        state = 3;
                    }
                    else {
                        state = a;
                        if(a == 0){
                            a = 1;
                        }
                    }
                default:
                    playerOne.keyPressed(e);
                    playerTow.keyPressed(e);
            }
        }
        public void keyReleased(KeyEvent e) {
            playerOne.keyReleased(e);
            playerTow.keyReleased(e);
        }
    }

    public static void main(String[] args) {
        //循环播放音乐
        String filepath = "music/hdl.wav";
        musicStuff musicObject = new musicStuff();
        musicObject.playMusic(filepath);

        GamePanel gp = new GamePanel();
        gp.launch();
    }
}