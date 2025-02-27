import java.awt.*;

public abstract class GameObject {
    Image img;

    public int x;
    public int y;
    public GamePanel gamePanel;
    public GameObject(String img, int x, int y, GamePanel gamePanel) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
        this.x = x;
        this.y = y;
        this.gamePanel = gamePanel;
    }

    //参数是一个画布
    public abstract void paintSelf(Graphics g);

    public abstract Rectangle getRec();


}
