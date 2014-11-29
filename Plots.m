%% Task 1
sortedList = importdata('tmp/sorted.csv');

figure(1)
hist(sortedList.data,250)

figure(2)
%Cummulative distribuition

figure(3)
axis = 1:length(sortedList.data);
loglog(axis,sortedList.data)

%% Task 2
d = [0,2,4,6,8,10,12,14];

Task2_data = load('tmp/Task2.csv');


figure('Name','Task 2','NumberTitle','off')
%subplot(2,2,1); plot(d,BF,d,BF2,'--r'); title('Brute Force')
subplot(2,2,2); plot(d,Task2_data(:,1)); title('d-Frequent'); xlim([0 14]);
subplot(2,2,3); plot(d,Task2_data(:,2)); title('d-Infrequent'); xlim([0 14]);
subplot(2,2,4); plot(d,Task2_data(:,3)); title('d-Random'); xlim([0 14]);

%% Task 3
d = [0,2,4,6,8,10,12,14];

Task3_data = load('tmp/Task3.csv');


figure('Name','Task 3','NumberTitle','off')
%subplot(2,2,1); plot(d,BF,d,BF2,'--r'); title('Brute Force')
subplot(2,2,2); plot(d,Task3_data(:,1)); title('d-Frequent'); xlim([0 14]);
subplot(2,2,3); plot(d,Task3_data(:,2)); title('d-Infrequent'); xlim([0 14]);
subplot(2,2,4); plot(d,Task3_data(:,3)); title('d-Random'); xlim([0 14]);