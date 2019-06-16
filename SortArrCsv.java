package com;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortArrCsv {

	public static void main(String[] args) {
		String list ="input.csv";
		List<ListFun> readedList = readCsv(list);
		List<ListFun> Sort =SortArr(readedList);
		for(ListFun a:Sort) {
			System.out.println(a.getF_name());
		}
		for(ListFun b:Sort) {
			if(b.getCity().contains("Los Angeles")) {
				System.out.println(b.getAddress());
			}		
		}
	}

	public static List<ListFun> readCsv(String list) {
		List<ListFun> newlist = new ArrayList<>(); 
		Path Pathtofile = Paths.get(list);
		try {
			//BufferedReader br = Files.newBufferedReader(Pathtofile, StandardCharsets.US_ASCII);
			BufferedReader br = new BufferedReader(new FileReader(list));
			String line = br.readLine();
			while(line != null) {
				String[] a = line.split(",");
				ListFun l = new ListFun(a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7],a[8],a[9],a[10],a[11]);
				newlist.add(l);
				line = br.readLine();
			}
			br.close();	
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return newlist;
	}

	public SortArrCsv() {
		
	}
	public static List<ListFun> SortArr(List<ListFun> list) {
		for(int i=0;i<list.size();i++)
		{
			for(int j=0;j<list.size();j++)
			{
				if(list.get(i).getF_name().compareTo(list.get(j).getF_name())<0)
				{
					Collections.swap(list,i,j);
				}
					
			}
		}
		return list;
	}

}
