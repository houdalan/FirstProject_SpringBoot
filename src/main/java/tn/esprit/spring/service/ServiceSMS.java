package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import tn.esprit.spring.entities.SmsRequest;

@org.springframework.stereotype.Service()
public class ServiceSMS implements SmsSender {
	
	private SmsSender smsSender;

	@Autowired
	public ServiceSMS(@Qualifier("twilio")SmsSender smsSender) {
		this.smsSender = smsSender;
	}
	
	public void sendSms(SmsRequest smsRequest) {
		smsSender.sendSms(smsRequest);
	}

}
