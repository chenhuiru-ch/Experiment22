package bao;
/**
任务3-4
用户能够自主选择动态规划算法、回溯算法求解指定D{0-1} KP数据的最优解和求解时间（以秒为单位）
**/
public class Time {
    public static void main(String[] args) {
    	//物品的重量
        int[] w={508,1021,1321,111,1098,1196,204,939,1107,399,474,719,803,1054,1781,525,1050,1362,530,641,903,432,583,894,754,806,1241,1056,1092,1545};
        //物品的价值
        int[] val={408,921,1329,11,998,1009,104,839,943,299,374,673,703,954,1657,425,950,1375,430,541,971,332,483,815,654,706,1360,956,992,1948};
        
        int m=10149;//背包的容量
        int n=val.length;//物品的个数

        //1.创建二维数组
        //v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v=new int[n+1][m+1];
        //存放记录数组
        int[][] path=new int[n+1][m+1];

        //2.初始化第一行第一列（已经处理了，因为默认是0）
        //3.根据公式来动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                //公式
                if(w[i-1]>j){//因为我们程序i是从1开始的，因此原来的公式中的w[i]修改成w[i-1]
                    v[i][j]=v[i-1][j];
                }else{
                    //v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if(v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j]=1;
                    }else{
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }

        
        //打印结果：
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j]+" ");
            } 
        }


        
        //最后一次存放进背包的组合：
        System.out.println("最优解为：");
        int i=path.length-1;//行的最大下标
        int j=path[0].length-1;//列的最大下标

        while (i>0&&j>0){
            if(path[i][j]==1){
                System.out.printf("第%d个商品放入到背包\n",i);
                j-=w[i-1];
            }
            i--;
        }
    }
}

