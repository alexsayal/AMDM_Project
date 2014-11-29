
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Random;


public class Tools {
	
	// ===== Class Create Folder ===== //
	public static void createFolder(String path){
		File theDir = new File(path);
		if(!theDir.exists()) { // if the directory does not exist, create it
			theDir.mkdir();
		}
	}
	
	// ===== Create Map of all different terms ===== //
	public static HashMap<String, Term> mapcreator() throws IOException{
		final FileReader dataFile = new FileReader(Main.DataFile);
		final LineNumberReader reader = new LineNumberReader(dataFile);
		
		HashMap<String, Term> map = new HashMap<String, Term>();
		for(int i = 0;i<Main.QuerrySize;i++){
			String[] terms = reader.readLine().split("\\s+");
			for(int j=0;j<terms.length;j++){
				map.put(terms[j], new Term(terms[j],0));
			}
		}
		reader.close();
		return map;
	}

	// ===== Random Number generator ===== //	
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	// ===== Angle Alphabet ===== //
	public static double angleAlphabet(Tweet x, Tweet y){
		int cont = 0;
		int i=0;
		int j=0;
		while(i<x.listOfTerms.size() && j<y.listOfTerms.size()){
			if(x.listOfTerms.get(i).equals(y.listOfTerms.get(j))){
				cont++;
				i++;
				j++;
			}
			else{
				if(x.listOfTerms.get(i).compareTo(y.listOfTerms.get(j))<0){
					i++;  
				}
				else{
					j++;
				}
			}
		}
		return Math.acos(cont/(Math.sqrt(x.numberOfTerms)*Math.sqrt(y.numberOfTerms)));
	}
	
	// ===== Export Times Array ===== //
	public static void writerTimes (String filename, long[][] times) throws IOException{
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(Main.FilesPath + filename));
		for (int i = 0; i < times.length; i++) {
			String aux = new String();
			for(int j = 0; j<times[0].length; j++){
				aux += times[i][j] + (j!=times[0].length-1 ? ", " : "");
			}
			outputWriter.write(aux);
			outputWriter.newLine();
		}
		outputWriter.flush();  
		outputWriter.close();  
	}
	
	// ===== Angle Brute Force ===== //
	public static double angle_bruteforce(String[] x, String[] y){
		int cont = 0;
		int i=0;
		int j=0;
		while(i<x.length && j<y.length){
			if(x[i].equals(y[j])){
				cont++;
				i++;
				j++;
			}
			else{
				if(x[i].compareTo(y[j])<0) i++;  
				else j++;
			}
		}
		return Math.acos(cont/(Math.sqrt(x.length)*Math.sqrt(y.length)));
	}
}
