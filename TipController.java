    package com.tip.calc;

import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tip.calc.data.Account;
import com.tip.calc.data.AccountEntity;
import com.tip.calc.data.AccountRepository;

@RestController
public class TipController {
	@Autowired
	private AccountRepository repository;

	@RequestMapping(value = "/save/{amount}/{tipAmount}", method = RequestMethod.POST)
	public String save(@PathVariable String amount, @PathVariable String tipAmount) {
		AccountEntity en = new AccountEntity();
		en.setName("Customer 1");
		en.setMealAmount(amount);
		en.setTipAmount(tipAmount);
		en.setTipTime(new Timestamp(System.currentTimeMillis()));
		try {
			repository.save(en);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Success";

	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Account> get() {
		List<Account> result = new ArrayList<Account>();
		repository.findAll().forEach(acc -> {
			Account ac = new Account();
			ac.setName(acc.getName());
			ac.setMealAmount(acc.getMealAmount());
			ac.setTipAmount(acc.getTipAmount());
			ac.setTipTime(acc.getTipTime().toString());
			result.add(ac);
		});
		return result;
	}
	
	@RequestMapping(value = "/calcTip/{amount}/{tipAmount}", method = RequestMethod.GET) 
		public String calcTip(@PathVariable String amount, @PathVariable String tipAmount) {
			final DecimalFormat df = new DecimalFormat("0.00");
			double total = Double.valueOf(amount) * Double.valueOf(tipAmount);
			df.setRoundingMode(RoundingMode.UP);
			return df.format(total);
	}

	@RequestMapping(value = "/getTip", method = RequestMethod.GET)
	public List<LabelValue> getTip() {
		String day = LocalDate.now().getDayOfWeek().name();
		List<LabelValue> result = new ArrayList<LabelValue>();
		if (day.equals("WEDNESDAY")) {
			LabelValue li = new LabelValue();
			li.setId(0.25);
			li.setName("25 % - Great");
			result.add(li);
			LabelValue li2 = new LabelValue();
			li2.setId(0.20);
			li2.setName("20 % - Met expectations");
			result.add(li2);
			LabelValue li3 = new LabelValue();
			li3.setId(0.15);
			li3.setName("15 % - Below expectations");
			result.add(li3);
			
		} else {
			
			LabelValue li2 = new LabelValue();
			li2.setId(0.2);
			li2.setName("20 % - Great");
			result.add(li2);
			LabelValue li3 = new LabelValue();
			li3.setId(0.15);
			li3.setName("15 % - Met expectations");
			result.add(li3);
			LabelValue li4 = new LabelValue();
			li4.setId(0.1);
			li4.setName("10 % - Below expectations");
			result.add(li4);
		}

		return result;

	}
}
    
