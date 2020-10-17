package project.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:/config.xml")
public abstract class BaseJUnit4Test extends AbstractTransactionalJUnit4SpringContextTests {
}
