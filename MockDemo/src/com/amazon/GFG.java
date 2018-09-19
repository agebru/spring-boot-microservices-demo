package com.amazon;

public class GFG {

	public static void main(String[] args) {
		Integer arr[] =new Integer[] {32,16,18,40,36};
		
		int k=3;
		findkthHighest(arr,3);
		
	}
	
	//passes
	//k=0 16,32,18,40,12
	// k=1 

	private static void findkthHighest(Integer[] arr, int i) {
		
		for(int k=0;k<arr.length;k++) { //0..4					
			int temp=0;			
			for(int j=0;j<arr.length-k-1;j++) {
				
				if(arr[k]>arr[j]) {
					temp=arr[k];
					arr[k]=arr[k+1];
					arr[k+1]=temp;
				}
				
				
			}
			
			
			
		}
		
		
		int thirdHighest=0;
		for(int k=0;k<arr.length;k++) {
			thirdHighest=arr[2];
			System.out.print(arr[k]+" ");
		}
		
		System.out.println("\n3rd Highest:"+thirdHighest);
		
		
	}
	
	
	

}
