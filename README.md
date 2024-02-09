# MergeSorter
A merge sorter with a GUI that tracks the algorithm progress, demonstrating the multi-threaded sorting logic

The task:
Write a multithreaded program enabling the sorting of an list using n threads. 
The program should divide the list into n parts and independently sort each part. 
The sorting should be implemented using a custom sorting procedure, for example, merge sort (avoid using ready-made libraries). 
After sorting individual parts, they should be merged. 
The program should visualize the sorting process using progress bars: one for each sorting thread and one for the overall process. 

The program logic: 
- generate list of the declared size contaning random numbers, 
- sort it, splitting the task between a given number of threads,
- show the results: sorted list and time it took to finish the most important steps 

HOW TO USE:
change the variables declared in the main class:
int n         ->           number of threads 
int len       ->           lenght of the list

start the program and observe the results
(notice that the same progress bars first show the sorting process and then the merging process)
