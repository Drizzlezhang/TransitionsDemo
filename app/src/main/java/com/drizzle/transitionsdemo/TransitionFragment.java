package com.drizzle.transitionsdemo;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransitionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransitionFragment extends Fragment {
	@Bind(R.id.fragment_circle) ImageView circle;

	public static TransitionFragment newInstance() {
		TransitionFragment fragment = new TransitionFragment();
		return fragment;
	}

	public TransitionFragment() {
		// Required empty public constructor
	}

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Fade fade = new Fade();
		setEnterTransition(fade);
		setExitTransition(fade);
		setReenterTransition(fade);
		setReturnTransition(fade);
		setSharedElementEnterTransition(fade);
	}

	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_transition, container, false);
		ButterKnife.bind(this, view);
		circle.setImageTintList(ColorStateList.valueOf(Color.RED));
		return view;
	}
}
