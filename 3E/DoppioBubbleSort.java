
public class DoppioBubbleSort{

    public static void main(String args[]){
       int[] array = {9,2,7,5,3,1,8,4,6,10};
		stampa(array);
		ordina(array);
		stampa(array);
    }
	
	public static void ordina(int[] array){
		int sentinellaSx = 0;
		int sentinellaDx = array.length-1;
		int temp = 0;
		while(sentinellaSx < sentinellaDx){
			
			for (int i = sentinellaSx; i < sentinellaDx; i++){
				if (array[i] > array[i+1]){
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			} 
			sentinellaDx--;
			
			for (int i = sentinellaDx; i > sentinellaSx; i--){
				if (array[i] < array[i-1]){
					temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
				}
			}
		}
	}
	
	public static void stampa(int[]array){
		System.out.println("\n");
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i]+ " ");
		}
	}
}



