package fluffy.fluffydroid;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import static android.content.Context.MODE_PRIVATE;

public class Fluffitten
{
    float cx;
    float cy;
    float r;

    float t = 0;

    float x;
    float y;

    GameView gameView;

    public Fluffitten(float newCx, float newCy, float newR, GameView newGameView)
    {
        gameView = newGameView;

        cx = newCx;
        cy = newCy;
        r = newR;
    }

    public void update()
    {
        cx = gameView.getWidth()/2;
        cy = gameView.getHeight()/2;
        r = gameView.getHeight()/4;

        t += 0.01;
        x = cx + (float) Math.cos(t)*r;
        y = cy + (float) Math.sin(t)*r;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }


    public void draw(Canvas canvas)
    {
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        //canvas.drawCircle(x, y, l, p);
        canvas.drawCircle(x,y, 100, p);
    }
}
