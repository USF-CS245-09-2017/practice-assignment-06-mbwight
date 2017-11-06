public class BinaryHeap{
	private int[] arr = new int[1];
	private int size;
	public BinaryHeap(){
		size = 0;
	}
	// grow heap if necessary
	public void grow_heap(){
		int[] newarray = new int[arr.length*2];
		System.arraycopy(arr, 0, newarray, 0, arr.length);
		arr = newarray;
	}
	//add to end of priority queue. Compare number to 
	public void add(int priority){
		if(arr.length == size)
			grow_heap();
		arr[size++] = priority;
		int index = size-1;
		
		while(index > 0 && arr[index] < arr[parent(index)]){
			swap(arr,index,parent(index));
			index = parent(index);
		}
	}
	//methods used to find the index of the parent or its children
	public int parent(int index){
		return (index-1)/2;
	}
	
	public int left_child(int index){
		return index*2+1;
	}
	
	public int right_child(int index){
		return index*2+2;
	}
	
	public int remove(){
		int temp = arr[0];
		arr[0] = arr[--size];
		bubble_down(0);
		return temp;
	}
	
	public void bubble_down(int index){
		if(left_child(index) < size){
			int child = left_child(index);
			if(right_child(index) < size && arr[right_child(index)] < arr[child])
				child = right_child(index);
			if(arr[index] > arr[child])
				swap(arr,index,child);
			bubble_down(child);
		}
	}
	
	public void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}