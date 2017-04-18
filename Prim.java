public class MatrixUDG{
   
   private char[] mVexs;  //顶点集合
   private int[][] mMatrix;  //邻接矩阵
   private static final int INF = Integer.MAX_VALUE;
   
   /*
    构造函数
    用已提供的矩阵创建图
   */
   public MatrixUDG(char[] vexs , int[][] matrix){
       //初始化顶点数和边数，即顶点数组的长度
       int vlen = vexs.length;
       
       //初始化顶点数组
       mVexs = new char[vlen];
       for(int i=0; i<vlen; i++)
          mVexs[i] = vexs[i];
       
       //初始化边矩阵
       mMatrix = new int[vlen][vlen];
       for(int i=0; i<vlen; i++){
          for(int j=0; j<vlen; j++){
              mMatrix[i][j] = matrix[i][j];
          }
       }
       
       //计算有多少条边
       int vEdge = 0;
       for(int i=0; i<vlen; i++){
          for(int j=0; j<vlen; j++){
              if(mMatrix[i][j] != INF)
                 vEdge++;
          }
       }
   }
   
   /*
     prim最小生成树算法
     
     参数说明：
        start：从图中的第start个元素开始生成最小树
   */
   public void prim(int start){
      int num = mVexs.length;  //顶点个数
      int index = 0;    //prim最小树的索引，即prims数组中的索引
      char[] prims = new char[num];  //创建最小树数组，用于存储最小树中的顶点
      int[] weight = new int[num];   //创建权重数组，即当前顶点与其他顶点的边的权重
      
      //prims数组中的第一个顶点当然是起始顶点了
      prims[index++] = mVexs[start];
      
      //初始化顶点的权重数组
      //将每个顶点的权重初始化为 ‘第start个’ 顶点到 ‘该顶点’ 的权值
      for(int i=0; i<num; i++)
         weight[i] = mMatrix[start][i];
         
      //顶点start到start的权值应为0
      weight[start] = 0;
      
      //遍历num-1次，因为不用遍历start顶点，所以次数少一次
      for(int i=0; i<num; i++){
         if(i == start)   continue;
         
         int j =0;
         int k=0;
         int min = INF;
         //在未被加入最小树数组的所有顶点中，找出权值最小的顶点
         while(j<num){
            //若weight[j]==0,则说明第j个顶点已经被加入最小树数组中了
            if(weight[j] != 0 && weight[j] < min){
               min = weight[j];
               k = j;
            }
            j++;
         }
         
         //经过上面的处理后，在未被加入最小树的顶点中，权值最小的顶点就是滴K个顶点
         //将第K个顶点加入最小树的数组中
         prims[index++] = mVexs[k];
         //将第K个顶点的权值标记为0
         weight[k] = 0;
         
         //更新其他顶点的权值
         for(int i =0; i<num; i++){
            if(weight[i] != 0 && mMatrix[k][i] < weight[i]){
               weight[i] = mMatrix[k][i];
            }
         }
      }
      
      
   }
}
