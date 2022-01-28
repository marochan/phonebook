package com.phonebook.tests.suite;

import com.phonebook.tests.base.AddNumberTest;
import com.phonebook.tests.base.DeleteNumberTest;
import com.phonebook.tests.runner.TestRunner;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddNumberTest.class,
        DeleteNumberTest.class
})
public class JUnitTestSuite {
}
