package com.evgenii.jsevaluatortests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.TextView;

public class RealLibraryTests extends ActivityInstrumentationTestCase2<RealLibrary> {

	private RealLibrary mActivity;

	public RealLibraryTests() {
		super(RealLibrary.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();
	}

	@MediumTest
	public void testEvaluate() throws InterruptedException {
		final TextView resultTextView = (TextView) mActivity
				.findViewById(R.id.realLibraryResultView);

		final String expectedResult = "Result: jQuery is working!";

		for (int i = 0; i < 100; i++) {
			Thread.sleep(100);
			if (resultTextView.getText().equals(expectedResult)) {
				break;
			}
		}
		assertEquals(expectedResult, resultTextView.getText());
	}

	public void testPreconditions() {
		assertNotNull("mActivity is null", mActivity);
	}
}