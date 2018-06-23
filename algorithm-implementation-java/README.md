该部分为用<code>Java</code>实现的一些数据结构和经典算法，大部分来自Coursera上的Algorithm课程。

😌此Readme建议配合<code>Github with MathJax</code>（Chrome插件）阅读，以正常显示公式。


## 并查集

### 时间复杂度
|           algorithm           | worst-case time |
| :---------------------------: | :-------------: |
|          quick-find           |      $M N$      |
|          quick-union          |      $M N$      |
|          wighted QU           |  $N + M logN$   |
|     QU + path compression     |  $N + M logN$   |
| wighted QU + path compression |  $N + M lg*N$   |

### 应用
Percolation Model(渗透模型): Monte Carlo Simulation
这个例子很好地体现了并查集的特点，建议获取相关资料。




## 简单数据结构
### 链表
总感觉LinkedListItr不在内部有点奇怪，像是暴露了某些见不得人的东西..（考虑重新实现）

### Stack
Resizing Array的实现比较有意思。

### Queue
链表实现，维护头尾指针及长度就好。




## 排序
### 选择排序
* 每次选择一个最小的元素放在相应的位置
* 与原数组的顺序无关，就算是排序好的，也要经过 O(N^2)

### 插入排序
与原数组的顺序密切相关：
* 当原数组正序时，代价最低
* 当原数组倒序时，代价最高
* 当原数组部分有序（逆序对不超过CN），运行时间是线性的

### 希尔排序
* 先得出较好的h序列，如h = 3*h + 1，每次进行h-insertion_sort
* O(N^(3/2))，实际上比这个小得多
* 经常应用于嵌入式系统或硬件排序类的系统，在中小型数组中效率很高

### 归并排序
* 时间复杂度：O(N*logN)
* 需要使用一个辅助数组，内存开销较大
* 计算逆序对：可修改归并排序，已知左边有M个逆序对，右边有N个逆序对，那么剩下的逆序对(i,j)一个在左边，一个在右边，且满足a[i]>a[j]（分治法）

### 快速排序
* 时间复杂度：O(N*logN)
* 实际表现中比归并排序快接近1/3，且内存使用很少
* 改进：
   * 在子数组(sub-array)切割成很小（<=10）时，使用插入排序
   * 选择pivot时，尽量接近中位数

### 稳定性比较
* 稳定：插入排序、归并排序
* 不稳定：选择排序、希尔排序、快速排序
* 在稳定的排序算法中，有些实现也是不稳定的
* 主要在多层排序中考虑稳定性

### 排序总结
|             | inplace? | stable? |   worst   |  average  |   best    |                 remarks                  |
| :---------: | :------: | :-----: | :-------: | :-------: | :-------: | :--------------------------------------: |
|  selection  |    √     |         | $N^2 / 2$ | $N^2 / 2$ | $N^2 / 2$ |               N exchanges                |
|  insertion  |    √     |    √    | $N^2 / 2$ | $N^2 / 4$ |    $N$    |   use for small N or partially ordered   |
|    shell    |    √     |         |    $?$    |    $?$    |    $N$    |         tight code, subquadratic         |
|    merge    |          |    √    |  $NlogN$  |  $NlogN$  |  $NlogN$  |        $NlogN$ guarantee, stable         |
|    quick    |    √     |         | $N^2 / 2$ |  $2NlnN$  |  $NlogN$  | $NlogN$ probabilistic guarantee fastest in practice |
| 3-way quick |    √     |         | $N^2 / 2$ |  $2NlnN$  |    $N$    | improves quicksort in presence of duplicate keys |
|    heap     |    √     |         | $2NlogN$  | $2NlogN$  |  $NlogN$  |       $NlogN$ guarantee, in-place        |
|     ???     |    √     |    √    |  $NlogN$  |  $NlogN$  |    $N$    |            holy soering grail            |

### 应用
Graham scan（葛立恒扫描法）：计算一组平面点的凸包的算法，时间复杂度为O(n*logn)



## 优先队列

用resizing-array实现，核心在于sink操作和swim操作

### 堆排序

- 时间复杂度：O(N*logN)
- in-place




## 符号表

| 数据结构       | 实现                                      | 优点                        | 缺点                                       |
| ---------- | --------------------------------------- | ------------------------- | ---------------------------------------- |
| 链表         | SequentialSearchST                      | 适用于小型问题                   | 对于大型符号表很慢                                |
| 有序数组（二分查找） | BinarySearchST                          | 最优的查找效率和空间需求，能够进行有序性相关的操作 | 插入操作很慢                                   |
| 二叉查找树      | BST                                     | 实现简单，能够进行有序性相关的操作         | 没有性能上界的保证，链接需要额外的空间                      |
| 平衡二叉查找树    | RedBlackBST                             | 最优的查找和插入效率，能够进行有序性相关的操作   | 链接需要额外的空间                                |
| 散列表        | SeparateChainHashST LinearProbingHashST | 能够快速地查找和插入常见类型的数据         | 需要计算每种类型的数据的散列，无法进行有序性相关的操作，连接和空结点需要额外的空间 |

## 平衡搜索树（BST）

### 2-3 树

引出红黑树的数据结构，这个需要好好理解。

### 红黑树

红黑树，配合《算法》里面红黑树的章节来看，很容易懂的。



