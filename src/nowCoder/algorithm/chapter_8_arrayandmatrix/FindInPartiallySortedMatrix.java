package nowCoder.algorithm.chapter_8_arrayandmatrix;

/**
 * ���ź����matrix���������Ƿ����
 * �У������ҵ���
 * �У����ϵ��µ���
 * @author snow
 *
 */
public class FindInPartiallySortedMatrix {
	/**
	 * 1���������򣬿��Դ������Ͻǻ��ߴ������½ǿ�ʼ��ѡ row = 0; column = length - 1;
	 * 2���Ƚϵ�ǰ��matrix[row][column] ��key�Ĺ�ϵ
	 *    ��ȣ�����true
	 *    ��key����Ϊ�����ÿһ�ж��ź��������ڵ�ǰ�����������У���ǰ���·���������key��
	 *  ��û�б�Ҫ�����ڵ�column�����ң�column = column - 1;�ظ�����2
	 *    ��keyС����Ϊ�����ÿһ�ж��ź������Ե�ǰ�����ڵ����У���ǰ���󷽵�������keyС
	 *  ��û�б�Ҫ�����ڵ�row�����ң�row = row + 1;�ظ�����2
	 * 3�����ֱ��Խ�綼û�з�����key�ҵ��������򷵻�false
	 * 
	 * 
	 * ����������
	 * 1������key�����ֵ����Сֵ��֮��
	 * 2��û�У��������ֵ��С����Сֵ��������֮�䣬����û��
	 * 3�����������ԣ���ָ������
	 * @param matrix
	 * @param number
	 * @return
	 */
	public boolean isContains(int[][] matrix, int key){
		int row = 0;
		int column = matrix[0].length - 1; //�����Ͻǿ�ʼ��
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
		FindInPartiallySortedMatrix fipsm = new FindInPartiallySortedMatrix();
		System.out.println(fipsm.isContains(fipsm.createMatrix(3, 4), 4));
	}
}
