import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyLinkedListTest {
    @Test
    public void testSize() {
        MyLinkedList<String> list = new MyLinkedList<>();

        assertEquals(0, list.size());
    }

    @Test
    public void testAdd() {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add(0, "first");
        list.add(1, "last");
        list.add(1, "middle");
        list.add(0, "new first");
        list.add("new last");

        assertEquals(5, list.size());
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add(null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddNegativeIndex() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add(-1, "item");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexTooLarge() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add(1, "item");
    }

    @Test
    public void testAdd2() {
        MyLinkedList<String> list = new MyLinkedList<>();

        assertTrue(list.add("first"));
        assertTrue(list.add("second"));
        assertEquals(2, list.size());
    }

    @Test
    public void testSet() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(Integer.valueOf(2), list.set(1, 42));
        assertEquals(Integer.valueOf(42), list.get(1));
        assertEquals(3, list.size());
    }
}
