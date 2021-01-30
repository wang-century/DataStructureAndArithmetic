public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始二维数组 11*11
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 输出二维数组
        System.out.println("原始二维数组");
        for(int[] row:chessArr1){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        // 将二维数组转稀疏数组
        int sparseArray[][] = arrayToSparseArray(chessArr1);
        // 输出稀疏数组
        System.out.println("得到稀疏数组：");
        for(int i=0;i<sparseArray.length;i++){
            for(int j=0;j<sparseArray[0].length;j++){
                System.out.printf("%d\t",sparseArray[i][j]);
            }
            System.out.println();
        }

        // 将稀疏数组转二维数组
        int basArray2[][] = sparseArrayToArray(sparseArray);
        // 输出结果
        System.out.println("转回二维数组：");
        for(int[] data:basArray2){
            for(int d:data){
                System.out.printf("%d\t",d);
            }
            System.out.println();
        }
    }

    public static int[][] arrayToSparseArray(int[][] basArray){
        /* 将普通二维数组转稀疏数组 */
        // 1.先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for(int i=0;i<basArray.length;i++){
            for(int j=0;j<basArray[0].length;j++){
                if(basArray[i][j]!=0){
                    sum++;
                }
            }
        }
        // System.out.printf("非0元素个数:%d\n",sum);
        // 2.创建对应的稀疏数组
        int sparseArray[][] = new int[sum+1][3];
        // 3.给稀疏数组赋值
        sparseArray[0][0] = 11;     // 行
        sparseArray[0][1] = 11;     // 列
        sparseArray[0][2] = sum;    // 非0数据的个数
        // 4.遍历二维数组，将非0的值存放到sparseArray中
        int count = 0;  // 用于记录非0数据索引
        for(int i=0;i<basArray.length;i++){
            for(int j=0;j<basArray[0].length;j++){
                if(basArray[i][j]!=0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = basArray[i][j];
                }
            }
        }
        return sparseArray;
    }

    public static int[][] sparseArrayToArray(int[][] sparseArray){
        /* 将稀疏数组转普通二维数组 */
        int row = sparseArray[0][0];
        int col = sparseArray[0][1];
        int[][] basArray = new int[row][col];
        for(int i=1;i<sparseArray.length;i++){
            basArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return basArray;
    }
}
