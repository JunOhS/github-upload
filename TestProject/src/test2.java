//2018112524 신준오 
//힙을 생성하고 생성한 힙을 이용하여 힙정렬을 하는 알고리즘 

public class test2 {

	public static void main(String[] args) {
		int[] A={4, 1, 3, 2, 16, 9, 10, 14, 8, 7}; //문제에 제시된 배열 A 선언 
		heapSort(A, A.length); //힙정렬을 통해 배열 A를 정렬한다
		for(int i=0; i<A.length; i++) { //힙정렬을 통해 정렬된 배열 A를 출력한다 
			System.out.print(A[i]+" "); 
		}
	}
	
	private static void heapSort(int[] a, int size) { //생성된 힙을 이용하는 힙정렬 메소드
		if(size<2) { //원소가 1개 이하인 경우 정렬을 할 필요가 없다 
			return;
		}
		
		int parentIdx=getParent(size-1); //가장 마지막 원소의 부모 인덱스 
		
		for(int i=parentIdx; i>=0; i--) { //먼저 힙정렬을 하기 위해서 정렬할 배열을 힙 생성 함수를 통해 heap으로 변환한다. Bottom-Up 형식이다. 
			makeHeap(a, i, size-1); 
		}
		
		for(int i=0; i<a.length; i++) { //생성된 힙을 일차원 배열로 출력한다 
			System.out.print(a[i]+" ");
		}
		System.out.println(); 
		
		for(int i=size-1; i>0; i--) { 
			swap(a, 0, i); //히프의 최대값을 제거하고
			makeHeap(a, 0, i-1); //남은 원소로 다시 히프를 재정비한다 
		}
	}
	
	private static void makeHeap(int[] a, int parentIdx, int lastIdx) { //힙 생성 함수
		int leftChildIdx; //왼쪽 자식노드 인덱스
		int rightChildIdx; //오른쪽 자식노드 인덱스  
		int largestIdx; //가장 큰 값을 가진 인덱스 
		
		while((parentIdx*2)+1<=lastIdx) { //현재 부모 인덱스의 왼쪽 자식노드 인덱스가 마지막 인덱스를 넘지 않을 때 까지 반복한다 
			leftChildIdx=(parentIdx*2)+1;
			rightChildIdx=(parentIdx*2)+2;
			largestIdx=parentIdx; //부모가 가장 큰 값을 가지고 있다고 가정한다 
			
			if(a[leftChildIdx]>a[largestIdx]) { //왼쪽 자식노드와 가장 큰 값을 비교하여 왼쪽 자식노드가 더 크다면   
				largestIdx=leftChildIdx; //가장 큰 값은 왼쪽 자식노드가 된다 
			}
			if(rightChildIdx<=lastIdx&&a[rightChildIdx]>a[largestIdx]) { //오른쪽 자식노드와 가장 큰 값을 비교하여 오른쪽 자식노드가 더 크다면
				largestIdx=rightChildIdx; //가장 큰 값은 오른쪽 자식노드가 된다. 이때 오른쪽 자식노드는 위에서 검사를 안했으므로 범위를 검사하여야한다  
			}
			if(largestIdx!=parentIdx) { //위에서 교환이 발생하였다면  
				swap(a, parentIdx, largestIdx); //두 원소를 교체하고
				parentIdx=largestIdx; //교환이 된 자식노드가 부모 노드가 되도록 한다
			}
			else {
				return;
			}
		}
	}
	
	private static int getParent(int child) { //부모의 인덱스를 얻는 메소드
		return (child-1)/2;
	}
	
	private static void swap(int[] a, int i, int j) { //두 인덱스의 원소를 교환하는 함수
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
