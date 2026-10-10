import static org.junit.jupiter.api.Assertions.*;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {

    @Test
    public void testConstructor() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddAndGet() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    public void testAddAtIndex() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(30);
        list.add(1, 20);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    public void testSet() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);

        assertEquals(20, list.set(1, 30));
        assertEquals(30, list.get(1));
    }

    @Test
    public void testRemove() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(20, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    public void testRemoveFirstAndLast() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(10, list.remove(0));
        assertEquals(30, list.remove(1));

        assertEquals(1, list.size());
        assertEquals(20, list.get(0));
    }

    @Test
    public void testClear() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIteratorForward() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        ListIterator<Integer> iterator = list.listIterator();

        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertEquals(20, iterator.next());
        assertEquals(30, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorBackward() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        ListIterator<Integer> iterator = list.listIterator();

        iterator.next();
        iterator.next();
        iterator.next();

        assertTrue(iterator.hasPrevious());
        assertEquals(30, iterator.previous());
        assertEquals(20, iterator.previous());
        assertEquals(10, iterator.previous());
        assertFalse(iterator.hasPrevious());
    }

}

