package tn.esprit.spring.service;

import tn.esprit.spring.entities.SmsRequest;

public interface SmsSender {
	public void sendSms(SmsRequest smsRequest);

}
