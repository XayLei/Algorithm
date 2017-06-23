/*插入排序就类似于玩牌时的理牌阶段，将小的牌一个一个的插入到大牌的前面

插入排序就是将待排序元素插入到前面已排好序的序列当中
*/
public class InsertSort{
   public static void insertSort(int[] arr){
       if(arr==null || arr.length==0)
           return;
           
       //数组中，i左边有序，i右边无序
       for(int i = 1; i<arr.length; i++){
          target = arr[i];  //待插入值
          int j = i;
          
          //这里j>0是由于后面的target要与arr[j-1]比较大小，所以j不能取0，循环条件是j大于0即可继续执行
          while(j>0 && target<arr[j-1]){
             //最开始的arr[j]即arr[i]已被存储到target中，所以这里不需要临时变量tmp
             //这一步的意义是将比待插入值大的值向后移一位
             arr[j] = arr[j-1];
             j--;
          }
          //插入
          arr[j] = target;
       }
   }
}
