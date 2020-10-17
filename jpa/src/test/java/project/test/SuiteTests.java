package project.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UserServiceJUnit4Test.class,
    RoleServiceJUnit4Test.class })
public class SuiteTests {
}
