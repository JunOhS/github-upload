//2018112524 ���ؿ� 
//���� �����ϰ� ������ ���� �̿��Ͽ� �������� �ϴ� �˰��� 

public class test2 {

	public static void main(String[] args) {
		int[] A={4, 1, 3, 2, 16, 9, 10, 14, 8, 7}; //������ ���õ� �迭 A ���� 
		heapSort(A, A.length); //�������� ���� �迭 A�� �����Ѵ�
		for(int i=0; i<A.length; i++) { //�������� ���� ���ĵ� �迭 A�� ����Ѵ� 
			System.out.print(A[i]+" "); 
		}
	}
	
	private static void heapSort(int[] a, int size) { //������ ���� �̿��ϴ� ������ �޼ҵ�
		if(size<2) { //���Ұ� 1�� ������ ��� ������ �� �ʿ䰡 ���� 
			return;
		}
		
		int parentIdx=getParent(size-1); //���� ������ ������ �θ� �ε��� 
		
		for(int i=parentIdx; i>=0; i--) { //���� �������� �ϱ� ���ؼ� ������ �迭�� �� ���� �Լ��� ���� heap���� ��ȯ�Ѵ�. Bottom-Up �����̴�. 
			makeHeap(a, i, size-1); 
		}
		
		for(int i=0; i<a.length; i++) { //������ ���� ������ �迭�� ����Ѵ� 
			System.out.print(a[i]+" ");
		}
		System.out.println(); 
		
		for(int i=size-1; i>0; i--) { 
			swap(a, 0, i); //������ �ִ밪�� �����ϰ�
			makeHeap(a, 0, i-1); //���� ���ҷ� �ٽ� ������ �������Ѵ� 
		}
	}
	
	private static void makeHeap(int[] a, int parentIdx, int lastIdx) { //�� ���� �Լ�
		int leftChildIdx; //���� �ڽĳ�� �ε���
		int rightChildIdx; //������ �ڽĳ�� �ε���  
		int largestIdx; //���� ū ���� ���� �ε��� 
		
		while((parentIdx*2)+1<=lastIdx) { //���� �θ� �ε����� ���� �ڽĳ�� �ε����� ������ �ε����� ���� ���� �� ���� �ݺ��Ѵ� 
			leftChildIdx=(parentIdx*2)+1;
			rightChildIdx=(parentIdx*2)+2;
			largestIdx=parentIdx; //�θ� ���� ū ���� ������ �ִٰ� �����Ѵ� 
			
			if(a[leftChildIdx]>a[largestIdx]) { //���� �ڽĳ��� ���� ū ���� ���Ͽ� ���� �ڽĳ�尡 �� ũ�ٸ�   
				largestIdx=leftChildIdx; //���� ū ���� ���� �ڽĳ�尡 �ȴ� 
			}
			if(rightChildIdx<=lastIdx&&a[rightChildIdx]>a[largestIdx]) { //������ �ڽĳ��� ���� ū ���� ���Ͽ� ������ �ڽĳ�尡 �� ũ�ٸ�
				largestIdx=rightChildIdx; //���� ū ���� ������ �ڽĳ�尡 �ȴ�. �̶� ������ �ڽĳ��� ������ �˻縦 �������Ƿ� ������ �˻��Ͽ����Ѵ�  
			}
			if(largestIdx!=parentIdx) { //������ ��ȯ�� �߻��Ͽ��ٸ�  
				swap(a, parentIdx, largestIdx); //�� ���Ҹ� ��ü�ϰ�
				parentIdx=largestIdx; //��ȯ�� �� �ڽĳ�尡 �θ� ��尡 �ǵ��� �Ѵ�
			}
			else {
				return;
			}
		}
	}
	
	private static int getParent(int child) { //�θ��� �ε����� ��� �޼ҵ�
		return (child-1)/2;
	}
	
	private static void swap(int[] a, int i, int j) { //�� �ε����� ���Ҹ� ��ȯ�ϴ� �Լ�
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
