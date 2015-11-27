package nowCoder.algorithm.array;

/**
 * �Ӿ���������˳ʱ��ѭ����ӡedge
 * spiral ����
 * @author snow
 *
 */
public class PrintMatrixEdge {
	public void spiralOrderPrint(int[][] matrix){
		/**
		 * �����������Ͻǵ�����(tR, rC)�����½ǵ�����(dR, dC)�Ϳ��Ա�ʾһ���Ӿ���
		 * (row, column)
		 * ������Ͻǵ������ܵ����½�������ҷ������·�����ӡ����
		 */
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;//����
		int dC = matrix[0].length - 1;//����
		while (tR <= dR && tC <= dC){
			printEdge(matrix, tR++, tC++, dR--, dC--);
			System.out.print(" love ");
		}
	}

	private void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
		if (tR == dR){//����Ӿ���ֻ��һ��ʱ
			for (int i = 0; i < dC; i++) {
				System.out.print(matrix[tR][i] + " ");//�������println���������������Ҫ�в���
			}
		} else if (tC == dC){//�Ӿ���ֻ��һ��
			for (int i = 0; i < dR; i++) {
				System.out.print(matrix[i][tC] + " ");
			}
		} else {//һ�����  �����ĸ�ѭ������ӡ������ĸ���
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
		int[][] matrix = new int[m][n];//��Ҫ����ռ�
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
