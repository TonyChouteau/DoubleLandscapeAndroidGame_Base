package fluffy.fluffydroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import fluffy.fluffydroid.R.string;

import static android.content.Context.MODE_PRIVATE;
import static android.provider.Settings.System.getString;

/**
 * Created by rushd on 7/5/2017.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    Context myContext;

    //private CharacterSprite characterSprite;
    Fluffitten Fluffy;

    public GameView(Context context) {
        super(context);

        myContext = context;

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        setFocusable(true);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i("TEST","SurfaceChanged");
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //characterSprite = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.avdgreen));
        Fluffy = new Fluffitten(getWidth()/2, getHeight()/2, getHeight()/4, this);

        thread.setRunning(true);
        thread.start();

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();

            } catch(InterruptedException e){
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }

    /*public void save()
    {
        //SharedPreferences.Editor editor = myContext.getSharedPreferences(R.string.hello, Context.MODE_PRIVATE).edit();
    }*/

    public void update() {
        //characterSprite.update();
        //save();
        Fluffy.update();
    }

    @Override
    public void draw(Canvas canvas)
    {

        super.draw(canvas);
        if(canvas!=null) {
            //characterSprite.draw(canvas);
            Fluffy.draw(canvas);
        }
    }


}







