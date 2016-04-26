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
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuItem;
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
		setupAnim();
		setSupportActionBar(mToolbar);
		initData();
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mRecyclerView.setAdapter(mAdapter);
		mAdapter.setOnItemClickListener(this);
	}

	private void initData() {
		mItemBeanList = new ArrayList<>();
		mItemBeanList.add(new ItemBean(Color.BLUE, "Simple transition"));
		mItemBeanList.add(new ItemBean(Color.YELLOW, "Visible transition"));
		mItemBeanList.add(new ItemBean(Color.GRAY, "Reveal transition"));
		mItemBeanList.add(new ItemBean(Color.GREEN, "Custom transition"));
		mAdapter = new RecyclerAdapter(mItemBeanList, this);
	}

	@Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position) {
			case 0:
				Intent simpleIntent = new Intent(this, SimpleTransitionActivity.class);
				Pair simplePair =
					new Pair<>(view.findViewById(R.id.item_circle), getString(R.string.transition_circle));
				ActivityOptionsCompat simpleOptions =
					ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, simplePair);
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

	@Override public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private void setupAnim() {
		Fade fade = new Fade();
		getWindow().setExitTransition(fade);
	}
}
