import java.awt.*;
import java.util.ArrayList;

public abstract class Tank extends GameObject{
      //尺寸
    public int width = 70;
    public int height = 79;
    //速度
    public int speed = 15;
    //方向
    public Direction direction = Direction.UP;
    //判断存活
    public boolean alive = false;
    //四个方向的图片
    private String upImg;
    private String downImg;
    private String leftImg;
    private String rightImg;

    //攻击冷却状态
    private boolean attackCoolDown = true;
    //攻击冷却时间
    private int attackCoolDownTime = 1000;

    public Tank(String img, int x, int y, GamePanel gamePanel,String upImg, String downImg, String leftImg, String rightImg) {
        super(img,x,y,gamePanel);
        this.upImg = upImg;
        this.downImg = downImg;
        this.leftImg = leftImg;
        this.rightImg = rightImg;
    }

    public void leftward(){
        if(!hitWall(x - speed, y) && !moveToBorder(x - speed, y)){
            this.x -= speed;
        }
        setImg(leftImg);
        direction = Direction.LEFT;
    }
    public void upward(){
        if(!hitWall(x, y - speed) && !moveToBorder(x, y - speed)){
            y -= speed;
        }
        setImg(upImg);
        direction = Direction.UP;
    }
    public void rightward(){
        if(!hitWall(x + speed, y) && !moveToBorder(x + speed, y)){
            x += speed;
        }

        setImg(rightImg);
        direction = Direction.RIGHT;
    }
    public void downward(){
        if(!hitWall(x, y + speed) && !moveToBorder(x, y + speed)){
            y += speed;
        }
        setImg(downImg);
        direction = Direction.DOWN;
    }

    public void attack(){
        if(attackCoolDown && alive){
            Point p = this.getHeadPoint();
            Bullet bullet = new Bullet("images/shoot.jpg",p.x,p.y,this.gamePanel,direction);
            this.gamePanel.bulletList.add(bullet);
            new AttackCD().start();
        }
    }

    //新线程
    class AttackCD extends Thread{
        public void run(){
            attackCoolDown = false;
            try{
                Thread.sleep(attackCoolDownTime);
            }catch(Exception e){
                e.printStackTrace();
            }
            //将攻击功能解除冷却状态
            attackCoolDown = true;
            //线程终止
            //this.stop();
        }
    }

    public Point getHeadPoint(){
        switch(direction){
            case LEFT:
                return new Point(x - 20,y + height/2 - 10);
            case UP:
                return new Point(x + width / 2 - 10,y - 20);
            case RIGHT:
                return new Point(x + width,y + height / 2 - 10);
            case DOWN:
                return new Point(x + width / 2 - 10,y + height);
            default:
                return null;
        }
    }

    public void setImg(String img){
        this.img = Toolkit.getDefaultToolkit().getImage(img);
    }

    //与围墙碰撞检测
    public boolean hitWall(int x, int y){
        ArrayList<Wall> walls = this.gamePanel.wallList;
        //下一步矩形
        Rectangle next = new Rectangle(x,y,width,height);
        for(Wall wall : walls){
            if(next.intersects(wall.getRec())){
                //发生碰撞返回true
                return true;
            }
        }
        return false;
    }

    //判断边缘出界
    public boolean moveToBorder(int x, int y){
        if(x<0){
            return true;
        }
        else if(x + width>this.gamePanel.getWidth()){
            return true;
        }
        else if(y<0){
            return true;
        }
        else if(y + height>this.gamePanel.getHeight()){
            return true;
        }
        return false;
    }

    public abstract void paintSelf(Graphics g);

    public abstract Rectangle getRec();
}
