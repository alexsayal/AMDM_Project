import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class Tasks {

	//=====TASK 1 =====//
	public static ArrayList<Term> task1() throws IOException{
		System.out.println("Task 1 initiated.");
		DataBuff reader = new DataBuff(Main.DataFile);
		
		HashMap<String,Term> map = Tools.mapcreator();

		String stringLine = reader.buffer.readLine();
		String[] terms = stringLine.split("\\s+");
		for(int line = 0; (stringLine = reader.buffer.readLine()) != null && line<Main.QuerrySize; line++){
			for(int j=0;j<terms.length;j++){
				Term obj = (Term) map.get(terms[j]);
				if(obj != null){
					obj.numberOfTweets++;
				}
			}
			terms = stringLine.split("\\s+");
		}

		ArrayList<Term> sortByNumberOfTweets = new ArrayList<Term>();
		sortByNumberOfTweets.addAll(map.values());

		Collections.sort(sortByNumberOfTweets, new Comparator<Term>() {
			@Override
			public int compare(Term o1, Term o2){
				if (o1.numberOfTweets < o2.numberOfTweets)
					return 1;
				else if(o1.numberOfTweets == o2.numberOfTweets)
					return o1.text.compareTo(o2.text);
				else
					return -1;
			}
		});
		reader.buffer.close();
		System.out.println("Task 1 terminated." + "\n" + "--------------------");
		return sortByNumberOfTweets;
	}

	//=====BRUTE FORCE =====//
	public static long bruteforce() throws IOException{
		System.out.println("Brute Force initiated.");
		DataBuff Buff = new DataBuff(Main.DataFile);
		
		ArrayList<String> Querry = new ArrayList<String>();
		String stringLine = null;
		double angle = Math.PI/2;
		int indextwt = 0;
		int indexque = 0;
		String twt = null;
		String que = null;
		
		for(int i = 0; i<Main.QuerrySize;i++){
			stringLine = Buff.buffer.readLine();
			Querry.add(stringLine);
		}
		System.out.println("Querry saved in memory. Starting to read.");
		
		long startTime = System.currentTimeMillis();
		for(int line = Main.QuerrySize; line<Main.DataSetSize;line++){
			stringLine = Buff.buffer.readLine();
			String[] Lsplitted = stringLine.split("\\s+");
			for(String querry : Querry){
				String[] Qsplitted = querry.split("\\s+");

				double aux = Tools.angle_bruteforce(Lsplitted, Qsplitted);
				if(aux<angle){
					angle = aux;
					indextwt = Buff.buffer.getLineNumber();
					indexque = Querry.indexOf(querry);
					twt = stringLine;
					que = querry;
				}
			}
			if(line%10000==0) System.out.println("Current line: " + line);
		}
		System.out.println("Angle: " + angle + "\n" + "Querry at line " + indexque + ": " + que + "\n" + "Tweet at line " + indextwt + ": " + twt);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Brute Force terminated." + "\n" + "--------------------");
		Buff.buffer.close();
		return totalTime;
	}
	
	//=====TASK 2 =====//
	public static long task2(String method,int d) throws Exception{
		System.out.println("Task 2 initiated using Method " + method + " and d=" + d);
		String path_file = Main.FilesPath +"dataReduction" + "_Method:" + method +  "_D:"+ d;
		
		DataBuff Buff = new DataBuff(path_file);
		
		ArrayList<Tweet> Querry = new ArrayList<Tweet>();
		Tweet querryMin = new Tweet();
		Tweet tweetMin = new Tweet();
		double angle = Math.PI/2;
		
		for(int line=0;line<Main.QuerrySize;line++){
			Querry.add(Buff.getNextTweet(method));
		}
		long startTime = System.currentTimeMillis();
		
		Tweet tweet = Buff.getNextTweet(method);
		while(tweet != null){
			for(Tweet querry : Querry){
				double aux = Tools.angleAlphabet(querry, tweet);
				if(aux<angle){
					angle = aux;
					querryMin = querry;
					tweetMin = tweet;
				}
			}
			tweet = Buff.getNextTweet(method);
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Tweet: " + tweetMin + "\n" + "Querry: " + querryMin);
		System.out.println("Minimum Angle:" + angle +"   Time elapsed: " + totalTime + "ms");
		System.out.println("--------------------");
		Buff.buffer.close();
		return totalTime;
	}

	//=====TASK 3 =====//
	public static long task3(String method,int d) throws Exception{
		System.out.println("Task 3 initiated using Method " + method + " and d=" + d);
		String path_file = Main.FilesPath +"dataReduction" + "_Method:" + method +  "_D:"+ d;
		
		DataBuff Buff = new DataBuff(path_file);
		
		ArrayList<Tweet> Querry = new ArrayList<Tweet>();
		Tweet querryMin = new Tweet();
		Tweet tweetMin = new Tweet();
		double angle = Math.PI/2;
		
		for(int line=0;line<Main.QuerrySize;line++){
			Querry.add(Buff.getNextTweet(method));
		}
		long startTime = System.currentTimeMillis();
		
		Tweet tweet = Buff.getOptimisticTweet(angle);
		while(tweet != null){
			for(Tweet querry : Querry){
				double aux = Tools.angleAlphabet(querry, tweet);
				if(aux<angle){
					angle = aux;
					querryMin = querry;
					tweetMin = tweet;
				}
			}
			tweet = Buff.getOptimisticTweet(angle);
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Tweet: " + tweetMin + "\n" + "Querry: " + querryMin);
		System.out.println("Minimum Angle:" + angle +"   Time elapsed: " + totalTime + "ms");
		System.out.println("--------------------");
		Buff.buffer.close();
		return totalTime;
	}

	//=====TASK 4 =====//
	public static long task4(String method,int d, double aprox) throws Exception{
		System.out.println("Task 4 initiated using Method " + method + " and d=" + d + " and error of " + aprox*100 + "%");
		String path_file = Main.FilesPath +"dataReduction" + "_Method:" + method +  "_D:"+ d;
		
		DataBuff Buff = new DataBuff(path_file);
		
		ArrayList<Tweet> Querry = new ArrayList<Tweet>();
		Tweet querryMin = new Tweet();
		Tweet tweetMin = new Tweet();
		double angle = Math.PI/2+aprox*Math.PI/2;
		
		for(int line=0;line<Main.QuerrySize;line++){
			Querry.add(Buff.getNextTweet(method));
		}
		long startTime = System.currentTimeMillis();
		
		Tweet tweet = Buff.getOptimisticTweet(angle-aprox*Math.PI/2);
		while(tweet != null){
			for(Tweet querry : Querry){
				double aux = Tools.angleAlphabet(querry, tweet);
				if(aux<angle){
					angle = aux;
					querryMin = querry;
					tweetMin = tweet;
				}
			}
			tweet = Buff.getOptimisticTweet(angle-aprox*Math.PI/2);
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Tweet: " + tweetMin + "\n" + "Querry: " + querryMin);
		System.out.println("Minimum Angle:" + angle +"   Time elapsed: " + totalTime + "ms");
		System.out.println("--------------------");
		Buff.buffer.close();
		return totalTime;
	}



}
