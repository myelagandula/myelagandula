package udemy;

import java.util.ArrayList;
import java.util.List;

public class convertStringsToLowerCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String array1[]= {"Mounica","Anoop"};
		for(String s:array1)
		{
			s=s.toLowerCase();
			System.out.println(s);
		}
		
		
		List<String> listArray1= new ArrayList<>();
		listArray1.add("Radha");
		listArray1.add("Krishna");
		listArray1.replaceAll(String::toLowerCase);
		
		System.out.println(listArray1);
		
	}

}
