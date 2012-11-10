package com.designs_1393.textspansion2;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

import android.util.Log;

public class TextspansionService extends AccessibilityService
{
	private final String TAG = "TextspansionService";

	@Override
	public void onAccessibilityEvent(AccessibilityEvent event)
	{
		Log.i(TAG, "onAccessibilityEvent - got text changed?");
	}

	@Override
	public void onInterrupt()
	{
	}
}


