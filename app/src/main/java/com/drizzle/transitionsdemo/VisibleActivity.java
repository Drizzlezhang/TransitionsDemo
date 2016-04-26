package com.drizzle.transitionsdemo;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class VisibleActivity extends AppCompatActivity {

	@Bind(R.id.visible_fab1) FloatingActionButton fab1;
	@Bind(R.id.visible_fab2) FloatingActionButton fab2;
	@Bind(R.id.visible_fab3) FloatingActionButton fab3;
	@Bind(R.id.visible_fab4) FloatingActionButton fab4;
	@Bind(R.id.visible_circle) ImageView mImageView;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visible);
		ButterKnife.bind(this);
		mImageView.setImageTintList(ColorStateList.valueOf(Color.YELLOW));

		//Explode explode = new Explode();
		//explode.addTarget(fab3);
		//explode.setInterpolator(new DecelerateInterpolator());
		//
		//Slide slide = new Slide(Gravity.BOTTOM);
		//slide.addTarget(fab1);
		//slide.addTarget(fab2);
		//slide.setInterpolator(new BounceInterpolator());
		//
		//Fade fade = new Fade();
		//fade.addTarget(fab4);
		//fade.setInterpolator(new DecelerateInterpolator());
		//
		//TransitionSet set = new TransitionSet();
		//set.addTransition(explode);
		//set.addTransition(slide);
		//set.addTransition(fade);
		ScaleX scaleX = new ScaleX();
		scaleX.addTarget(fab1);
		scaleX.addTarget(fab2);
		scaleX.addTarget(fab3);
		scaleX.addTarget(fab4);
		scaleX.setDuration(10000);

		getWindow().setEnterTransition(scaleX);
		getWindow().setExitTransition(scaleX);
		getWindow().setReenterTransition(scaleX);
		getWindow().setReturnTransition(scaleX);
	}

	@Override public void onBackPressed() {
		super.onBackPressed();
		finishAfterTransition();
	}
}
