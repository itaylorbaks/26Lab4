import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class MyLinkedList_MyLinkedListIteratorTest {

	@Test
	public void testAdd() {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		MyLinkedList.MyLinkedListIterator<Integer> it = list.new MyLinkedListIterator();
		list.add(10);
		list.add(20);
		it = list.listIterator();
		it.add(15);
		assertEquals(Integer.valueOf(15), list.get(1));
	}

	@Test
	public void testHasNext() {
		MyLinkedList<String> list = new MyLinkedList<>();
		MyLinkedList.MyLinkedListIterator<String> it = list.listIterator();
		assertFalse(it.hasNext());
		list.add("a");
		it = list.listIterator();
		assertTrue(it.hasNext());
	}

	@Test
	public void testHasPrevious() {
		MyLinkedList<String> list = new MyLinkedList<>();
		MyLinkedList.MyLinkedListIterator<String> it = list.listIterator();
		assertFalse(it.hasPrevious());
		list.add("a");
		it = list.listIterator();
		it.next();
		assertTrue(it.hasPrevious());
	}

	@Test
	public void testNext() {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add("a");
		list.add("b");
		MyLinkedList.MyLinkedListIterator<String> it = list.listIterator();
		assertEquals("a", it.next());
		assertEquals("b", it.next());
	}

	@Test
	public void testNextIndex() {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add("a");
		list.add("b");
		MyLinkedList.MyLinkedListIterator<String> it = list.listIterator();
		assertEquals(0, it.nextIndex());
		it.next();
		assertEquals(1, it.nextIndex());
	}

	@Test
	public void testPrevious() {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add("a");
		list.add("b");
		MyLinkedList.MyLinkedListIterator<String> it = list.listIterator();
		it.next();
		assertEquals("a", it.previous());
	}

	@Test
	public void testPreviousIndex() {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add("a");
		list.add("b");
		MyLinkedList.MyLinkedListIterator<String> it = list.listIterator();
		assertEquals(-1, it.previousIndex());
		it.next();
		assertEquals(0, it.previousIndex());
	}

	@Test
	public void testRemove() {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		list.add(10);
		list.add(20);
		MyLinkedList.MyLinkedListIterator<Integer> it = list.listIterator();
		it.next();
		it.remove();
		assertEquals(1, list.size());
		assertEquals(Integer.valueOf(20), list.get(0));
	}

	@Test
	public void testSet() {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		list.add(10);
		list.add(20);
		MyLinkedList.MyLinkedListIterator<Integer> it = list.listIterator();
		it.next();
		assertEquals(Integer.valueOf(10), it.set(15));
		assertEquals(Integer.valueOf(15), list.get(0));
	}
}
