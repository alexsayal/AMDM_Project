import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Term {
	String text;
	int numberOfTweets;
	
	public Term(String a,int b) {
		this.text = a;
		this.numberOfTweets = b;	
	}
	public String toString(){
		return this.text + "," + this.numberOfTweets;
	}
	
	// ===== Export ArrayList of Terms ===== //
	public static void writerArrayTerms (String filename, ArrayList<Term> x) throws IOException{
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(filename));
		for (int i = 0; i < x.size(); i++) {
			outputWriter.write(x.get(i).toString());
			outputWriter.newLine();
		}
		outputWriter.flush();  
		outputWriter.close();  
	}

}
