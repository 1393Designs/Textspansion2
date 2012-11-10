package com.designs_1393.textspansion2;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

import android.util.Log;

import java.lang.CharSequence;
import java.util.List;

public class TextspansionService extends AccessibilityService
{
	private final String TAG = "TextspansionService";

	@Override
	public void onAccessibilityEvent(AccessibilityEvent event)
	{
		/* getText returns a List of CharSequences */
		List<CharSequence> allTexts = event.getText();

		/* So far, I've only seen a one-element List, so I'll just use that one */
		CharSequence firstText = allTexts.get(0);

		int fromIndex = event.getFromIndex();

		Log.i(TAG, "Text = \"" +firstText +"\"");
		Log.i(TAG, "fromIndex = " +fromIndex);

		if( firstText.charAt(fromIndex) == ' ' )
			Log.i(TAG, "THAT WAS A SPACE");
	}

	@Override
	public void onInterrupt()
	{
	}
}


