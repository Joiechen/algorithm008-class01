### 排序
1.比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(NLOGN),因此也称为非线性时间比较类排序。 交换排序：冒泡排序、快速排序 插入排序：简单插入排序、希尔排序 选择排序：简单选择排序、堆排序 归并排序：二路归并排序、多路归并排序

2.非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。 计数排序、桶排序、基数排序


| 排序算法 | 平均时间复杂度 |
| --- | --- | --- |
| 冒泡排序 | O(n2) |
| 选择排序 | O(n2) |
| 插入排序 | O(n2) |
| 希尔排序 | O(n1.5) |
| 快速排序 | O(N*logN) |
| 归并排序 | O(N*logN) |
| 堆排序 | O(N*logN) |
| 基数排序 | O(d(n+r)) |


### 排序算法
1. 冒泡排序：
+ 基本思想： 两个数比较大小，较大的数下沉，较小的数冒起来。
+ 过程： 
     + 比较相邻的两个数据，如果第二个数小，就交换位置。
     + 从后向前两两比较，一直到比较最前两个数据。最终最小数被交换到起始的位置，这样第一个最小数的位置就排好了。
     + 继续重复上述过程，依次将第2.3...n-1个最小数排好位置。
+ java代码实现

     ```
     public static void BubbleSort(int [] arr){

     int temp;//临时变量
     for(int i=0; i<arr.length-1; i++){   //表示趟数，一共arr.length-1次。
         for(int j=arr.length-1; j>i; j--){

             if(arr[j] < arr[j-1]){
                 temp = arr[j];
                 arr[j] = arr[j-1];
                 arr[j-1] = temp;
             }
         }
     }
    }
    ```

2. 选择排序：
+ 基本思想：
   在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
第二次遍历n-2个数，找到最小的数值与第二个元素交换；
。。。
第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
+ 过程：
     + 每次找最小值，然后放到待排序数组的起始位置。
+ java代码实现：

  ```
  public static void select_sort(int array[],int lenth){

   for(int i=0;i<lenth-1;i++){

       int minIndex = i;
       for(int j=i+1;j<lenth;j++){
          if(array[j]<array[minIndex]){
              minIndex = j;
          }
       }
       if(minIndex != i){
           int temp = array[i];
           array[i] = array[minIndex];
           array[minIndex] = temp;
       }
   }
   }
  ```

3. 插入排序：
+ 基本思想：在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
+ 过程：
     + 从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
+ java代码实现：

```
public static void  insert_sort(int array[],int lenth){

   int temp;

   for(int i=0;i<lenth-1;i++){
       for(int j=i+1;j>0;j--){
           if(array[j] < array[j-1]){
               temp = array[j-1];
               array[j-1] = array[j];
               array[j] = temp;
           }else{         //不需要交换
               break;
           }
       }
   }
}
```

4. 快速排序
+ 基本思想：
    + 先从数列中取出一个数作为key值
    + 将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
    + 对左右两个小数列重复第二步，直至各区间只有1个数。

+ java代码实现：
```
public static void quickSort(int a[],int l,int r){
     if(l>=r)
       return;

     int i = l; int j = r; int key = a[l];//选择第一个数为key

     while(i<j){

         while(i<j && a[j]>=key)//从右向左找第一个小于key的值
             j--;
         if(i<j){
             a[i] = a[j];
             i++;
         }

         while(i<j && a[i]<key)//从左向右找第一个大于key的值
             i++;

         if(i<j){
             a[j] = a[i];
             j--;
         }
     }
     //i == j
     a[i] = key;
     quickSort(a, l, i-1);//递归调用
     quickSort(a, i+1, r);//递归调用
 }
 ```