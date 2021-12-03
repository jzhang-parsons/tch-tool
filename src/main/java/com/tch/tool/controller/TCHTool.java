package com.tch.tool.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.tch.tool.domain.Bank;
import com.tch.tool.service.TCHToolService;


public class TCHTool {

	public static void main(String[] args) {
		List<Bank> banks = loadBanksFromCVS("src/main/resources/ProgrammingAssignment.csv");
//        for (Bank b : banks) {
//            System.out.println(b);
//        }
        
        TCHToolService service = new TCHToolService(banks);
        
        Scanner scanner = new Scanner (System.in);
        String decision;
        boolean yn = true;
        while(yn){

            System.out.println("Please enter search criteria: ");
            String searchCriteria = scanner.nextLine();
            service.findBanks(searchCriteria);            

            System.out.println("Continue searching? yes or no");
            decision = scanner.nextLine();

            switch(decision.toLowerCase()){
	            case "yes":
	                break;
	            case "no": 
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
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

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

}
