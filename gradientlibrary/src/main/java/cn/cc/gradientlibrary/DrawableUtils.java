package cn.cc.gradientlibrary;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

import static android.graphics.drawable.GradientDrawable.Orientation.TL_BR;

public class DrawableUtils {

    public static BitmapDrawable getBitmapDrawable(Context context, int drawableId, int[] themeColor) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapUtils.getGradientBitmap(context, drawableId, themeColor));
        return bitmapDrawable;
    }

    public static Drawable getDrawable(int color, int cornerRadius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(cornerRadius);//设置4个角的弧度
        drawable.setColor(color);// 设置颜色
        return drawable;
    }

    public static Drawable getDrawable(Drawable enableDrawable, Drawable focusedDrawable, Drawable disableDrawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed}, focusedDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, focusedDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, enableDrawable);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled,}, disableDrawable);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled, android.R.attr.state_pressed}, disableDrawable);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled, android.R.attr.state_focused}, disableDrawable);
        stateListDrawable.addState(new int[]{}, enableDrawable);
        return stateListDrawable;
    }

    public static Drawable getSelectDrawable(Drawable enableDrawable, Drawable selectedDrawable, Drawable disableDrawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_selected, android.R.attr.state_checked}, selectedDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_selected, -android.R.attr.state_checked}, selectedDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, -android.R.attr.state_selected, android.R.attr.state_checked}, selectedDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, -android.R.attr.state_selected, -android.R.attr.state_checked}, enableDrawable);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled, android.R.attr.state_selected, android.R.attr.state_checked}, disableDrawable);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled, android.R.attr.state_selected, -android.R.attr.state_checked}, disableDrawable);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled, -android.R.attr.state_selected, android.R.attr.state_checked}, disableDrawable);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled, -android.R.attr.state_selected, -android.R.attr.state_checked}, disableDrawable);
        return stateListDrawable;
    }

    public static Drawable getGradientButtonDrawable(Context context, int[] colors) {
        if (colors == null || colors.length < 1) {
            return context.getResources().getDrawable(R.drawable.button_bg);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawableN = new GradientDrawable();
        gradientDrawableN.setCornerRadius(100);
        gradientDrawableN.setOrientation(TL_BR);
        gradientDrawableN.setColors(colors);
        GradientDrawable gradientDrawableP = new GradientDrawable();
        gradientDrawableP.setCornerRadius(100);
        gradientDrawableP.setOrientation(TL_BR);
        gradientDrawableP.setColors(ColorUtils.getDarkColors(colors));
        GradientDrawable gradientDrawableD = new GradientDrawable();
        gradientDrawableD.setCornerRadius(100);
        gradientDrawableD.setOrientation(TL_BR);
        gradientDrawableD.setColors(ColorUtils.getAlphaColor(colors, 20));
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed}, gradientDrawableP);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, gradientDrawableP);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, gradientDrawableN);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled,}, gradientDrawableD);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled, android.R.attr.state_pressed}, gradientDrawableD);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled, android.R.attr.state_focused}, gradientDrawableD);
        stateListDrawable.addState(new int[]{}, gradientDrawableN);
        return stateListDrawable;
    }
}
