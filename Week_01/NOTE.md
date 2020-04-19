### 数据结构脑图地址（持续更新中）：
http://naotu.baidu.com/file/0bde37ed5d612a8799e3f2568a6144bd?token=df349b97eef83f2d

### Redis中的跳表
使用条件：一定是有序的链表数据结构。
如何优化：在有序链表基础上，增加了n/(2^k)索引，查找元素时，从最上面往下查找
时间复杂度：在跳表中查询任意数据的时间复杂度为O(logn)
空间复杂度：O(n)
升维思想，用空间换时间

## LRU缓存算法
LRU 缓存淘汰算法就是一种常用策略。LRU 的全称是 Least Recently Used，也就是说我们认为最近使用过的数据应该是是「有用的」，很久都没用过的数据应该是无用的，内存满了就优先删那些很久没用过的数据。



### Priority Queue 优先队列：

Java 实现的优先级队列：PriorityQueue<E>

1. 基于优先级堆(priority heap)，默认情况下由元素的自然顺序排序。也可以在构造方法中传一个自定义的 Comparator 来排序。
2. PriorityQueue 不允许 null 元素，也不允许不可排序的元素 (可能会抛 ClassCasrException)。
3. PriorityQueue 不是线程安全的，如果有多线程并发操作的情况，推荐使用 PriorityBlockingQueue。
4. 插入操作：O(1)，取出操作：O(logN) - 通过元素的优先级取出，底层数据结构比较复杂
5. 数据结构：heap，BST，treap

