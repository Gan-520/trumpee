import java.awt.*;
import java.util.Random;

public class Bot extends Tank {

    int moveTime = 0;
    public Bot(String img, int x, int y, GamePanel gamePanel, String upImg, String downImg, String leftImg, String rightImg) {
        super(img, x, y, gamePanel, upImg, downImg, leftImg, rightImg);
    }

    public Direction getRandomDirection() {
        Random random = new Random();
        int rnum = random.nextInt(4);
        switch (rnum) {
            case 0:
                return Direction.LEFT;
            case 1:
                return Direction.RIGHT;
            case 2:
                return Direction.UP;
            case 3:
                return Direction.DOWN;
            default:
                return null;
        }
    }

    public void go(){
        attack();
        if(moveTime >= 10){
            direction = getRandomDirection();
            moveTime = 0;
        }
        else{
            moveTime++;
        }
        switch(direction){
            case LEFT:
                leftward();
                break;
            case RIGHT:
                rightward();
                break;
            case UP:
                upward();
                break;
            case DOWN:
                downward();
                break;

        }
    }

    public void attack(){
        Point p = getHeadPoint();
        Random random = new Random();
        int rnum = random.nextInt(100);
        if(rnum < 20){
            this.gamePanel.bulletList.add(new EnemyBullet("images/shoot.jpg",p.x,p.y,this.gamePanel,direction));
        }
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
        go();
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}
