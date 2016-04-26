package com.drizzle.transitionsdemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by drizzle on 16/4/26.
 */
public class ScaleX extends Visibility {

	private Animator createAnimator(View view, float start, float end) {
		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "scaleX", start, end);
		return objectAnimator;
	}

	@Override
	public Animator onAppear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
		return createAnimator(view, 0F, 1F);
	}

	@Override public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues,
		TransitionValues endValues) {
		return createAnimator(view, 1F, 0F);
	}
}
