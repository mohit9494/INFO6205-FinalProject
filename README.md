# INFO6205-FinalProject

This is the Team 14 final project implementing MSD radix sort for a natural language which uses Unicode characters.

## Overview

In this project out primary goal is to sort Chinese strings in the English order of Pinyin using MSD radix sort. To achieve this, we followed following approach 
- Convert Chinese strings to Pinyin
- convert the Pinyin to long arrays
- Sorting the array by comparing the corresponding long values

We have implemented following sorting algorithms and written corresponding Unit Test cases

1. MSD RadixSort
2. LSD Radixsort
3. 3-way Quicksort
4. Dual Pivot Quicksort
5. TimSort
6. HuskySort
7. InsertionSort (only used for performance tuning to sort subarray after cutoff is reached)

Sorting performed for Strings in following language 

1. Chinese (Pinyin order)
2. Telugu
3. English


