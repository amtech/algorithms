package nowCoder.algorithm.list;

/**
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * @author snow
 *
 */
public class MergeList {
	
	/**
	 * �õ�����������ֵ��С�Ľ�㣬���������ӵ��Ѿ��ϲ�������֮��
	 * ʣ�µĽ����Ȼ���ź���ģ��ϲ��������ƣ�   �ݹ�
	 * Ҫ�Կ�������е����Ĵ���
	 * 	���һ������Ϊ����������Ϊ��һ������
	 * 	������������ǿ��������Ϊnull
	 */
	public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null){
        	return list2;//�����ʱlist2ҲΪnull���������null
        }else if (list2 == null){
        	return list1;//�Ѿ���������������Ϊnull��������������null
        }
        ListNode mergeHead = null;
        if (list1.val < list2.val){
        	mergeHead = list1;
        	mergeHead.next = Merge(list1.next, list2);
        }else {
        	mergeHead = list2;
        	mergeHead.next = Merge(list1, list2.next);
        }
        return mergeHead;
    }
}
