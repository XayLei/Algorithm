//快速排序思想：冒泡+二分+递归分治
public class QuickSort{
   public static int partition(int[] arr, int left, int right){
       int pivotKey = arr[left];
       int pivotPointer = left;
       
       while(left<right){
          while(left<right && arr[right] >= pivotKey){
             right--;
          }
          while(left<right && arr[left] <= pivotKey){
             left++;
          }
          
          swap(arr,left,right);
       }
       
       swap(arr,pivotPointer,left);
       return left;
   }
   
   public static void quickSort(int[] arr， int left , int right){
       if(left > right)
          return;
          
       //定义基准数索引并通过partition函数赋值   
       int pivotPosition = partition(arr,left,right);
       //递归+分治，对基准数左右子序列再进行快速排序
       quickSort(arr, left, pivotPosition-1);
       quickSort(arr, pivotPosition+1, right);
   }
   
   public static void swap(int[] arr, int left, int right){
       int temp = arr[left];
       arr[left] = arr[right];
       arr[right] = temp;
   }
}
