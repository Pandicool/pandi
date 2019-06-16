package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSV_Reader {

	public static void main(String[] args) {
		String fileName = "us-500.csv";
		List<Us_500> us500 = readCsvFile(fileName);
		
		List<Us_500> A = Sortedlist(us500);
		System.out.println(A);
		for(Us_500 a:A ){
			System.out.println(a.getFirt_name());
		}
		for(Us_500 b: us500){	
			if(b.getCity().contains("Los Angeles"))
					{
						System.out.println(b.getFirt_name()+"     "+b.getLast_name()+"     "+b.getCompany_name());
					}
		}
		

	}
	public CSV_Reader(){
		super();
	}
	public static List<Us_500> Sortedlist(List<Us_500> list)
	{
		for(int i=0;i<list.size();i++)
		{
			for(int j=0;j<list.size();j++)
			{
				if(list.get(i).getFirt_name().compareTo(list.get(j).getLast_name())<0)
				{
					Collections.swap(list,i,j);
				}
					
			}
		}
		return list;
}
	public static List<Us_500> readCsvFile(String fileName){
		List<Us_500> dummy = new ArrayList<>();
		//Path pathFile = Paths.get(fileName); 
		try {
			//BufferedReader br = Files.newBufferedReader(pathFile, StandardCharsets.US_ASCII);
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String a = br.readLine();
			while(a != null) {
				String[] data = a.split(",");
				Us_500 file = create_files(data);
				dummy.add(file);
				a=br.readLine();
				
			}
			br.close();
		} 
		catch (IOException e) {
		
			e.printStackTrace();
		}
		return dummy;
	}
	private static Us_500 create_files(String[] data) {
		String first_name = data[0];
		String last_name = data[1];
		String company_name = data[2];
		String address = data[3];
		String city = data[4];
		String country = data[5];
		String state = data[6];
		String zip = data[7];
		String phone_no1 = data[8];
		String phone_no2 = data[9];
		String e_mail = data[10];
		String web = data[11];
		
		return new Us_500 (first_name.replace("\"", ""),last_name.replace("\"", ""),company_name.replace("\"", ""),address.replace("\"", ""),city.replace("\"", ""),country.replace("\"", ""),state.replace("\"", ""),zip.replace("\"", ""),phone_no1.replace("\"", ""),phone_no2.replace("\"", ""),e_mail.replace("\"", ""),web.replace("\"", ""));
		
	}

}
