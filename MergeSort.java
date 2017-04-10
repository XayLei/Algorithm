//递归版的归并排序
public static void mergeSort(int[] arr){
    //创建一个辅助数组
    int[] help = new int[arr.length];
    //进行归并排序
    mergeSortRecursive(arr, 0 , arr.length-1, help);
}

static void mergeSortRecursive(int[] arr, int start, int end, int[] help){
    if(start >= end){
        return;
    }
    
    //定义分界点
    int mid = (end-start)/2 + start;
    //定义两个子序列的分界点索引
    int start1 = start;
    int end1 = mid;
    int start2 = mid+1;
    int end2 = end;
    //递归调用,思考这里时，不要往深处想是如何实现的，就把下面这两部分当成是给两个子序列排序
    //如：若给定排序的数组是{9，8，7，6，5，4，3，2}，那么下面两步就是分别给{9,8,7,6,5}和{4,3,2}两个子序列排序的，不用再往下想递归后又是怎么给更小的
    //子序列排序
    mergeSortRecursive(arr, start1, end1, help);
    mergeSortRecursive(arr, start2, end2, help);
    
    //从这里开始，我们要处理的就是如何把两个有序的子序列归并排序即可，也就是将{5,6,7,8,9}和{2,3,4}两个有序子数组进行归并
    //不要去想这里是如何给更小的子序列排序的，会懵逼的！！！！
    
    //先定义一个辅助数组中的指针，用于向辅助数组中传入数据
    int k = 0;
    //当两个子序列都有元素时
    while(start1 <= end1 && start2 <= end2){
        //注意，这里的自增是先赋原来的值，然后自增继续循环，也就是想给help[0]赋值后，k才自增为1的，后面的也都是这样
        help[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
    }
    //当第二个子序列没有元素后
    while(start1<=end1){
        help[k++] = arr[start1++];
    }
    //当第一个子序列没有元素时
    while(start2 <= end2){
        help[k++] = arr[start2++];
    }
    
    //将辅助数组中的有序序列复制到原数组中
    for(int i =0; i < help.length; i++){
       arr[i] = help[i];
    }   
}


//非递归版的归并排序，也就是迭代版，这个版本的排序时间复杂度比递归版的低
public static void merge_sort(int[] arr) {
    int len = arr.length;
    int[] result = new int[len];
    int block, start;
    
    // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
    //递归版本是从大序列往小序列想（实际实现时是先排序小序列，再一次排序大序列）
    //迭代版本是从小序列开始排序，例如{9，8，7，6，5，4，3，2}，先两个两个排序，然后四个四个排序....
    //当两个两个子序列排序时，子序列中只有一个元素，这时也就是block为1，当四个四个排序时，block也就是2
    for(block = 1; block < len*2; block *= 2) {
        //这是在遍历每一对排序小序列，如：最开始就是依次遍历{9，8}{7，6}{5，4}{3，2}
        for(start = 0; start <len; start += 2 * block) {
            //这里的索引和递归版的不太一样，第一次的例子中，start,mid,high分别是0,1,2，看着两个初始子序列各有两个元素，与最开始的两两排序不付
            //其实不是的，下面归并排序时，注意WHILE里的等号没有了，所以这里依然还是两两排序，没有问题
            int low = start;
            int mid = (start + block) < len ? (start + block) : len;
            int high = (start + 2 * block) < len ? (start + 2 * block) : len;
            //两个块的起始下标及结束下标
            int start1 = low, end1 = mid;
            int start2 = mid, end2 = high;
            //开始对两个block进行归并排序
            while (start1 < end1 && start2 < end2) {
              result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
            }
            while(start1 < end1) {
              result[low++] = arr[start1++];
            }
            while(start2 < end2) {
              result[low++] = arr[start2++];
            }
        }
        //将每次排序好的数组复制入原数组，进行下一次归并排序
	int[] temp = arr;
	arr = result;
	result = temp;
    }
    result = arr;       
}
