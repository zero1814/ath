package org.module.mq;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.module.commons.base.BaseTest;
import org.module.mq.helper.ProducerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring.activemq.xml" })
public class ActiveMQTest extends BaseTest {

	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;

	@Test
	public void sendMessage() {
		ProducerHelper.getInstance().sendMessage(destination, "测试");
	}
}