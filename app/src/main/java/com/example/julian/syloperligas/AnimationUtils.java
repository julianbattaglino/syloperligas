package com.example.julian.syloperligas;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;
import com.tumblr.backboard.performer.Performer;

/**
 * Created by Mariano Salvetti and Raul Striglio on 21-01-2016.
 */
public class AnimationUtils {
    static SpringConfig springConfig = SpringConfig.fromOrigamiTensionAndFriction(40, 7);


    public static void setCount(final TextView t, int count, final String append) {
        Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(0);
        s.addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                super.onSpringUpdate(spring);
                t.setText((int) spring.getCurrentValue() + append);
            }
        });
        s.setEndValue(count);
    }

    public static Spring enterBottom(final View v, final int time) {

        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(500);
        s.addListener(new SpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {

                float mappedValue = (float) SpringUtil.mapValueFromRangeToRange(spring.getCurrentValue(), 1, 0, 1, 0.5);
                ViewCompat.setAlpha(v, 500f - Float.parseFloat(String.valueOf(spring.getCurrentValue())));
                ViewCompat.setTranslationY(v, mappedValue);
            }

            @Override
            public void onSpringAtRest(Spring spring) {

            }

            @Override
            public void onSpringActivate(Spring spring) {

            }

            @Override
            public void onSpringEndStateChange(Spring spring) {

            }
        });
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(0);
            }
        }, time);
        return s;
    }

    public static void rotateX(final View v, final int time) {
        v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(0);
        s.addListener(new Performer(v, View.ROTATION_X));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(360);
            }
        }, time);

    }

    public static void landMeY(final View v, final int time) {
        v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(1, 2));
        s.setCurrentValue(0);


        s.addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                super.onSpringUpdate(spring);
                ViewCompat.setRotationY(v, 5 * (float) Math.sin(spring.getCurrentValue() * Math.PI / 2));
            }

            @Override
            public void onSpringAtRest(Spring spring) {
                super.onSpringAtRest(spring);
                ViewCompat.setRotation(v, 0);
            }
        });
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(4);
            }
        }, time);

    }

    public static void landMeX(final View v, final int time) {
        v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(1, 2));
        s.setCurrentValue(0);
        s.addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                super.onSpringUpdate(spring);
                //ViewCompat.setTranslationY(v, 100 * (float) Math.sin(spring.getCurrentValue()));
                ViewCompat.setRotationX(v, 10 * (float) Math.sin(spring.getCurrentValue() * Math.PI / 2));
            }

            @Override
            public void onSpringAtRest(Spring spring) {
                super.onSpringAtRest(spring);
                //ViewCompat.setRotation(v, 0)
            }
        });
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(4);
            }
        }, time);
    }

    public static void landMe(final View v, final int time) {
        v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        // s.setSpringConfig(SpringConfig.fromBouncinessAndSpeed(10, 2));
        s.setCurrentValue(0);
        s.addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                super.onSpringUpdate(spring);
                ViewCompat.setRotation(v, 10 * (float) Math.sin(spring.getCurrentValue() * Math.PI / 2));
            }

            @Override
            public void onSpringAtRest(Spring spring) {
                super.onSpringAtRest(spring);
            }
        });
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(4);
            }
        }, time);

    }


    public static Spring showMe(final View v, final int time) {
        v.setVisibility(View.INVISIBLE);
        ViewCompat.setAlpha(v, 0);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(0);
        s.addListener(new Performer(v, View.ALPHA));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(1);
            }
        }, time);
        return s;
    }

    public static Spring hideMe(final View v, final int time) {
        //v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(1);
        s.addListener(new Performer(v, View.ALPHA));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                // v.setVisibility(View.VISIBLE);
                s.setEndValue(0);
            }
        }, time);
        return s;
    }


    public static void rotateXwithColor(final View v, final int color, final int time) {
        // v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(SpringConfig.fromBouncinessAndSpeed(5, 5));
        s.setCurrentValue(0);
        s.addListener(new Performer(v, View.ROTATION_X));
        s.addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                super.onSpringUpdate(spring);
                if (spring.getCurrentValue() > 300.0) {
                    if (v instanceof TextView) {
                        ((TextView) v).setTextColor(color);
                    }
                    if (v instanceof EditText) {
                        ((EditText) v).setTextColor(color);
                    }
                }
            }
        });
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                //v.setVisibility(View.VISIBLE);
                s.setEndValue(360);
            }
        }, time);

    }

    public static void rotateY(final View v, final int time) {
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(0);
        s.addListener(new Performer(v, View.ROTATION_Y));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(360);
            }
        }, time);

    }

    public static void rotateClockWise(final View v, final int time) {
        v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(0);
        s.addListener(new Performer(v, View.ROTATION));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(360);
            }
        }, time);
    }

    public static void rotateClockWiseVisible(final View v, final int time) {
        //v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(SpringConfig.fromBouncinessAndSpeed(5, 5));
        s.setCurrentValue(0);
        s.addListener(new Performer(v, View.ROTATION));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                //v.setVisibility(View.VISIBLE);
                s.setEndValue(360);
            }
        }, time);
    }

    public static Spring getrotateClockWise(final View v, final int time) {
        v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(0);
        s.addListener(new Performer(v, View.ROTATION));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(time);
            }
        }, 0);
        return s;

    }

    public static void rotateAntiClockWise(final View v, final int time) {
        v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(360);
        s.addListener(new Performer(v, View.ROTATION));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(0);
            }
        }, time);

    }

    public static Spring enterTop(final View v, final int time) {
        v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(-500);
        s.addListener(new Performer(v, View.TRANSLATION_Y));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(0);
            }
        }, time);
        return s;
    }

    public static void enterLeft(final View v, final int time) {
        v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(-500);
        s.addListener(new Performer(v, View.TRANSLATION_X));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(0);
            }
        }, time);

    }

    public static void enterRight(final View v, final int time) {
        v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(500);
        s.addListener(new Performer(v, View.TRANSLATION_X));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(0);
            }
        }, time);

    }

    public static void popIn(final View v, int time) {
        v.setVisibility(View.VISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(1);
        s.addListener(new Performer(v, View.SCALE_X)).addListener(new Performer(v, View.SCALE_Y));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                s.setEndValue(0);
            }
        }, time);
    }

    public static void popOut(final View v, int time) {
        v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(0);
        s.addListener(new Performer(v, View.SCALE_X)).addListener(new Performer(v, View.SCALE_Y));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(1);
            }
        }, time);
    }


    public static Spring getscaleOut(final View v, final int count) {
        v.setVisibility(View.INVISIBLE);
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(springConfig);
        s.setCurrentValue(0);
        s.addListener(new Performer(v, View.SCALE_X)).addListener(new Performer(v, View.SCALE_Y));
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(View.VISIBLE);
                s.setEndValue(count);
            }
        }, 0);
        return s;
    }

    public static Spring makeRoundCorner(final View v, final int color, final int radius, int time) {
        final Spring s = SpringSystem.create().createSpring();
        s.setSpringConfig(SpringConfig.fromBouncinessAndSpeed(15, 55));
        s.setCurrentValue(0);
        s.addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                super.onSpringUpdate(spring);
                makeRoundCorner(color, (int) spring.getCurrentValue(), v, 0, Color.TRANSPARENT);
            }

            @Override
            public void onSpringAtRest(Spring spring) {
                super.onSpringAtRest(spring);

            }
        });
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                s.setEndValue(radius);
            }
        }, time);
        return s;
    }


    private static void makeRoundCorner(int bgcolor, int radius, View v, int strokeWidth, int strokeColor) {

        GradientDrawable gdDefault = new GradientDrawable();
        gdDefault.setColor(bgcolor);
        gdDefault.setCornerRadius(radius);
        gdDefault.setStroke(strokeWidth, strokeColor);
        v.setBackgroundDrawable(gdDefault);
    }


    public static Spring changeBound(final Context context, final View v, final int width, int time) {
        final Spring sw = SpringSystem.create().createSpring();
        sw.setSpringConfig(SpringConfig.fromBouncinessAndSpeed(15, 55));
        sw.setCurrentValue(0);

        if (v.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) v.getLayoutParams();

            sw.setCurrentValue((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, context.getResources().getDisplayMetrics()));

            sw.addListener(new SimpleSpringListener() {
                @Override
                public void onSpringUpdate(Spring spring) {
                    super.onSpringUpdate(spring);
                    params.width = (int) spring.getCurrentValue();
                    // params.height = (int) spring.getCurrentValue();
                    v.setLayoutParams(params);
                }

            });
        } else if (v.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            final LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) v.getLayoutParams();

            sw.setCurrentValue((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, context.getResources().getDisplayMetrics()));

            sw.addListener(new SimpleSpringListener() {
                @Override
                public void onSpringUpdate(Spring spring) {
                    super.onSpringUpdate(spring);
                    params.width = (int) spring.getCurrentValue();
                    // params.height = (int) spring.getCurrentValue();
                    v.setLayoutParams(params);
                }

            });
        } else if (v.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            final FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) v.getLayoutParams();

            sw.setCurrentValue((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, context.getResources().getDisplayMetrics()));

            sw.addListener(new SimpleSpringListener() {
                @Override
                public void onSpringUpdate(Spring spring) {
                    super.onSpringUpdate(spring);
                    params.width = (int) spring.getCurrentValue();
                    //params.height = (int) spring.getCurrentValue();
                    v.setLayoutParams(params);
                }

            });
        }


        v.postDelayed(new Runnable() {
            @Override
            public void run() {

                sw.setEndValue((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, context.getResources().getDisplayMetrics()));

            }
        }, time);
        return sw;
    }

    public static Spring changeBoundHeight(final Context context, final View v, final int width, int time) {
        final Spring sw = SpringSystem.create().createSpring();
        sw.setSpringConfig(SpringConfig.fromBouncinessAndSpeed(15, 55));
        sw.setCurrentValue(0);

        if (v.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) v.getLayoutParams();

            sw.setCurrentValue((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, context.getResources().getDisplayMetrics()));

            sw.addListener(new SimpleSpringListener() {
                @Override
                public void onSpringUpdate(Spring spring) {
                    super.onSpringUpdate(spring);
                    // params.width = (int) spring.getCurrentValue();
                    params.height = (int) spring.getCurrentValue();
                    v.setLayoutParams(params);
                }

            });
        } else if (v.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            final LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) v.getLayoutParams();

            sw.setCurrentValue((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, context.getResources().getDisplayMetrics()));

            sw.addListener(new SimpleSpringListener() {
                @Override
                public void onSpringUpdate(Spring spring) {
                    super.onSpringUpdate(spring);
                    //params.width = (int) spring.getCurrentValue();
                    params.height = (int) spring.getCurrentValue();
                    v.setLayoutParams(params);
                }

            });
        } else if (v.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            final FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) v.getLayoutParams();

            sw.setCurrentValue((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, context.getResources().getDisplayMetrics()));

            sw.addListener(new SimpleSpringListener() {
                @Override
                public void onSpringUpdate(Spring spring) {
                    super.onSpringUpdate(spring);
                    //params.width = (int) spring.getCurrentValue();
                    params.height = (int) spring.getCurrentValue();
                    v.setLayoutParams(params);
                }

            });
        }


        v.postDelayed(new Runnable() {
            @Override
            public void run() {

                sw.setEndValue((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, context.getResources().getDisplayMetrics()));

            }
        }, time);
        return sw;
    }


    public static float hypo(float a, float b) {
        return (float) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}
