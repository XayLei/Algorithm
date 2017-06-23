/*
时间复杂度	О(n²)
最优时间复杂度	О(n²)
平均时间复杂度	О(n²)
空间复杂度	О(n) total, O(1) auxiliary
工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
         以此类推，直到所有元素均排序完毕。
*/

public static void selectionSort(int[] arr){
    int n = arr.length;
    int temp;
    int min;
    
    //只用比较到倒数第二个元素
    for(int i = 0; i<n-1; i++){ //i代表有序部分的最后位置的索引，也是无序部分的第一个索引
       min = i;
       //比较到数组最后一个元素
       for(int j = i+1; j < n; j++){ //遍历无序部分第二个位置开始的后面元素
          if(arr[min] > arr[j]){  //分别将当前遇到的无序部分的最小元素交换到无序部分的第一个位置，最终就达到了将无序部分最小元素选出并添加到有序部分后面的目标
              min = j;
              temp = arr[min];
              arr[min] = arr[i];
              arr[i] = arr[min];
          }
       }
    }
}
