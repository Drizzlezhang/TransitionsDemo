package com.drizzle.transitionsdemo;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SimpleTransitionActivity extends AppCompatActivity {
	@Bind(R.id.simple_toolbar) Toolbar toolbar;
	@Bind(R.id.simple_circle) ImageView mImageView;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_transition);
		ButterKnife.bind(this);
		toolbar.setTitle("Simple Transition");
		setSupportActionBar(toolbar);
		mImageView.setImageTintList(ColorStateList.valueOf(Color.BLUE));
	}

	@Override public void onBackPressed() {
		super.onBackPressed();
		finishAfterTransition();
	}
}
