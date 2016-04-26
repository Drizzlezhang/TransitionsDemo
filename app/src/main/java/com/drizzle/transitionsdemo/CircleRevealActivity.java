package com.drizzle.transitionsdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import butterknife.Bind;
import butterknife.ButterKnife;

public class CircleRevealActivity extends AppCompatActivity {
	@Bind(R.id.toolbar) Toolbar mToolbar;
	@Bind(R.id.fab) FloatingActionButton mFab;
	@Bind(R.id.container) FrameLayout container;
	@Bind(R.id.fab2) FloatingActionButton mFab2;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_circle_reaval);
		ButterKnife.bind(this);
		mToolbar.setTitle("CircleRevealAnim");
		setSupportActionBar(mToolbar);
		mFab.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				mFab.animate()
					.scaleX(0F)
					.scaleY(0F)
					.setInterpolator(new DecelerateInterpolator())
					.setListener(new AnimatorListenerAdapter() {
						@Override public void onAnimationEnd(Animator animation) {
							animFirst();
							mFab.setVisibility(View.GONE);
							animation.removeListener(this);
							mFab.clearAnimation();
						}
					});
			}
		});
		mFab2.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				mFab2.animate()
					.scaleX(0F)
					.scaleY(0F)
					.setInterpolator(new DecelerateInterpolator())
					.setListener(new AnimatorListenerAdapter() {
						@Override public void onAnimationEnd(Animator animation) {
							animSecond();
							mFab2.setVisibility(View.GONE);
							animation.removeListener(this);
							mFab2.clearAnimation();
							mFab.clearAnimation();
						}
					});
			}
		});
	}

	private void animFirst() {
		int centerX = (mFab.getLeft() + mFab.getRight()) / 2;
		int centerY = (mFab.getTop() + mFab.getBottom()) / 2;
		float totalRadius = (float) Math.hypot((double) centerX, (double) centerY);
		final Animator mRevealAnim =
			ViewAnimationUtils.createCircularReveal(container, centerX, centerY, 0, totalRadius);
		mRevealAnim.addListener(new AnimatorListenerAdapter() {
			@Override public void onAnimationStart(Animator animation) {
				container.setVisibility(View.VISIBLE);
			}

			@Override public void onAnimationEnd(Animator animation) {
				mRevealAnim.removeListener(this);
				mFab2.setVisibility(View.VISIBLE);
				mFab2.animate()
					.scaleX(1F)
					.scaleY(1F)
					.setInterpolator(new DecelerateInterpolator())
					.setListener(new AnimatorListenerAdapter() {
						@Override public void onAnimationEnd(Animator animation) {
						}
					});
				container.clearAnimation();
			}
		});
		mRevealAnim.start();
	}

	private void animSecond() {
		int centerX = (mFab.getLeft() + mFab.getRight()) / 2;
		int centerY = (mFab.getTop() + mFab.getBottom()) / 2;
		float totalRadius = (float) Math.hypot((double) centerX, (double) centerY);
		final Animator backAnim = ViewAnimationUtils.createCircularReveal(container, centerX, centerY, totalRadius, 0);
		backAnim.addListener(new AnimatorListenerAdapter() {
			@Override public void onAnimationEnd(Animator animation) {
				mFab.setVisibility(View.VISIBLE);
				container.setVisibility(View.INVISIBLE);
				mFab.animate()
					.scaleX(1F)
					.scaleY(1F)
					.setInterpolator(new DecelerateInterpolator())
					.setListener(new AnimatorListenerAdapter() {
						@Override public void onAnimationEnd(Animator animation) {
						}
					});
				animation.removeListener(this);
				container.clearAnimation();
			}
		});
		backAnim.start();
	}
}

