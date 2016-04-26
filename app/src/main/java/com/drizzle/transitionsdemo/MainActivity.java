package com.drizzle.transitionsdemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
	@Bind(R.id.recycler_view) RecyclerView mRecyclerView;
	@Bind(R.id.fab) FloatingActionButton mFab;
	@Bind(R.id.toolbar) Toolbar mToolbar;
	private RecyclerAdapter mAdapter;
	private List<ItemBean> mItemBeanList;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		setSupportActionBar(mToolbar);
		initData();
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mRecyclerView.setAdapter(mAdapter);
		mAdapter.setOnItemClickListener(this);
	}

	private void initData() {
		mItemBeanList = new ArrayList<>();
		mItemBeanList.add(new ItemBean(Color.BLUE, "Simple Transition"));
		mItemBeanList.add(new ItemBean(Color.YELLOW, "Visible transition"));
		mItemBeanList.add(new ItemBean(Color.GRAY, "Reveal transition"));
		mAdapter = new RecyclerAdapter(mItemBeanList, this);
	}

	@Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position) {
			case 0:
				Intent simpleIntent = new Intent(this, SimpleTransitionActivity.class);
				//Pair simplePair =
				//	new Pair<>(view.findViewById(R.id.item_circle), getString(R.string.transition_circle));
				Pair secondPair = new Pair<>(view.findViewById(R.id.item_title), getString(R.string.transition_title));
				ActivityOptionsCompat simpleOptions =
					ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, secondPair);
				ActivityCompat.startActivity(MainActivity.this, simpleIntent, simpleOptions.toBundle());
				break;
			case 1:
				Intent visibleIntent = new Intent(this, VisibleActivity.class);
				Pair visiblePair =
					new Pair<>(view.findViewById(R.id.item_circle), getString(R.string.transition_circle));
				ActivityOptionsCompat visibleOptions =
					ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, visiblePair);
				ActivityCompat.startActivity(MainActivity.this, visibleIntent, visibleOptions.toBundle());
				break;
			case 2:
				Intent revealIntent = new Intent(this, CircleRevealActivity.class);
				startActivity(revealIntent);
				break;
			case 3:

				break;
			default:
				break;
		}
	}
}
