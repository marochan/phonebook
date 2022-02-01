package com.phonebook.tests.ui.suite;

import com.phonebook.tests.ui.addNumber.AddNumberNegativeTest;
import com.phonebook.tests.ui.addNumber.AddNumberPositiveTest;
import com.phonebook.tests.ui.deleteNumber.DeleteNumberNegativeTest;
import com.phonebook.tests.ui.deleteNumber.DeleteNumberPositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddNumberPositiveTest.class,
        AddNumberNegativeTest.class,
        DeleteNumberNegativeTest.class,
        DeleteNumberPositiveTest.class
})
public class JUnitTestSuite {
}
