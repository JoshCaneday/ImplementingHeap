// import static org.junit.*;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

/**
 * HeapTest class implements tester that will test the methods from heap file
 */
public class HeapTest {

	@Test
	public void testAdd() {
		Comparator<Integer> maxHeapComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		Heap<Integer, String> heap = new Heap<Integer, String>(maxHeapComparator);
		heap.add(30, "1");
		heap.add(20, "2");
		heap.add(10, "3");
		
		heap.poll();
		assertEquals(2, heap.size());
	}
	@Test
	public void something() {
		Comparator maxHeapComparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		Heap<Integer, String> heap = new Heap<Integer, String>(maxHeapComparator);
		heap.add(30, "josh");
		assertEquals("30:josh", heap.peek().toString());
	}

}