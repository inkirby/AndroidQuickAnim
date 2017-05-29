import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

public class QuickAnim {

	public static void delay(View v, final long duration, final AnimationListener al) {
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				super.applyTransformation(interpolatedTime, t);
			}
		};
		a.setDuration(duration);
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	private static void changeTextColor(final TextView tv, final int color, final long duration) {
		tv.setVisibility(View.VISIBLE);
		Integer colorFrom = tv.getCurrentTextColor();
		Integer colorTo = color;
		ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
		colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				tv.setTextColor((Integer) animation.getAnimatedValue());
			}
		});
		colorAnimation.setDuration(duration);
		colorAnimation.start();
	}

	public static void changeTextWithFadeAndColor(final TextView tv, final String s, final int color, final long duration, final AnimationListener al) {
		if (tv.getText().toString().equals(s)) {
			changeTextColor(tv, color, duration);
			return;
		}
		tv.setVisibility(View.VISIBLE);
		tv.setAlpha(0f);
		Animation aOut = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				tv.setAlpha(1f - interpolatedTime);
			}
		};
		final Animation aIn = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				tv.setAlpha(interpolatedTime);
			}
		};
		AnimationListener half = new OnAnimationEndListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				tv.setText(s);
				tv.setTextColor(color);
				aIn.setDuration(duration / 2);
				aIn.setAnimationListener(al);
				tv.startAnimation(aIn);
			}
		};
		aOut.setDuration(duration / 2);
		aOut.setAnimationListener(half);
		tv.startAnimation(aOut);
	}

	public static void changeTextWithFadeAndColor(final TextView tv, final String s, boolean ignoreStringMatched, final int color, final long duration, final AnimationListener al) {
		if (tv.getText().toString().equals(s) && !ignoreStringMatched) return;
		tv.setVisibility(View.VISIBLE);
		tv.setAlpha(0f);
		Animation aOut = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				tv.setAlpha(1f - interpolatedTime);
			}
		};
		final Animation aIn = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				tv.setAlpha(interpolatedTime);
			}
		};
		AnimationListener half = new OnAnimationEndListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				tv.setText(s);
				tv.setTextColor(color);
				aIn.setDuration(duration / 2);
				aIn.setAnimationListener(al);
				tv.startAnimation(aIn);
			}
		};
		aOut.setDuration(duration / 2);
		aOut.setAnimationListener(half);
		tv.startAnimation(aOut);
	}

	public static void forceChangeTextWithFade(final TextView tv, final String s, final long duration, final AnimationListener al) {
		tv.setVisibility(View.VISIBLE);
		tv.setAlpha(0f);
		Animation aOut = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				tv.setAlpha(1f - interpolatedTime);
			}
		};
		final Animation aIn = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				tv.setAlpha(interpolatedTime);
			}
		};
		AnimationListener half = new OnAnimationEndListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				tv.setText(s);
				aIn.setDuration(duration / 2);
				aIn.setAnimationListener(al);
				tv.startAnimation(aIn);
			}
		};
		aOut.setDuration(duration / 2);
		aOut.setAnimationListener(half);
		tv.startAnimation(aOut);
	}

	public static void changeTextWithFade(final TextView tv, final SpannableString s, final long duration, final AnimationListener al) {
		if (tv.getText().toString().equals(s.toString())) return;
		tv.setVisibility(View.VISIBLE);
		tv.setAlpha(0f);
		Animation aOut = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				tv.setAlpha(1f - interpolatedTime);
			}
		};
		final Animation aIn = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				tv.setAlpha(interpolatedTime);
			}
		};
		AnimationListener half = new OnAnimationEndListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				tv.setText(s);
				aIn.setDuration(duration / 2);
				aIn.setAnimationListener(al);
				tv.startAnimation(aIn);
			}
		};
		aOut.setDuration(duration / 2);
		aOut.setAnimationListener(half);
		tv.startAnimation(aOut);
	}

	public static void changeTextWithFade(final TextView tv, final String s, final long duration, final AnimationListener al) {
		if (tv.getText().toString().equals(s)) return;
		tv.setVisibility(View.VISIBLE);
		tv.setAlpha(0f);
		Animation aOut = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				tv.setAlpha(1f - interpolatedTime);
			}
		};
		final Animation aIn = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				tv.setAlpha(interpolatedTime);
			}
		};
		AnimationListener half = new OnAnimationEndListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				tv.setText(s);
				aIn.setDuration(duration / 2);
				aIn.setAnimationListener(al);
				tv.startAnimation(aIn);
			}
		};
		aOut.setDuration(duration / 2);
		aOut.setAnimationListener(half);
		tv.startAnimation(aOut);
	}

	public static void changeTextWithXAxisFade(final TextView tv, final String s, final long duration, final float distance, final AnimationListener al) {
		if (tv.getText().toString().equals(s)) return;
		tv.setVisibility(View.VISIBLE);
		tv.setAlpha(0f);
		Animation aOut = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				tv.setAlpha(1f - interpolatedTime);
				tv.setTranslationX(distance * interpolatedTime);
			}
		};
		final Animation aIn = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				tv.setAlpha(interpolatedTime);
				tv.setTranslationX((-distance) * (1f - interpolatedTime));
			}
		};
		AnimationListener half = new OnAnimationEndListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				tv.setText(s);
				aIn.setDuration(duration * 7 / 10);
				aIn.setInterpolator(new DecelerateInterpolator(3f));
				aIn.setAnimationListener(al);
				tv.startAnimation(aIn);
			}
		};
		aOut.setDuration(duration * 3 / 10);
		aOut.setInterpolator(new AccelerateInterpolator(3f));
		aOut.setAnimationListener(half);
		tv.startAnimation(aOut);
	}

	public static void changeImageWithFade(final ImageView v, final Drawable drawable, final long duration, final AnimationListener al) {
		Animation aOut = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				v.setAlpha(1f - interpolatedTime);
			}
		};
		final Animation aIn = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				v.setAlpha(interpolatedTime);
			}
		};
		AnimationListener half = new OnAnimationEndListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				v.setImageDrawable(drawable);
				aIn.setDuration(duration / 2);
				aIn.setAnimationListener(al);
				v.startAnimation(aIn);
			}
		};
		aOut.setDuration(duration / 2);
		aOut.setAnimationListener(half);
		v.startAnimation(aOut);
	}

	public static void changeImageWithFade(final ImageView v, final Bitmap bitmap, final long duration, final AnimationListener al) {
		Animation aOut = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				v.setAlpha(1f - interpolatedTime);
			}
		};
		final Animation aIn = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				v.setAlpha(interpolatedTime);
			}
		};
		AnimationListener half = new OnAnimationEndListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				v.setImageBitmap(bitmap);
				aIn.setDuration(duration / 2);
				aIn.setAnimationListener(al);
				v.startAnimation(aIn);
			}
		};
		aOut.setDuration(duration/2);
		aOut.setAnimationListener(half);
		v.startAnimation(aOut);
	}


	public static void fadeIn(final View v, AnimationListener al) {
		fadeIn(v, 300, 1f, al);
	}

	public static void fadeIn(final View v, final long duration, final float targetAlpha, AnimationListener al) {
//		if (v.getVisibility() == View.VISIBLE && v.getAlpha() == 1f) return;
		v.setVisibility(View.VISIBLE);
		v.setAlpha(0f);
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				v.setAlpha(interpolatedTime * targetAlpha);
			}
		};
		a.setDuration(duration);
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void fadeOut(final View v, final boolean willBeGone, AnimationListener al) {
		fadeOut(v, 300, willBeGone, al);
	}

	public static void fadeOut(final View v, final long duration, final boolean willBeGone, AnimationListener al) {
		v.setVisibility(View.VISIBLE);
		final float startAlpha = v.getAlpha();
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (interpolatedTime == 1) {
					if (willBeGone) {
						v.setVisibility(View.GONE);
					} else {
						v.setVisibility(View.INVISIBLE);
					}
				} else {
					v.setAlpha((1 - interpolatedTime) * startAlpha);
				}
			}
		};
		a.setDuration(duration);
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void fadeTo(final View v, final long duration, final float targetAlpha, AnimationListener al) {
		v.setVisibility(View.VISIBLE);
		final float startAlpha = v.getAlpha();
		final float interpolatingAlpha = targetAlpha - startAlpha;
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				v.setAlpha(startAlpha + interpolatedTime * interpolatingAlpha);
			}
		};
		a.setDuration(duration);
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void slideInXAxisTo(final View v, final long duration, final float translationDestination, final boolean withFade, AnimationListener al) {
		slideInXAxisBy(v, duration, translationDestination - v.getTranslationX(), withFade, al);
	}

	private static void slideInXAxisBy(final View v, final long duration, final float distance, final boolean withFade, AnimationListener al) {
		final float startPos = v.getTranslationX();
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (withFade) v.setAlpha(interpolatedTime);
				v.setTranslationX(startPos + (distance * interpolatedTime));
			}
		};

		a.setDuration(duration);
		a.setInterpolator(new DecelerateInterpolator(3f));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void slideYAxisTo(final View v, final long duration, final float translationDestination, final float toAlpha, AnimationListener al) {
		slideYAxisBy(v, duration, translationDestination - v.getTranslationY(), toAlpha, al);
	}

	private static void slideYAxisBy(final View v, final long duration, final float distance, final float toAlpha, AnimationListener al) {
		final float startPos = v.getTranslationY();
		final float startAlpha = v.getAlpha();
		final float transAlpha = toAlpha-startAlpha;
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				v.setAlpha(startAlpha + (transAlpha*interpolatedTime));
				v.setTranslationY(startPos + (distance * interpolatedTime));
			}
		};

		a.setDuration(duration);
		a.setInterpolator(new DecelerateInterpolator(3f));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void expandViewHeight(final View v, final boolean withFade, AnimationListener al) {
		v.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		final int targetHeight = v.getMeasuredHeight();

		v.getLayoutParams().height = 0;
		v.setVisibility(View.VISIBLE);
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (withFade) v.setAlpha(interpolatedTime);
				v.getLayoutParams().height = interpolatedTime == 1
						? LayoutParams.WRAP_CONTENT
						: (int) Math.ceil(targetHeight * interpolatedTime);
				v.requestLayout();
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		// 1dp/ms
		a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void expandViewHeight(final View v, final long duration, final boolean withFade, AnimationListener al) {
		v.measure(v.getLayoutParams().width, LayoutParams.WRAP_CONTENT);
		final int targetHeight = v.getMeasuredHeight();
		v.getLayoutParams().height = 0;
		v.setVisibility(View.VISIBLE);
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (withFade) v.setAlpha(interpolatedTime);
				v.getLayoutParams().height = interpolatedTime == 1
						? LayoutParams.WRAP_CONTENT
						: (int) Math.ceil(targetHeight * interpolatedTime);
				v.requestLayout();
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		a.setDuration(duration);
		a.setInterpolator(new DecelerateInterpolator(3f));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	private static void expandViewHeightBy(final View v, final int heightPixelToExpand, final boolean withFade, AnimationListener al) {
		final int initHeight = v.getLayoutParams().height;
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (withFade) v.setAlpha(interpolatedTime);
				v.getLayoutParams().height = (int) Math.ceil(heightPixelToExpand * interpolatedTime) + initHeight;
				v.requestLayout();
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		// 1dp/ms
		a.setDuration((int) (heightPixelToExpand / v.getContext().getResources().getDisplayMetrics().density));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	private static void expandViewHeightBy(final View v, final int heightPixelToExpand, final long duration, final boolean withFade, AnimationListener al) {
		final int initHeight = v.getLayoutParams().height;
		v.setVisibility(View.VISIBLE);
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (withFade) v.setAlpha(interpolatedTime);
				v.getLayoutParams().height = (int) Math.ceil(heightPixelToExpand * interpolatedTime) + initHeight;
				v.requestLayout();
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		a.setDuration(duration);
		a.setInterpolator(new DecelerateInterpolator(3f));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void expandViewHeightTo(final View v, final int heightToExpand, final boolean withFade, AnimationListener al) {
		expandViewHeightBy(v, heightToExpand - v.getLayoutParams().height, withFade, al);
	}

	public static void expandViewHeightTo(final View v, final int heightToExpand, final long duration, final boolean withFade, AnimationListener al) {
		expandViewHeightBy(v, heightToExpand - v.getLayoutParams().height, duration, withFade, al);
	}

	public static void collapseViewHeight(final View v, final boolean withFade, AnimationListener al) {
		final int initialHeight = v.getMeasuredHeight();
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (interpolatedTime == 1) {
					if (withFade) v.setAlpha(1);
					v.setVisibility(View.GONE);
				} else {
					if (withFade) v.setAlpha(1 - interpolatedTime);
					v.getLayoutParams().height = initialHeight - (int) Math.ceil(initialHeight * interpolatedTime);
					v.requestLayout();
				}
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		// 1dp/ms
		a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void collapseViewHeight(final View v, final long duration, final boolean withFade, AnimationListener al) {
		final int initialHeight = v.getMeasuredHeight();

		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (interpolatedTime == 1) {
					if (withFade) v.setAlpha(1);
					v.setVisibility(View.GONE);
				} else {
					if (withFade) v.setAlpha(1 - interpolatedTime);
					v.getLayoutParams().height = initialHeight - (int) Math.ceil(initialHeight * interpolatedTime);
					v.requestLayout();
				}
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		a.setDuration(duration);
		a.setInterpolator(new DecelerateInterpolator(3f));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void expandViewWidth(final View v, final long duration, final boolean withFade, AnimationListener al) {
		v.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		final int targetWidth = v.getMeasuredWidth();

		v.getLayoutParams().width = 0;
		v.setVisibility(View.VISIBLE);
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (withFade) v.setAlpha(interpolatedTime);
				v.getLayoutParams().width = interpolatedTime == 1
						? LayoutParams.WRAP_CONTENT
						: (int) Math.ceil(targetWidth * interpolatedTime);
				v.requestLayout();
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		a.setDuration(duration);
		a.setInterpolator(new DecelerateInterpolator(3f));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void collapseViewWidth(final View v, final long duration, final boolean willBeGone, final boolean withFade, AnimationListener al) {
		final int initialWidth = v.getMeasuredWidth();

		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (interpolatedTime == 1) {
					if (withFade) v.setAlpha(1);
					v.setVisibility(willBeGone?View.GONE:View.VISIBLE);
				} else {
					if (withFade) v.setAlpha(1 - interpolatedTime);
					v.getLayoutParams().width = initialWidth - (int) Math.ceil(initialWidth * interpolatedTime);
					v.requestLayout();
				}
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		a.setDuration(duration);
		a.setInterpolator(new DecelerateInterpolator(3f));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	private static void expandViewWidthBy(final View v, final int widthPixelToExpand, final boolean withFade, AnimationListener al) {
		final int initWidth = v.getLayoutParams().width;
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (withFade) v.setAlpha(interpolatedTime);
				v.getLayoutParams().width = (int) Math.ceil(widthPixelToExpand * interpolatedTime) + initWidth;
				v.requestLayout();
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		int duration = (int) (widthPixelToExpand / v.getContext().getResources().getDisplayMetrics().density);
		if (duration<0) duration*=-1;
		a.setDuration(duration);
		a.setInterpolator(new DecelerateInterpolator(3f));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	private static void expandViewWidthBy(final View v, final int widthPixelToExpand, final long duration, final boolean withFade, AnimationListener al) {
		final int initWidth = v.getLayoutParams().width;
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (withFade) v.setAlpha(interpolatedTime);
				v.getLayoutParams().width = (int) Math.ceil(widthPixelToExpand * interpolatedTime) + initWidth;
				v.requestLayout();
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		a.setDuration(duration);
		a.setInterpolator(new DecelerateInterpolator(3f));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void expandViewWidthTo(final View v, final int widthToExpand, final boolean withFade, AnimationListener al) {
		expandViewWidthBy(v, widthToExpand - v.getLayoutParams().width, withFade, al);
	}

	public static void expandViewWidthTo(final View v, final int widthToExpand, final long duration, final boolean withFade, AnimationListener al) {
		expandViewWidthBy(v, widthToExpand - v.getLayoutParams().width, duration, withFade, al);
	}

	public static void scale(final View v, final float scaleSize, AnimationListener al) {
		final float startX = v.getScaleX();
		final float startY = v.getScaleY();
		final float scaleSizeX = scaleSize - startX;
		final float scaleSizeY = scaleSize - startY;
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (interpolatedTime != 1) {
					v.setScaleX(startX + (scaleSizeX * interpolatedTime));
					v.setScaleY(startY + (scaleSizeY * interpolatedTime));
				} else {
					v.setScaleX(scaleSize);
					v.setScaleY(scaleSize);
				}
			}
		};

		a.setDuration(300);
		a.setInterpolator(new DecelerateInterpolator(2.5f));
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void scaleAndFade(final View v, long duration, float scaleXTo, float scaleYTo, final float alpha, AnimationListener al) {
		v.setVisibility(View.VISIBLE);
		final float startX = v.getScaleX();
		final float startY = v.getScaleY();
		final float startA = v.getAlpha();

		final float transX = scaleXTo - startX;
		final float transY = scaleYTo - startY;
		final float transA = alpha - startA;

		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				v.setScaleX(startX + (transX * interpolatedTime));
				v.setScaleY(startY + (transY * interpolatedTime));
				v.setAlpha(startA + (transA * interpolatedTime));
				if (interpolatedTime == 1 && alpha == 0f) {
					v.setVisibility(View.INVISIBLE);
				}
			}
		};

		a.setInterpolator(new DecelerateInterpolator());
		a.setDuration(duration);
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void scaleAndColorTextView(final TextView v, long duration, float sizePixel, int color, AnimationListener al) {
		final float startSize = v.getTextSize();
		final int startColor = v.getCurrentTextColor();
		final int startRed = Color.red(startColor);
		final int startGreen = Color.green(startColor);
		final int startBlue = Color.blue(startColor);

		final float sizeTrans = sizePixel - startSize;
		final int redColorToShift = Color.red(color) - startRed;
		final int greenColorToShift = Color.green(color) - startGreen;
		final int blueColorToShift = Color.blue(color) - startBlue;

		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				int curRed = (int) Math.ceil(startRed + (interpolatedTime * redColorToShift));
				int curGreen = (int) Math.ceil(startGreen + (interpolatedTime * greenColorToShift));
				int curBlue = (int) Math.ceil(startBlue + (interpolatedTime * blueColorToShift));

				v.setTextColor(Color.rgb(curRed, curGreen, curBlue));
				v.setTextSize(TypedValue.COMPLEX_UNIT_PX, startSize + (sizeTrans * interpolatedTime));
			}
		};

		a.setInterpolator(new DecelerateInterpolator());
		a.setDuration(duration);
		a.setAnimationListener(al);
		v.startAnimation(a);
	}

	public static void rotateToDegree(final View v, final float rotation, long duration, AnimationListener al) {
		final float startRotation = v.getRotation();
		final float transitionRotation = rotation - startRotation;
		v.setPivotX(v.getWidth()/2f);
		v.setPivotY(v.getHeight()/2f);

		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				v.setRotation(startRotation+(transitionRotation*interpolatedTime));
			}
		};

		a.setInterpolator(new DecelerateInterpolator(2f));
		a.setDuration(duration);
		a.setAnimationListener(al);
		v.startAnimation(a);
	}
}
