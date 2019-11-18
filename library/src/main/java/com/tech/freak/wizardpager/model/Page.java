/*
 * Copyright 2012 Roman Nurik
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tech.freak.wizardpager.model;

import android.os.Bundle;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * Represents a single page in the wizard.
 */
public abstract class Page implements PageTreeNode {
    /**
     * The key into {@link #getData()} used for wizards with simple (single) values.
     */
    public static final String SIMPLE_DATA_KEY = "_";

    protected ModelCallbacks mCallbacks;

    /**
     * Current wizard values/selections.
     */
    protected Bundle mData = new Bundle();
    protected String mTitle;
    @StringRes
    int titleId;
    protected boolean mRequired = false;
    protected String mParentKey;
    protected boolean titleIdSet = false;
    protected String cancelReason = null;

    protected Page(ModelCallbacks callbacks, String title) {
        mCallbacks = callbacks;
        mTitle = title;
    }

    protected Page(ModelCallbacks callbacks, @StringRes int titleId) {
        mCallbacks = callbacks;
        this.titleId = titleId;
    }


    public Bundle getData() {
        return mData;
    }

    public String getTitle() {
        return mTitle;
    }

    public @StringRes
    int getTitleId() {
        return titleId;
    }

    public boolean isRequired() {
        return mRequired;
    }

    void setParentKey(String parentKey) {
        mParentKey = parentKey;
    }

    @Override
    public Page findByKey(String key) {
        return getKey().equals(key) ? this : null;
    }

    @Override
    public void flattenCurrentPageSequence(ArrayList<Page> dest) {
        dest.add(this);
    }

    public abstract Fragment createFragment();

    public String getKey() {

        String titleInput = (mTitle == null) ? "" + titleId : mTitle;

        return (mParentKey != null) ? mParentKey + ":" + titleInput : titleInput;
    }

    public abstract void getReviewItems(ArrayList<ReviewItem> dest);

    public boolean isCompleted() {
        return true;
    }

    public void resetData(Bundle data) {
        mData = data;
        notifyDataChanged();
    }

    public void notifyDataChanged() {
        mCallbacks.onPageDataChanged(this);
    }

    public Page setRequired(boolean required) {
        mRequired = required;
        return this;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    /**
     * This is used just if we want to override default behavior (for example when we enter Page we want prevent any action, until something happens.
     *
     * @return
     */
    public boolean isBackActionPossible() {
        return true;
    }

    /**
     * This is used just if we want to override default behavior (for example when we enter Page we want prevent any action, until something happens.
     *
     * @return
     */
    public boolean isNextActionPossible() {
        return true;
    }


}
