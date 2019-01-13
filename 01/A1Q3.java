public class A1Q3{
	
	public static int getLongestRun(double[] list){
		if (list.length <= 0){
			return 0;
		}
		int index = 0;
		int longestRun = 1;
		while (index < list.length -1){
			int run = 1;
			while ((index < list.length -1) && (list[index] == list[index +1])){
				run += 1;
				index += 1;
			}
			if (run > longestRun){
				longestRun = run; 
			}
			index += 1;
		}
		return longestRun;
	}

	public static int getLongestRun(String[] list){
		if (list.length <= 0){
			return 0;
		}
		int index = 0;
		int longestRun = 1;
		while (index < list.length -1){
			int run = 1;
			while ((index < list.length -1) && (list[index].equals(list[index+1]))){
				run += 1;
				index += 1; 
			}
			if (run > longestRun){
				longestRun = run; 
			}
			index += 1;
		}
		return longestRun;
	}

}
