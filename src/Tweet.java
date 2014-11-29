import java.util.ArrayList;


public class Tweet {
	int index;
	int numberOfTerms;
	ArrayList<String> listOfTerms;
	
	public Tweet(){
		this.index = 0;
		this.numberOfTerms = 0;
		this.listOfTerms = new ArrayList<String>();
	}
	
	public Tweet(int index, int numberOfTerms, ArrayList<String> listOfTerms) {
		this.index = index;
		this.numberOfTerms = numberOfTerms;
		this.listOfTerms = listOfTerms;
	}
	public String toString(){
		return "Number Of Terms: " + this.numberOfTerms + " Terms: " + this.listOfTerms.toString();
	}
	
	
}

