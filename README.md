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
* 需要使用一个辅助数组，内存开销较大
* 计算逆序对：可修改归并排序，已知左边有M个逆序对，右边有N个逆序对，那么剩下的逆序对(i,j)一个在左边，一个在右边，且满足a[i]>a[j]（分治法）

### Quick Sort
* 时间复杂度：O(N*logN)
* 实际表现中比归并排序快接近1/3，且内存使用很少
* 改进：
   * 在子数组(sub-array)切割成很小（<=10）时，使用插入排序
   * 选择pivot时，尽量接近中位数

### Stability
* 稳定：插入排序、归并排序
* 不稳定：选择排序、希尔排序、快速排序
* 在稳定的排序算法中，有些实现也是不稳定的
* 主要在多层排序中考虑稳定性

### Summary
|             | inplace? | stable? |   worst   |  average  |   best    |                 remakes                  |
| :---------: | :------: | :-----: | :-------: | :-------: | :-------: | :--------------------------------------: |
|  selection  |    √     |         | $N^2 / 2$ | $N^2 / 2$ | $N^2 / 2$ |               N exchanges                |
|  insertion  |    √     |    √    | $N^2 / 2$ | $N^2 / 4$ |     N     |   use for small N or partially ordered   |
|    shell    |    √     |         |     ?     |     ?     |     N     |         tight code, subquadratic         |
|    merge    |          |    √    |  $NlogN$  |  $NlogN$  |  $NlogN$  |        $NlogN$ guarantee, stable         |
|    quick    |    √     |         | $N^2 / 2$ |  $2NlnN$  |  $NlogN$  | $NlogN$ probabilistic guarantee fastest in practice |
| 3-way quick |    √     |         | $N^2 / 2$ |  $2NlnN$  |     N     | improves quicksort in presence of duplicate keys |
|     ???     |    √     |    √    |  $NlogN$  |  $NlogN$  |     N     |            holy soering grail            |

### Application
Graham scan（葛立恒扫描法）：计算一组平面点的凸包的算法，时间复杂度为O(n*logn)


##Priority Queues


