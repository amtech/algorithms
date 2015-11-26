package nowCoder.algorithm.array;

/**
 * 从矩阵的最外层顺时针循环打印edge
 * spiral 螺旋
 * @author snow
 *
 */
public class PrintMatrixEdge {
	public void spiralOrderPrint(int[][] matrix){
		/**
		 * 矩阵中用左上角的坐标(tR, rC)和右下角的坐标(dR, dC)就可以表示一个子矩阵
		 * (row, column)
		 * 如果左上角的坐标跑到右下角坐标的右方或者下方，打印结束
		 */
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;//行数
		int dC = matrix[0].length - 1;//列数
		while (tR <= dR && tC <= dC){
			printEdge(matrix, tR++, tC++, dR--, dC--);
			System.out.print(" love ");
		}
	}

	private void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
		if (tR == dR){//如果子矩阵只有一行时
			for (int i = 0; i < dC; i++) {
				System.out.print(matrix[tR][i] + " ");//如果不是println，则括号里面必须要有参数
			}
		} else if (tC == dC){//子矩阵只有一列
			for (int i = 0; i < dR; i++) {
				System.out.print(matrix[i][tC] + " ");
			}
		} else {//一般情况  就用四个循环，打印矩阵的四个边
			int curC = tC;
			int curR = tR;
			while (curC != dC){
				System.out.print(matrix[tR][curC] + " ");
				curC++;
			}
			while (curR != dR){
				System.out.print(matrix[curR][dC] + " ");
				curR++;
			}
			while (curC != tC){
				System.out.print(matrix[dR][curC] + " ");
				curC--;
			}
			while (curR != tR){
				System.out.print(matrix[curR][tC] + " ");
				curR--;
			}
		}
	}
	
	public int[][] createMatrix(int m, int n){
		int[][] matrix = new int[m][n];//需要申请空间
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++){
				matrix[i][j] = i + j;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix;
	}
	public static void main(String[] args) {
		PrintMatrixEdge pme = new PrintMatrixEdge();
		pme.spiralOrderPrint(pme.createMatrix(3, 3));
	}
}
