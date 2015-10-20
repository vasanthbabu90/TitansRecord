package edu.waa.portal.formatter;

import java.util.Locale;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

import edu.waa.portal.model.Phone;

public class PhoneFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale arg1) {
		return phone.getArea() + "-" + phone.getPrefix() + "-" + phone.getNumber();
	}

	@Override
	public Phone parse(String phoneNum, Locale arg1) throws ParseException {
		System.out.println("I reached here >>>>>>>>>>>>on the formatter");
		Phone phoneNumber = new Phone();
		try {
			int area = Integer.parseInt(phoneNum.substring(0, 3));
			int prefix = Integer.parseInt(phoneNum.substring(3, 6));
			int number = Integer.parseInt(phoneNum.substring(6, 10));
			phoneNumber = new Phone(area, prefix, number);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return phoneNumber;
	}
}
