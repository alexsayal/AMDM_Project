AMDM_Project
====================================

Final Project Autumn 2014
Alexandre Campos and Fábio Pinheiro

====================================

Brief explaination of files in src/:

 -> Main.java : Main file is where all methods are called and run. Contains also a set of configuration values as: querry and data set size, names for exported files, paths for files, etc. It is also where the tasks to be run are defined.

 -> Tools.java : Contains a set of tools (methods) necessary for executing some of the tasks. The most important are the methods for calculating the angle between two tweets (angleAlphabet and angle_bruteforce) and the map creator (mapcreator).

 -> Tweet: Class which defines the object type Tweet.

 -> Term : Class which defines the object type Term.

 -> Tasks : Where the algorithms for Tasks 1, 2, 3, 4 and Brute force are located.

 -> Reduction : Where the algorithm for Data Reduction is located.

 -> DataBuff : Couple of methods for reading data. getNextTweet and getOptimisticTweet advance through the dataset in a different way and this is one of the strategies for speedup of Task 3 and 4.


How and what to run :

 -> The only file needed for running is Main.java. In the first lines, a section called "To Run or Not to Run" configures which Tasks should be executed by setting booleans.
 -> By default, all booleans will be set to false. If you want to run Task 2,3,4, Brute force or Data Reduction, just change the value of the respective boolean to true.
 -> Task 1 will run only if the sorted.csv file does not exist. If it does, the program will read it and move on. If the file exists but you want to replace it for a new one, set rerunTask1 as true.
 -> All files exported by the scripts will end up in folder tmp/. It is possible to change this by altering "FilesPath" in the begining of Main file.


Prints during running process :

 -> Every task will print whenever it starts or ends running.
 -> During the brute force task, a "current line" will show the progress of the algorithm.
 -> In the end of each task, the important information will also be printed for checking (for example running time, minimum angle, etc).