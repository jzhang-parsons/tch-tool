package com.tch.tool.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.tch.tool.domain.Bank;
import com.tch.tool.service.TCHToolService;

public class TCHTool {

	public static void main(String[] args) {
		List<Bank> banks = loadBanksFromCVS("ProgrammingAssignment.csv");
        
        TCHToolService service = new TCHToolService(banks);
        
        Scanner scanner = new Scanner (System.in);
        String decision;
        boolean yn = true;
        while(yn){

            System.out.println("Please enter search criteria: ");
            String searchCriteria = scanner.nextLine();
            service.findBanks(searchCriteria);            

            System.out.println("Continue searching? Y/N");
            decision = scanner.nextLine();

            switch(decision.toLowerCase()){
	            case "y":
	                break;
	            case "n": 
	                yn = false;
	                break;
	            default : 
	                System.out.println("Please enter again ");
	                continue;
            }
        }
        
        scanner.close();
	}
	
	private static List<Bank> loadBanksFromCVS(String fileName) {
		List<Bank> banks = new ArrayList<Bank>();
		TCHTool app = new TCHTool();
        InputStream is = app.getFileFromResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        try {

            String line = br.readLine();
            while (line != null) {
                String[] bankInfo = line.split(",");
                Bank bank = createBook(bankInfo);
                if(StringUtils.isNumeric(bank.getId()))
                	banks.add(bank);
                line = br.readLine();
            }

        } catch (IOException ioe) {
        }
		
		return banks;
	}
	
    private static Bank createBook(String[] b) {
        return new Bank(b[0], b[1], b[2], b[3], b[4], b[5]);
    }

    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
}
