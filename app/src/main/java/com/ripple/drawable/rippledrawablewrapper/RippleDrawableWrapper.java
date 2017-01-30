package com.ripple.drawable.rippledrawablewrapper;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.graphics.Palette;

/**
 * Created by
 *
 * @author Mohammed Al-Safwan
 * for NyanRex Developments
 * Contact at :nyanrex52@gmail.com
 */

public class RippleDrawableWrapper {

    private float DEFAULT_ALPHA_FRACTION = 0.5f;
    private float mAlphaFraction;

    public RippleDrawableWrapper() {
        mAlphaFraction = DEFAULT_ALPHA_FRACTION;
    }

    public RippleDrawableWrapper(float alphaFraction) {
        mAlphaFraction = alphaFraction;
    }

    public Drawable getCircularDomColor(Bitmap bm) {
        int color = Palette.from(bm).generate().getVibrantColor(Color.WHITE);
        ColorStateList pressedColor = ColorStateList.valueOf(lightenOrDarken(color, 0.2D));
        ColorDrawable defaultColor = new ColorDrawable(color);
        Drawable rippleColor = getOvalRippleColor(color, bm.getWidth(), bm.getHeight());
        return new RippleDrawable(
                pressedColor,
                null,
                rippleColor
        );
    }

    public Drawable getRecDomColor(Bitmap bm) {
        int color = Palette.from(bm).generate().getVibrantColor(Color.WHITE);
        ColorStateList pressedColor = ColorStateList.valueOf(lightenOrDarken(color, 0.2D));
        ColorDrawable defaultColor = new ColorDrawable(color);
        Drawable rippleColor = getRecRippleColor(color, bm.getWidth(), bm.getHeight());
        return new RippleDrawable(
                pressedColor,
                null,
                rippleColor
        );
    }

    private Drawable getOvalRippleColor(int color, int width, int height) {
//        float[] outerRadii = new float[8];
//        Arrays.fill(outerRadii, 3);
//        RoundRectShape r = new RoundRectShape(outerRadii, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(height);
        shapeDrawable.setIntrinsicWidth(width);
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

    private Drawable getRecRippleColor(int color, int width, int height) {
//        float[] outerRadii = new float[8];
//        Arrays.fill(outerRadii, 3);
//        RoundRectShape r = new RoundRectShape(outerRadii, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.setIntrinsicHeight(height);
        shapeDrawable.setIntrinsicWidth(width);
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

    private int lightenOrDarken(int color, double fraction) {
        if (canLighten(color, fraction)) {
            return lighten(color, fraction);
        } else {
            return darken(color, fraction);
        }
    }

    private int lighten(int color, double fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        red = lightenColor(red, fraction);
        green = lightenColor(green, fraction);
        blue = lightenColor(blue, fraction);
        int alpha = getAlpha(color, mAlphaFraction);
        return Color.argb(alpha, red, green, blue);
    }

    private int darken(int color, double fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        red = darkenColor(red, fraction);
        green = darkenColor(green, fraction);
        blue = darkenColor(blue, fraction);
        int alpha = getAlpha(color, mAlphaFraction);

        return Color.argb(alpha, red, green, blue);
    }

    private int getAlpha(int color, float alpha) {
        return Math.round(Color.alpha(color) * alpha);
    }

    private boolean canLighten(int color, double fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return canLightenComponent(red, fraction)
                && canLightenComponent(green, fraction)
                && canLightenComponent(blue, fraction);
    }

    private boolean canLightenComponent(int colorComponent, double fraction) {
        int red = Color.red(colorComponent);
        int green = Color.green(colorComponent);
        int blue = Color.blue(colorComponent);
        return red + (red * fraction) < 255
                && green + (green * fraction) < 255
                && blue + (blue * fraction) < 255;
    }

    private int darkenColor(int color, double fraction) {
        return (int) Math.max(color - (color * fraction), 0);
    }

    private int lightenColor(int color, double fraction) {
        return (int) Math.min(color + (color * fraction), 255);
    }

}
