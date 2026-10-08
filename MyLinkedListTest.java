import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyLinkedListTest {
    @Test
    public void testSize() {
        MyLinkedList<String> list = new MyLinkedList<>();

        assertEquals(0, list.size());
    }
}
