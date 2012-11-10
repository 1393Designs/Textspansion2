package com.designs_1393.textspansion2;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

import android.util.Log;

import java.lang.CharSequence;
import java.util.List;

public class TextspansionService extends AccessibilityService
{
	private final String TAG = "TextspansionService";
	private final String TARGET = "Kick Out the Epic Motherfu**er";

	@Override
	public void onAccessibilityEvent(AccessibilityEvent event)
	{
		/* getText returns a List of CharSequences */
		List<CharSequence> allTexts = event.getText();

		/* So far, I've only seen a one-element List, so I'll just use that one */
		String firstText = allTexts.get(0).toString();

		int fromIndex = event.getFromIndex();
		int addedCount = event.getAddedCount();

		Log.i(TAG, "Text = \"" +firstText +"\"");
		Log.i(TAG, "fromIndex  = " +fromIndex);
		Log.i(TAG, "addedCount = " +addedCount);

		String lastInsertion = firstText.substring(fromIndex, fromIndex + addedCount);
		Log.i(TAG, "Last word  = \"" +lastInsertion +"\"");


		if( firstText.charAt(fromIndex) == ' ' )
		{
			Log.i(TAG, "THAT WAS A SPACE");
			if( lastInsertion.toLowerCase().equals("kotemf") )
			{
				String newString = firstText.substring(0, fromIndex)
				                   + TARGET
				                   + firstText.substring(fromIndex + addedCount);
				Log.i(TAG, "New string = \"" +newString +"\"");
			}
		}


		Log.i(TAG, "-----\n");
	}

	@Override
	public void onInterrupt()
	{
	}
}


