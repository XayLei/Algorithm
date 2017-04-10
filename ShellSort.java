/**
希尔排序是改进版的插入排序，以一定的步长进行排序，当步长为1时即为插入排序

影响排序速度的主要因素是步长序列的选择
*/

public void ShellSort(int[] arr){
     int gap = 1, i , j , len = arr.length;
     int temp;
     
     // 取这个步长序列的时间复杂度<O(n^(3/2)) by Knuth,1973>步长序列: 1, 4, 13, 40, 121,
     while(gap < len/3){
        gap = gap*3  + 1;
     }
     
     for(;gap>0; gap /= 3){
        for(i=gap; i<len; i++){
            temp = arr[i];
            j = i-gap;
            while(j>=0 && temp<arr[j]){
               arr[j+gap] = arr[j];
               j = j-gap;
            }
            arr[j+gap] = temp;
        }
     }
}
