import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class DataBuff {

	LineNumberReader buffer;
	
	public DataBuff(String path) throws FileNotFoundException {
		buffer = new LineNumberReader(new FileReader(path));
	}
	
	public Tweet getNextTweet() throws IOException{
		ArrayList<String> listOfTerms = new ArrayList<String>();
		int index = 0;
		int numberOfTerms = 0;
		String stringLine = buffer.readLine();

		if(stringLine == null){
			buffer.close();
			return null;
		}
		String[] terms = stringLine.split("\\s+");
		index = Integer.parseInt(terms[0]);
		numberOfTerms = Integer.parseInt(terms[1]);
		
		for(int i=2;i<terms.length;i++){
			listOfTerms.add(terms[i]);
		}

		return new Tweet(index, numberOfTerms, listOfTerms);
	}
	
	public Tweet getOptimisticTweet(double angle) throws IOException{
		ArrayList<String> listOfTerms = new ArrayList<String>();
		while(true){
			String stringLine = buffer.readLine();
			if(stringLine == null){
				buffer.close();
				return null;
			}
			
			String[] terms = stringLine.split("\\s+");
			int index = Integer.parseInt(terms[0]);
			int numberOfTerms = Integer.parseInt(terms[1]);
			
			if(Math.acos((terms.length-2)/numberOfTerms)<=angle){
				for(int i=2;i<terms.length;i++){
					listOfTerms.add(terms[i]);
				}
				return new Tweet(index, numberOfTerms, listOfTerms);
			}
		}
	}

}
