%% Load all necessary files

sortedList = importdata('tmp/sorted.csv');
d = [0,2,4,6,8,10,12,14];
Task2_data = load('tmp/Task2.csv');
Task3_data = load('tmp/Task3.csv');
BF = load('tmp/BF_time.csv');
Task4_data_50 = load('tmp/Task4_0.5.csv');
Task4_data_20 = load('tmp/Task4_0.2.csv');
Task3_ang = load('tmp/Task3_angles.csv');
Task4_ang_50 = load('tmp/Task4_0.5_angles.csv');
Task4_ang_20 = load('tmp/Task4_0.2_angles.csv');


%% Task 1

figure('Name','Distribuition','NumberTitle','off')
hist(sortedList.data,250)

figure('Name','Cummulative distribuition','NumberTitle','off')
%Cummulative distribuition

figure('Name','Plot','NumberTitle','off')
axis = 1:length(sortedList.data);
loglog(axis,sortedList.data)

%% Task 2

figure('Name','Task 2','NumberTitle','off')
subplot(1,3,1); plot(d,Task2_data(:,1),'--o'); title('d-Frequent'); xlim([0 14]); xlabel('d'); ylabel('Time (ms)');
subplot(1,3,2); plot(d,Task2_data(:,2),'--o'); title('d-Infrequent'); xlim([0 14]); xlabel('d'); ylabel('Time (ms)');
subplot(1,3,3); plot(d,Task2_data(:,3),'--o'); title('d-Random'); xlim([0 14]); xlabel('d'); ylabel('Time (ms)');

%% Task 3

figure('Name','Task 3','NumberTitle','off')
subplot(1,3,1); plot(d,BF./Task3_data(:,1),'--o'); title('d-Frequent'); xlim([0 14]); xlabel('d'); ylabel('Speedup');
subplot(1,3,2); plot(d,BF./Task3_data(:,2),'--o'); title('d-Infrequent'); xlim([0 14]); xlabel('d'); ylabel('Speedup');
subplot(1,3,3); plot(d,BF./Task3_data(:,3),'--o'); title('d-Random'); xlim([0 14]); xlabel('d'); ylabel('Speedup');

%% Task 4 Times

figure('Name','Task 4 with 50%','NumberTitle','off')
subplot(1,3,1); plot(d,BF./Task4_data_50(:,1),'--o'); title('d-Frequent'); xlim([0 14]); xlabel('d'); ylabel('Speedup');
subplot(1,3,2); plot(d,BF./Task4_data_50(:,2),'--o'); title('d-Infrequent'); xlim([0 14]); xlabel('d'); ylabel('Speedup');
subplot(1,3,3); plot(d,BF./Task4_data_50(:,3),'--o'); title('d-Random'); xlim([0 14]); xlabel('d'); ylabel('Speedup');

figure('Name','Task 4 with 20%','NumberTitle','off')
subplot(1,3,1); plot(d,BF./Task4_data_20(:,1),'--o'); title('d-Frequent'); xlim([0 14]); xlabel('d'); ylabel('Speedup');
subplot(1,3,2); plot(d,BF./Task4_data_20(:,2),'--o'); title('d-Infrequent'); xlim([0 14]); xlabel('d'); ylabel('Speedup');
subplot(1,3,3); plot(d,BF./Task4_data_20(:,3),'--o'); title('d-Random'); xlim([0 14]); xlabel('d'); ylabel('Speedup');

%% Task 4 Angles

figure('Name','Task 4 with 50%','NumberTitle','off')
subplot(1,3,1); plot(d,(Task4_ang_50(:,1)-Task3_ang(:,1))./Task3_ang(:,1)*100,'--o'); title('d-Frequent'); xlim([0 14]); xlabel('d'); ylabel('Aproximation error (%)');
subplot(1,3,2); plot(d,(Task4_ang_50(:,2)-Task3_ang(:,2))./Task3_ang(:,2)*100,'--o'); title('d-Infrequent'); xlim([0 14]); xlabel('d'); ylabel('Aproximation error (%)');
subplot(1,3,3); plot(d,(Task4_ang_50(:,3)-Task3_ang(:,3))./Task3_ang(:,3)*100,'--o'); title('d-Random'); xlim([0 14]); xlabel('d'); ylabel('Aproximation error (%)');

figure('Name','Task 4 with 20%','NumberTitle','off')
subplot(1,3,1); plot(d,(Task4_ang_20(:,1)-Task3_ang(:,1))./Task3_ang(:,1)*100,'--o'); title('d-Frequent'); xlim([0 14]); xlabel('d'); ylabel('Aproximation error (%)');
subplot(1,3,2); plot(d,(Task4_ang_20(:,2)-Task3_ang(:,2))./Task3_ang(:,2)*100,'--o'); title('d-Infrequent'); xlim([0 14]); xlabel('d'); ylabel('Aproximation error (%)');
subplot(1,3,3); plot(d,(Task4_ang_20(:,3)-Task3_ang(:,3))./Task3_ang(:,3)*100,'--o'); title('d-Random'); xlim([0 14]); xlabel('d'); ylabel('Aproximation error (%)');

%% Task 3 and 4

figure('Name','Task 3 and 4','NumberTitle','off')
subplot(1,3,1); plot(d,Task3_data(:,1),d,Task4_data(:,1),'--r'); title('d-Frequent'); xlim([0 14]);
subplot(1,3,2); plot(d,Task3_data(:,2),d,Task4_data(:,2),'--r'); title('d-Infrequent'); xlim([0 14]);
subplot(1,3,3); plot(d,Task3_data(:,3),d,Task4_data(:,3),'--r'); title('d-Random'); xlim([0 14]);

