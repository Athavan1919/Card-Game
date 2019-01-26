import java.util.Random;

public class Die {
	
	int dieRoll;
	public static final int MAXVALUE = 6;
	
	Die(){
		Random randNum = new Random();
		dieRoll = randNum.nextInt(6)+1;		
	}
	
	public int getValue() {
		return dieRoll;
	}
	
	public int roll() {
		
		Random randNum = new Random();
		dieRoll = randNum.nextInt(5)+1;	
		return dieRoll;
	}
	
	public String toString() {
		  return "Die" + " {value:" + dieRoll + "}";
	}
	
	public static void main(String[] args) {
		Die d ;
		d = new Die () ;
		System.out.println(d.getValue()) ;
		d.roll() ;
		System.out.println(d.getValue()) ;
		System.out.println(d) ;
	}

}

