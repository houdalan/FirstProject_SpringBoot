package tn.esprit.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.SmsRequest;
import tn.esprit.spring.service.ServiceSMS;

@RestController
@RequestMapping("api/v1/sms")
public class Controller {
	
	private ServiceSMS serviceSMS;

	@Autowired
	public Controller(ServiceSMS serviceSMS) {
		this.serviceSMS = serviceSMS;
	}
	
	@PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
		serviceSMS.sendSms(smsRequest);
    }
	
	

}
