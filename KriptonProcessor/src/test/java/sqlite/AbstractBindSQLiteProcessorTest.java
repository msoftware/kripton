package sqlite;

import org.junit.Before;

import base.BaseProcessorTest;

public class AbstractBindSQLiteProcessorTest extends BaseProcessorTest {
	@Before
	public void setup() {
		if (developmentMode) {
			testType = TestType.PREPARE_TEST_ANDROID_LIBRARY;
			destinationPath = PathSourceType.DEST_TEST_ANDROID_LIBRARY;
		} else {
			testType = TestType.NONE;
		}
	}
}
