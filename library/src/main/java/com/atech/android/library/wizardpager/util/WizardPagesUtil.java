package com.atech.android.library.wizardpager.util;

import android.view.View;
import android.widget.TextView;

import com.tech.freak.wizardpager.model.Page;

public class WizardPagesUtil {

    public static void setTitle(Page page, View rootView) {

        if (page.getTitle() != null)
            ((TextView) rootView.findViewById(android.R.id.title)).setText(page.getTitle());
        else
            ((TextView) rootView.findViewById(android.R.id.title)).setText(page.getTitleId());

    }


}
