package cn.cc.gradientlibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;

public class BitmapUtils {

    /***
     * 这个方法用来给bitmap着色
     * @param originalBitmap
     * @param colors
     * @return
     */
    public static Bitmap addGradient(Bitmap originalBitmap, int[] colors) {//给originalBitmap着渐变色
        if (colors == null || colors.length < 1) return originalBitmap;
        if (colors.length == 1) {
            int color = colors[0];
            colors = new int[]{color, color};
        }
        int width = originalBitmap.getWidth();
        int height = originalBitmap.getHeight();
        Canvas canvas = new Canvas(originalBitmap);//Canvas中Bitmap是用来保存像素，相当于画纸
        Paint paint = new Paint();
        LinearGradient shader = new LinearGradient(0, 0, width, height, colors, null, Shader.TileMode.CLAMP);//shader:着色器，线性着色器设置渐变从左上坐标到右下坐标
        paint.setShader(shader);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));//设置图像混合模式
        canvas.drawRect(0, 0, width, height, paint);
        return originalBitmap;
    }

    public static Bitmap getGradientBitmap(Context context, int drawableId, int[] colors) {
        //android不允许直接修改res里面的图片，所以要用copy方法
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), drawableId)
                .copy(Bitmap.Config.ARGB_8888, true);
        addGradient(bitmap, colors);
        return bitmap;
    }

}
