/*
时间复杂度	О(n²)
最优时间复杂度	О(n²)
平均时间复杂度	О(n²)
空间复杂度	О(n) total, O(1) auxiliary
*/

public static void selectionSort(int[] arr){
    int n = arr.length;
    int temp;
    int min;
    
    //只用比较到倒数第二个元素
    for(int i = 0; i<n-1; i++){
       min = i;
       //比较到数组最后一个元素
       for(int j = i+1; j < n; j++){
          if(arr[min] > arr[j]){
              min = j;
              temp = arr[min];
              arr[min] = arr[i];
              arr[i] = arr[min];
          }
       }
    }
}
