import java.util.ArrayList;

public class Main {
	
	// ===== Configuration Values =====//
	public static final Integer QuerrySize  = 1000;
	public static final Integer DataSetSize  = 15000000;
	public static final String DataFile = "tweets_15m.txt";
	public static final String FilesPath = "tmp/";
	public static final String sortedArrayFileName = FilesPath + "sorted.csv";
	public static final String[] Methods = {"frequent","infrequent","random"};
	public static final Integer[] D = {0,2,4,6,8,10,12,14};
	public static final double[] aprox = {0.5,0.2};
	public static double[][] task3angles = new double[8][3];
	public static double[][] task4angles = new double[8][3];
	
	// ===== To Run or Not to Run ===== //
	public static final boolean rerunTask1 = false;
	public static final boolean runBruteForce = false;
	public static final boolean runDataReduction = true;
	public static final boolean runTask2 = false;
	public static final boolean runTask3 = true;
	public static final boolean runTask4 = true;
	
	// ===== Main ===== //
	public static void main(String[] args) throws Exception{
		Tools.createFolder(FilesPath);
		ArrayList<Term> sortByNumberOfTweets = Tools.readerAL(sortedArrayFileName);
		
		//-----Task1-----//
		if(sortByNumberOfTweets.isEmpty() || rerunTask1){
			sortByNumberOfTweets = Tasks.task1(); //List of Sorted Tweets by Number
			Term.writerArrayTerms(sortedArrayFileName, sortByNumberOfTweets);
		}
		
		//-----Brute Force Algorithm-----//
		if(runBruteForce){
			long[][] time = new long[1][1];
			time[0][0] = Tasks.bruteforce();
			Tools.writerTimes("BF_time.csv", time);
			System.out.println("Total Running Time: " + time + "ms");
		}
		
		//-----DataReduction-----//
		if(runDataReduction){
			long startTime = System.currentTimeMillis();
			for(String i : Methods){
				for(int j : D){
					Reduction.dataReduction(i, j, sortByNumberOfTweets);
				}
			}
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Data Reduction completed. Total time for reduction: " + totalTime + "ms");
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
					task3times[j/2][k] = Tasks.task34(i, j, 0);
				}
				k+=1;
			}
			Tools.writerTimes("Task3.csv", task3times);
			Tools.writerAngles("Task3_angles.csv", task3angles);
		}
		
		//-----Task4-----//
		if(runTask4){
			long[][] task4times = new long[8][3];
			int k=0;
			for(double aprox : aprox){
				k=0;
				for(String i : Methods){
					for(int j : D){
						task4times[j/2][k] = Tasks.task34(i, j, aprox);
					}
					k+=1;
				}
				Tools.writerTimes("Task4_" + aprox + ".csv", task4times);
				Tools.writerAngles("Task4_" + aprox + "_angles.csv", task4angles);
			}
		}
	}
}
