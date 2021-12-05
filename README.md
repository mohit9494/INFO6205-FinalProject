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

We wrote a report which summarizes our overall findings and main conclusions.

We benchmarked the results of all methods for 250k, 500k and 1M, 2M, 4M Strings in 3 languages and added the corresponding graphs in report.

We wrote Literature Survey by going through following two technical papers related to HuskySort and MSD RadixSort

1. https://arxiv.org/pdf/2012.00866.pdf
2. https://www.cs.princeton.edu/~rs/AlgsDS07/18RadixSort.pdf

Sorting performed for Strings in following language 

1. Chinese (Pinyin order)
2. Telugu
3. English

## Modules

- Literature Survey
- Report
- Source Code (src)
  - /src/main/resources/ -> input files and sorted output in chinese, english and telugu
  - /src/main/java/edu/neu/coe/info6205/ -> Sort API, BenchMark and Timer classes, Sort Utils
  - /src/test/java/edu/neu/coe/info6205/sort/ -> Unit test cases covering above sorting implementations

 
