# Algorithm Practice

## Union-find
### Time Consuming
|           algorithm           | worst-case time |
| :---------------------------: | :-------------: |
|          quick-find           |       M N       |
|          quick-union          |       M N       |
|          wighted QU           |   N + M logN    |
|     QU + path compression     |   N + M logN    |
| wighted QU + path compression |   N + M lg*N    |

### Application
Percolation Model(渗透模型): Monte Carlo Simulation

## Simple Data Structure
### Linked List
总感觉LinkedListItr不在内部有点奇怪，像是暴露了某些实现...
### Stack
Resizing Array的实现比较有意思呀...
### Queue
链表实现，维护头尾指针及长度就好

## Sorting
### Selection Sort
* 每次选择一个最小的元素放在相应的位置
* 与原数组的顺序无关，就算是排序好的，也要经过 O(N^2)

### Insertion Sort
与原数组的顺序密切相关：
* 当原数组正序时，代价最低
* 当原数组倒序时，代价最高
* 当原数组部分有序（逆序对不超过CN），运行时间是线性的

### Shell Sort
* 先得出较好的h序列，如h = 3*h + 1，每次进行h-insertion_sort
* O(N^(3/2))，实际上比这个小得多
* 经常应用于嵌入式系统或硬件排序类的系统，在中小型数组中效率很高

### Merge Sort
* 时间复杂度：O(N*logN)
* 内存开销较大


### Quick Sort


### Application
Graham scan（葛立恒扫描法）：计算一组平面点的凸包的算法，时间复杂度为O(n*logn)



