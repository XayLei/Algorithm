时间复杂度	 O(n^{2})
最优时间复杂度	 O(n)
平均时间复杂度	 O(n^{2})
空间复杂度	总共  O(n)，需要辅助空间  O(1)

伪代码：
function bubble_sort (array, length) {
    int i, j;
    for(i from 0 to length-1){
        for(j from 0 to length-1-i){
            if (array[j] > array[j+1])
                swap(array[j], array[j+1])
        }
    }
}
