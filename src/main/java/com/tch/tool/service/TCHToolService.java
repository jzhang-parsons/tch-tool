package com.tch.tool.service;

import java.util.ArrayList;
import java.util.List;

import com.tch.tool.domain.Bank;

public class TCHToolService {
	private List<Bank> banks = null;

	public TCHToolService(List<Bank> banks) {
		this.banks = banks;
	}
	
	public void findBanks(String searchCriteria) {
		List<Bank> searchResult = new ArrayList<Bank>();

		if(banks != null && !banks.isEmpty())
		{
			if(searchCriteria.equalsIgnoreCase("all"))
			{
				searchResult = banks;
			}else {
				String[] s = searchCriteria.split(",");
	            switch(s.length){
		            case 1: //By Zip code or State or City or Type or Bank Name
		            	String search = s[0].strip().toLowerCase();
		    	        for (Bank b : banks) {
		    	        	if(b.getBankName().toLowerCase().contains(search) || b.getType().toLowerCase().contains(search)
		    	        	   || b.getCity().toLowerCase().contains(search) || b.getState().toLowerCase().contains(search)
		    	        	   || b.getZipCode().contains(search))
		    	        	{
		    	        		searchResult.add(b);
		    	        	}
		    	        }
		                break;
		            case 2: //By City & State
		            	String city = s[0].strip();
		            	String state = s[1].strip();
		    	        for (Bank b : banks) {
		    	        	if(b.getCity().equalsIgnoreCase(city) && b.getState().equalsIgnoreCase(state))
		    	        	{
		    	        		searchResult.add(b);
		    	        	}
		    	        }		            	
		                break;
	            }
            }
		}
		
		if(!searchResult.isEmpty())
		{
	        for (Bank b : searchResult) {
	            System.out.println(b);
	        }
		}else {
			System.out.println("No record found.");
		}
		
		return;
	}

}
