import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;


public class Main {
	
	// ===== Configuration Values =====//
	public static final Integer QuerrySize  = 1000;
	public static final Integer DataSetSize  = 1000000;
	public static final String DataFile = "tweets_15m.txt";
	public static final String FilesPath = "tmp/";
	public static final String sortedArrayFileName = FilesPath + "sorted.csv";
	public static final String[] Methods = {"frequent","infrequent","random"};
	public static final int[] D = {0,2,4,6,8,10,12,14};
	public static final double[] aprox = {0.5,0.2};
	
	public static int in = 0;
	public static int out = 0;
	
	// ===== To Run or Not to Run ===== //
	public static final boolean runBruteForce = false;
	public static final boolean runDataReduction = false;
	public static final boolean runTask2 = false;
	public static final boolean runTask3 = false;
	public static final boolean runTask4 = true;
	
	// ===== Main ===== //
	public static void main(String[] args) throws Exception{
		Tools.createFolder(FilesPath);
		//System.setOut(new PrintStream(new FileOutputStream(FilesPath + "Console.txt")));
		
		//-----Task1-----//
		ArrayList<Term> sortByNumberOfTweets = Tasks.task1(); //List of Sorted Tweets by Number
		Term.writerArrayTerms(sortedArrayFileName, sortByNumberOfTweets);

		//-----Brute Force Algorithm-----//
		if(runBruteForce){
			long time = Tasks.bruteforce();
			System.out.println("Total Running Time: " + time + "ms");
		}
		
		//-----DataReduction-----//
		if(runDataReduction){
			long startTime = System.currentTimeMillis();
			for(String i : Methods){
				System.out.println("Method: " + i);
				for(int j : D){
					System.out.println("D: " + j);
					Reduction.dataReduction(i, j, sortByNumberOfTweets);
				}
			}
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Total time for reduction: " + totalTime + "ms");
		}
		
		//-----Task2-----//
		if(runTask2){
			long[][] task2times = new long[8][3];
			int k=0;
			for(String i : Methods){
				for(int j : D){
					task2times[j/2][k] = Tasks.task2(i, j);
				}
				k+=1;
			}
			Tools.writerTimes("Task2.csv", task2times);
		}
		
		//-----Task3-----//
		if(runTask3){
			long[][] task3times = new long[8][3];
			int k=0;
			for(String i : Methods){
				for(int j : D){
					task3times[j/2][k] = Tasks.task3(i, j);
				}
				k+=1;
			}
			Tools.writerTimes("Task3.csv", task3times);
			System.out.println("in: " + in + "\n" + "out: " + out);
		}
		
		//-----Task4-----//
		if(runTask4){
			long[][] task4times = new long[8][3];
			int k=0;
			for(double aprox : aprox){
				k=0;
				for(String i : Methods){
					for(int j : D){
						task4times[j/2][k] = Tasks.task4(i, j,aprox);
					}
					k+=1;
				}
				Tools.writerTimes("Task4_" + aprox + ".csv", task4times);
			}
		}
	}
}
