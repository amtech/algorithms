package nowCoder.algorithm.chapter_8_arrayandmatrix;

/**
 * 在排好序的matrix中找数字是否存在
 * 行：从左到右递增
 * 列：从上到下递增
 * @author snow
 *
 */
public class FindInPartiallySortedMatrix {
	/**
	 * 1、两个方向，可以从最右上角或者从最左下角开始赛选 row = 0; column = length - 1;
	 * 2、比较当前数matrix[row][column] 与key的关系
	 *    相等，返回true
	 *    比key大，因为矩阵的每一列都排好序，所以在当前数所处的列中，当前数下方的数都比key大
	 *  则没有必要继续在第column列上找，column = column - 1;重复步骤2
	 *    比key小，因为矩阵的每一行都排好序，所以当前数所在的行中，当前数左方的数都比key小
	 *  则没有必要继续在第row行上找，row = row + 1;重复步骤2
	 * 3、如果直到越界都没有发现与key找到的数，则返回false
	 * 
	 * 
	 * 测试用例：
	 * 1、包含key，最大值，最小值，之间
	 * 2、没有，大于最大值，小于最小值，或者在之间，但是没有
	 * 3、特殊出入测试，空指针例如
	 * @param matrix
	 * @param number
	 * @return
	 */
	public boolean isContains(int[][] matrix, int key){
		int row = 0;
		int column = matrix[0].length - 1; //从右上角开始找
		while (row < matrix.length && column > -1){
			if (matrix[row][column] == key){
				return true;
			} else if (matrix[row][column] > key){
				column--;
			} else {
				row++;
			}
		}
		return false;
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
		FindInPartiallySortedMatrix fipsm = new FindInPartiallySortedMatrix();
		System.out.println(fipsm.isContains(fipsm.createMatrix(3, 4), 4));
	}
}
