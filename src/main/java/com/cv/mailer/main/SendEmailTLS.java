package com.cv.mailer.main;

import java.util.List;

public class SendEmailTLS {

	public static int counter;
	
	public static void main(String[] args) {
		
		MailConfig mailConfig = new MailConfig(); 
		SaveCounter count = new SaveCounter();
		List<String> listOfMails = new GetEmails().getEmailList();
				
		
		for(int i = count.getCounter(); i < listOfMails.size(); i++){
			mailConfig.sendMail(listOfMails.get(i));
			counter++;
			count.save(i);
		}
		
		System.out.println(counter);
			
	}

}
