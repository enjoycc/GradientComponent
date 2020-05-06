package cn.cc.gradientlibrary;

/***
 * 该类为颜色处理工具类
 */
public class ColorUtils {


    /**
     * 这是一个简单的色值变暗的方法（色值rgb各加30），应用：按钮按下的颜色
     *
     * @param c 色值
     * @return
     */
    public static int getDarkColors(int c) {
        return (c & 0xff000000)
                + (((c & 0xff0000) - 0x140000) > 0 ? ((c & 0xff0000) - 0x140000) : 0)
                + (((c & 0x00ff00) - 0x001400) > 0 ? ((c & 0x00ff00) - 0x001400) : 0)
                + (((c & 0x0000ff) - 0x000014) > 0 ? ((c & 0x0000ff) - 0x000014) : 0);
    }

    public static int[] getDarkColor(int[] c) {
        if (null == c) return null;
        int[] cs = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            cs[i] = getDarkColors(c[i]);
        }
        return cs;
    }

    /**
     * 给颜色增加透明度，该方法去除原有透明度，使用新的透明度
     *
     * @param color 色值
     * @param alpha 透明度 0：全透明，100：不透明
     * @return
     */
    public static int getAlphaColor(int color, int alpha) {
        float temp = 255 * alpha * 1.0f / 100f;
        alpha = Math.round(temp);
        return (alpha << 24) + (color & 0x00ffffff);
    }

    public static int[] getAlphaColor(int[] c, int alpha) {
        if (null == c) return null;
        int[] cs = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            cs[i] = getAlphaColor(c[i], alpha);
        }
        return cs;
    }

    /**
     * 给颜色增加透明度，该方法在原有透明度上再增加透明度
     *
     * @param color 色值
     * @param alpha 透明度 0：全透明，100：不透明
     * @return
     */
    public static int increaseTransparency(int color, int alpha) {
        int oldAlpha = (color & 0xff000000) >> 24;
        float temp = oldAlpha * alpha * 1.0f / 100f;
        alpha = Math.round(temp);
        return (alpha << 24) + (color & 0x00ffffff);
    }

    public static int[] increaseTransparency(int[] c, int alpha) {
        if (null == c) return null;
        int[] cs = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            cs[i] = increaseTransparency(c[i], alpha);
        }
        return cs;
    }
}
