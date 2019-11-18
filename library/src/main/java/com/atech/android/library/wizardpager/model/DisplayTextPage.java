package com.atech.android.library.wizardpager.model;

import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.atech.android.library.wizardpager.ui.DisplayTextFragment;
import com.tech.freak.wizardpager.model.ModelCallbacks;
import com.tech.freak.wizardpager.model.Page;
import com.tech.freak.wizardpager.model.ReviewItem;
import com.tech.freak.wizardpager.ui.TextFragment;

import java.util.ArrayList;

public class DisplayTextPage extends Page {

	@StringRes int displayTextId;
	@StyleRes int displayTextStyle;

	public DisplayTextPage(ModelCallbacks callbacks, @StringRes int titleId, @StringRes int displayTextId, @StyleRes int textStyle) {
		super(callbacks, titleId);
		this.displayTextId = displayTextId;
		this.displayTextStyle = textStyle;
	}

	@Override
	public Fragment createFragment() {
		return DisplayTextFragment.create(getKey(), displayTextId, this.displayTextStyle);
	}

	@Override
	public void getReviewItems(ArrayList<ReviewItem> dest) {
	}

	@Override
	public boolean isCompleted() {
		return true;
	}

	public DisplayTextPage setValue(String value) {
		mData.putString(SIMPLE_DATA_KEY, value);
		return this;
	}
}
