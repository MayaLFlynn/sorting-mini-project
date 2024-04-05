# sorting-mini-project
As the name suggests, it's our mini-project for the sorting lab.


Acknoledgements
Boston and Elizabeth worked with me to figure out where I was assuming that the comparator would return -1, 0, and 1 instead of <0, 0, and >0. 
For MergeSort and Quicksort, I used the stub methods provided in the respective labs from SamR. I also used some of the code that Marina A. and I worked on for merging in MergeSort.

FlynnMayaSort was created with the help of ChatGPT. I hadn't used the software before, so I wasn't totally sure how to approach the problem. It wasn't as hard as I thought it would be, but I did have to mess with my prompts a little bit. 
I first asked it to give me an n^2 sorting algorithm because I wanted to see how it worked. It gave me bubble sort. Then I asked it to give me an nlogn sorting algorithm and it gave me MergeSort. When I asked again it gave me Quicksort. Then it gave me HeapSort, which I looked up and found is a slower than Timsort, quicksort, and mergesort, but I decided to go with it since it appeared to be one of the sorting algorithms talked about in the presence of Quicksort and Mergesort. I asked ChatGPT to give me a Java 17 implementation of HeapSort, and it did, but it only sorted integers. After correcting it to work for generic types with comparators, I modified it to make it fit the style of the other sorters and added documentation to the code. 
Overall, I think it was good practice, and it helped me understand how ChatGPT can be utilized, and even with my corrections it was faster than creating and coding from scratch my own sorter.