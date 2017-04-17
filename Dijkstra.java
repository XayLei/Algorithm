//详细算法过程解释
//http://codefine.co/1665.html

 //利用邻接矩阵保存图中所有的边                     
 public class MatrixUDG{
     //边的数量
     private int mEdgeNum;
     //顶点集合
     private char[] mVexs;
     //邻接矩阵
     private int[][] mMatrix;
     //定义无穷大
     private static final int INF = Integer.MAX_VALUE;
     
     /*
      * 创建图：用已提供的矩阵
      * 参数说明：
      *       vexs:顶点数组
      *       matrix:矩阵
      */
      public MatrixUDG(char[] vexs, int[][] matrix){
          //初始化“顶点数”和“边数”
          int vlen = vexs.length;
          
          //初始化顶点
          mVexs = new char[vlen];
          for(int i=0; i<vlen; i++){
             mVexs[i] = vexs[i];
          }
          
          //初始化边
          mMatrix = new int[vlen][vlen];
          for(int i=0; i<vlen; i++){
              for(int j=0; j<vlen; j++){
                  mMatrix[i][j] = matrix[i][j];
              }
          }
          
          //统计边的数量
          int mEdgeNum = 0;
          for(int i =0; i<vlen; i++){
             for(int j=i+1; j<vlen; j++){
                if(mMatrix[i][j] != INF)
                     mEdgeNum++;
             }
          }
      }
      
      /*
	     * Dijkstra最短路径。
	     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
	     *
	     * 参数说明：
	     *       vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
	     *     prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，
	     *             位于"顶点i"之前的那个顶点。
	     *     dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
	     */
       public void dijkstra(int vs, int[] prev, int[] dist){
           //flag[i]=true表示“顶点vs”到“顶点i”的最短路径已成功获取
           boolean[] flag = new boolean[mVexs.length];
           
           //初始化
           for(int i =0; i<mVexs.length; i++){
               //顶点i的最短路径还没有获取到
               flag[i] = false;
               //顶点i的前驱节点为0
               prev[i] = 0;
               //顶点i的最短路径为顶点vs到顶点i的权
               dist[i] = mMatrix[vs][i];
           }
           
           //对起点vs进行初始化
           flag[vs] = true;
           dist[vs] = 0;
           
           //遍历mVexs.length-1次，每次找出一个顶点的最短路径
           int k=0;
           for(int i = 1; i<mVexs.length; i++){
               //寻找当前最小路径；
               //即在未获取最短路径的顶点中，找到离vs最近的顶点K
               int min = INF;
               for(int j=0; j<mVexs.length; j++){
                   if(flag[j]==false && dist[j]<min){
                       min = dist[j];
                       k=j;
                   }
               }
               
               //标记顶点k为已经获取到的最短路径
               flag[k] = true;
               
               //修正当前最短路径和前驱顶点
               // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
               for(int j = 0; j<mVexs.length; j++){
                  int tmp = (mMatrix[k][j]==INF? INF : min + mMatrix[k][j]);
                  if(flag[j]==false && (tmp<dist[j]) ){
                       dist[j] = tmp;
                       prev[j] = k;
                  }
               }             
           }
           
           //打印dijkstra的最短路径结果
           System.out.printf("dijkstra(%c): \n", mVexs[vs]);
               for(int i = 0; i<mVexs.length; i++){
                   System.out.printf("   shortest(%c, %c)=%d\n", mVexs[vs], mVexs[i], dist[i]);
               }
       }
       
       public static void main(String[] args) {
	        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
	        int matrix[][] = {
	                 /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
	          /*A*/ {   0,  12, INF, INF, INF,  16,  14},
	          /*B*/ {  12,   0,  10, INF, INF,   7, INF},
	          /*C*/ { INF,  10,   0,   3,   5,   6, INF},
	          /*D*/ { INF, INF,   3,   0,   4, INF, INF},
	          /*E*/ { INF, INF,   5,   4,   0,   2,   8},
	          /*F*/ {  16,   7,   6, INF,   2,   0,   9},
	          /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
	        MatrixUDG pG;

	        // 采用已有的"图"
	        pG = new MatrixUDG(vexs, matrix);

	        int[] prev = new int[pG.mVexs.length];
	        int[] dist = new int[pG.mVexs.length];
	        // dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
	        pG.dijkstra(3, prev, dist);
	    }
 }
