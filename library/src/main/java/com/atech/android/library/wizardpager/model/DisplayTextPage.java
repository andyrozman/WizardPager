package com.atech.android.library.wizardpager.model;

import android.text.TextUtils;

import androidx.fragment.app.Fragment;

import com.tech.freak.wizardpager.model.ModelCallbacks;
import com.tech.freak.wizardpager.model.Page;
import com.tech.freak.wizardpager.model.ReviewItem;
import com.tech.freak.wizardpager.ui.TextFragment;

import java.util.ArrayList;

public class DisplayTextPage extends Page {

	public DisplayTextPage(ModelCallbacks callbacks, String title) {
		super(callbacks, title);
	}

	@Override
	public Fragment createFragment() {
		return TextFragment.create(getKey());
	}

	@Override
	public void getReviewItems(ArrayList<ReviewItem> dest) {
	}

	@Override
	public boolean isCompleted() {
		return !TextUtils.isEmpty(mData.getString(SIMPLE_DATA_KEY));
	}

	public DisplayTextPage setValue(String value) {
		mData.putString(SIMPLE_DATA_KEY, value);
		return this;
	}
}
