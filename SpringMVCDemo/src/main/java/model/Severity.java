package model;

import javax.validation.ConstraintViolation;
import javax.validation.Payload;

public class Severity {
	public static class Info implements Payload{
		void onInfo(ConstraintViolation violation)
		{
			System.out.println("Violation of Severity level: INFO");
			
		}
	}
	
	public static class Error implements Payload{
		void onError(ConstraintViolation violation)
		{
			System.out.println("Violation of Severity level: Error");
			sendEmail(violation);
		}
	}
	
	public static void sendEmail(ConstraintViolation violation)
	{
		System.out.println("Sending Email to HR"+violation.getMessage());
	}
}
