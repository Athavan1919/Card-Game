public class A1Q2{

	public static boolean hasLengthTwoRun(double[] anArray){

		boolean checkRun = false;

		for(int i = 0; i<(anArray.length-1); i++){
			
			if (anArray[i] == anArray[i+1]){
				checkRun = true;
				break;
			}

		}

		return checkRun;

	}

}