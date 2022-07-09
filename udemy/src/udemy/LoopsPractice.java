package udemy;

public class LoopsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=5;
		String num_of_items="five";
		
		int arr1[]=new int[4];
		arr1[0]=23;
		arr1[1]=24;
		arr1[2]=25;
		arr1[3]=26;
		
		for(int k=0;k<arr1.length;k++) {
			System.out.print("values of array are : ");
			System.out.print(arr1[k]);
			System.out.println();
		}
		
		String arr2[]= {"ranjith","kishore","Ramasatya","Pradeep"};
		System.out.println("displaying string array using regular for loop");
		for(int n=0;n<arr2.length;n++) {
			System.out.println(arr2[n]);
		}
		
		System.out.println("displaying string array using advanced for loop");
		for(String s:arr2) {
			System.out.println(s);
		}
	}

}
