package barnsleyfern;

import java.applet.Applet;
import java.awt.*;

public class BarnsleyFern extends Applet implements Runnable{

    Thread t = null;

    double x = 0;
    double y = 0;
    public void init()
    {
    }

    public void start()
    {
        t = new Thread(this);
        t.start();
    }

    public void run()
    {
        try {

            Graphics g = getGraphics();
            for (int i = 0; i < 200000; i++) {
                double tmpx, tmpy;
                double r = Math.random();

                if (r <= 0.01) {
                    tmpx = 0;
                    tmpy = 0.16 * y;
                } else if (r <= 0.08) {
                    tmpx = 0.2 * x - 0.26 * y;
                    tmpy = 0.23 * x + 0.22 * y + 1.6;
                } else if (r <= 0.15) {
                    tmpx = -0.15 * x + 0.28 * y;
                    tmpy = 0.26 * x + 0.24 * y + 0.44;
                } else {
                    tmpx = 0.85 * x + 0.04 * y;
                    tmpy = -0.04 * x + 0.85 * y + 1.6;
                }
                x = tmpx;
                y = tmpy;

                Color green = new Color(33, 104, 38);
                g.setColor(Color.green);
                g.fillOval((int) Math.round(640 / 2 + x * 640 / 11), (int) Math.round(640 - y * 640 / 11), 2, 2);
                t.sleep(1);
            }
        }

        catch (Exception e)
        {
        }
    }

}