# Lab4--Bin-Packing

By: Anton Olson and Owen Beyer

Within this README.md file, this acts as part of our documentation for the lab, demonstrating how our bin-packing algorithm reaches Θ(n^2) and some examples of optimal and nonoptimal solutions.
## Implementation of Our Bin-packing Algorithm

Our algorithm was a decent approximation, but it ran really fast. the perfect
algorithm for binPacking would be in exponential time, but our algorithm ran in Θ(n^2) time.

### Why Our Bin-packing Algorithm reaches Θ(n^2)

We found this out because we sorted our array, which is Θ(n lg n). Then, we took from the back of the array (we used ArrayLists for this project) in a loop of Θ(n), then took from the front of the array, which took Θ(n^2) time. After some more constant and n time functions, we end up with a Θ(n^2) algorithm, which is polynomial time.

## Solution Examples

These solutions all use a bin size of **20**.

### (Optimal Solution 1)

#### Array

{6, 5, 9, 11, 15, 14}

#### Output

Given Array: 6 5 9 11 15 14  
Bin Size: 20
 
Bin 1: 15 5  Empty Space: 0 
Bin 2: 14 6  Empty Space: 0 
Bin 3: 11 9  Empty Space: 0 
 
Leftover Arr:  
Leftovers Total: 0

### (Optimal Solution 2)

#### Array 

{19, 17, 1, 18, 2, 3}

#### Output

Given Array: 19 17 1 18 2 3  
Bin Size: 20
 
Bin 1: 19 1  Empty Space: 0 
Bin 2: 18 2  Empty Space: 0 
Bin 3: 17 3  Empty Space: 0 
 
Leftover Arr:  
Leftovers Total: 0

### (Unoptimal Solution 1)

#### Array

{12, 4, 8, 15, 9, 3, 1, 10}

#### Output

Given Array: 12 4 8 15 9 3 1 10  
Bin Size: 20
 
Bin 1: 15 1 3  Empty Space: 1 
Bin 2: 12 4  Empty Space: 4 
Bin 3: 10 9  Empty Space: 1 
 
Leftover Arr: 8  
Leftovers Total: 8
