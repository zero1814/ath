package org.module.commons.helper;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.module.commons.annotation.Inject;
import org.module.commons.base.BaseClass;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProducerHelper extends BaseClass {

	private static ProducerHelper self;
	@Inject
	private JmsTemplate template;

	public static ProducerHelper getInstance() {
		if (self == null) {
			synchronized (ProducerHelper.class) {
				if (self == null)
					self = new ProducerHelper();
			}
		}
		return self;
	}

	public void sendMessage(Destination destination, final String message) {
		getLogger().logInfo(ProducerHelper.class, "进入Producer发送邮件类:" + this.getClass().getName());
		template.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
		getLogger().logInfo(ProducerHelper.class, "发送完成");
	}
}
