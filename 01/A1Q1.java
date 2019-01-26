public class A1Q1{

	public static int countPositive(double[] anArray){

		int counter = 0;

		for (int i = 0; i<anArray.length; i++){
			if (anArray[i] > 0){
				counter += 1;
			}
		}

		return counter;

	}


}