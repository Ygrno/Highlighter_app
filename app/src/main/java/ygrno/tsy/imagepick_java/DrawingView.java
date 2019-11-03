package ygrno.tsy.imagepick_java;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.util.TypedValue;
import android.view.View;

public class DrawingView extends View {
    private Path drawPath;
    private boolean erase = false;
    private Paint drawPaint, canvasPaint;
    private Canvas drawCanvas;
    private int paintColor = 0xFF660000;
    private Bitmap canvasBitmap;
    private float brushSize,lastBrushSize;

    public DrawingView(Context context) {
        super(context);
        setupDrawing();
    }

    public void startNew(){
        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    public void setErase(boolean isErase){
        erase = isErase;
        if(erase) drawPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        else drawPaint.setXfermode(null);

    }

    public void setBrushSize(float newSize){
        float pixelAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,newSize,getResources().getDisplayMetrics());
        brushSize = pixelAmount;
        drawPaint.setStrokeWidth(brushSize);
    }

}
