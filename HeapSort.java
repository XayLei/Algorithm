/*
http://www.cnblogs.com/jetpie/p/3971382.html  heapsort 详解
*/

public class MaxHeap{
   protected int[] a;
   protected int heapsize;
   
   public MaxHeap(){}
   public MaxHeap(int[] a){
      buildMaxHeap(a);
   }
   
   //求父节点索引
   protected int parent(int i){
      return (i-1)/2;
   }
   //求左节点索引
   protected int left(int i){
      return 2*i+1;
   }
   //求右节点索引
   protected int right(int i){
      return 2*i+2;
   }
   
   //保持最大堆特性
   public void maxHeapify(int i){
      int l = left(i);
      int r = right(i);
      int largest = i;
      
      if(l <= heapsize-1 && a[i] < a[l]){
         largest = l;
      }
      if(r <= heapsize-1 && a[largest] < a[r]){
         largest = r;
      }
      //如果父节点不是最大值，则将父节点与最大值子节点交换
      if(largest != i){
          int temp = a[largest];
          a[largest] = a[i];
          a[i] = temp;
          
          //元素位置交换后，要继续保证变换后的子节点的子堆的最大堆特性，利用递归
          this.maxHeapify(largest);
      }   
   }
   
   //创建初始“最大堆”
   public void buildMaxHeap(int[] a){
      this.a = a;
      this.heapsize = a.length;
      
      //创建堆时，从下往上创建堆，即从最后一个叶节点的子节点开始,最后一个叶节点就是数组的最后一个元素
      for(int i = parent(heapsize-1), i>=0, i--){
         maxHeapify(i);
      }
   }
   
   //堆排序，将root节点A[0]和堆中最后一个叶节点（leaf）进行交换，然后取出叶节点。这样，堆中除了以A[0]为root的树破坏了#2 - Heap Property，
   //其他subtree仍然是最大堆。
   //只需对A[0]进行Max-Heapify的操作。
   //这个过程中将root节点取出的方法也很简单，只需将heapsize←heapsize−1heapsize←heapsize−1。
   public void heapSort(int[] a){
      //创建一个最大堆
      buildMaxHeap(a);
      
      for(int i = heapsize-1, i>=0, i--){
         //将数组的最后一个元素与数组的第一个元素交换
         int temp = a[i];
         a[i] = a[0];
         a[0] = temp;
         //取出堆顶后，将数组长度减一
         heapsize--;
         
         //然后对取出堆顶元素后产生的新堆，保持其最大堆特性，输入堆顶索引
         maxHeapify(0);
      }
   }
   
   public static void main(String[] args){
      int[] a = {3, 7, 2, 11, 3, 4, 9, 2, 18};
      MaxHeap maxhp = new MaxHeap();
      maxhp.heapsort(A);
   }
}
