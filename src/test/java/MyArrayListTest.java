import com.itstep.fabiyanski.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {

    @Test
    public void getSizeTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.pushFront(9);
        Assert.assertTrue(myArrayList.getSize() == 1);
        myArrayList.pushBack(5);
        Assert.assertTrue(myArrayList.getSize() == 2);
    }

    @Test
    public void toStringTest() {
        MyArrayList<Double> newMyArrayList = new MyArrayList<Double>();
        newMyArrayList.pushFront(1.0);
        newMyArrayList.pushFront(2.0);
        newMyArrayList.pushFront(3.0);
        System.out.println(newMyArrayList.toString());
    }

    @Test
    public void pushBackTest() {
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.pushFront("Element");
        System.out.println("Before adding new element: " + myArrayList.toString());
        myArrayList.pushBack("Added_element");
        System.out.println("After adding new element to the end: " + myArrayList.toString());
    }

    @Test
    public void popFrontTest() {
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.pushFront("First_element");
        myArrayList.pushBack("Second_element");
        System.out.println("Before deleting first element: " + myArrayList.toString());
        myArrayList.popFront();
        System.out.println("After deleting first element: " + myArrayList.toString());
    }

    @Test
    public void pushFrontTest() {
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.pushFront("Element");
        System.out.println("Before adding new element to the beginning: " + myArrayList.toString());
        myArrayList.pushFront("Added_element");
        System.out.println("After adding new element to the beginning: " + myArrayList.toString());
    }

    @Test
    public void insertTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(5);
        System.out.println("Before inserting  elements: " + myArrayList.toString());
        myArrayList.insert(0, 1);
        System.out.println("After inserting new element to index number 0: " + myArrayList.toString());
        myArrayList.insert(4, 5);
        System.out.println("After inserting new element to index number 4: " + myArrayList.toString());
        myArrayList.insert(2, 3);
        System.out.println("After inserting new element to index number 2: " + myArrayList.toString());
        myArrayList.insert(2, 4);
        System.out.println("After inserting new element to index number 2: " + myArrayList.toString());
        myArrayList.insert(2, 2);
        System.out.println("After inserting new element to index number 2: " + myArrayList.toString());
        myArrayList.insert(2, 0);
        System.out.println("After inserting new element to index number 2: " + myArrayList.toString());
    }

    @Test
    public void removeAtTest() {
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.pushFront("First_element");
        myArrayList.pushBack("Second_element");
        System.out.println("Before removing element at index 0: " + myArrayList.toString());
        myArrayList.removeAt(0);
        System.out.println("After removing element at index 0: " + myArrayList.toString());
    }

    @Test
    public void removeTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(3);
        myArrayList.pushFront(3);
        myArrayList.pushBack(1);
        myArrayList.pushBack(5);
        System.out.println("Before removing: " + myArrayList.toString());
        myArrayList.remove(1);
        System.out.println("After removing: " + myArrayList.toString());
    }

    @Test
    public void removeAllTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(4);
        myArrayList.pushFront(3);
        myArrayList.pushBack(1);
        myArrayList.pushBack(1);
        myArrayList.pushBack(5);
        System.out.println("Before removing: " + myArrayList.toString());
        myArrayList.removeAll(1);
        System.out.println("After removing: " + myArrayList.toString());
    }

    @Test
    public void popBackTest() {
        MyArrayList<Double> myArrayList = new MyArrayList<Double>(3);
        myArrayList.pushFront(1.0);
        myArrayList.pushBack(2.0);
        myArrayList.pushBack(3.0);
        System.out.println("Before removing: " + myArrayList.toString());
        myArrayList.popBack();
        System.out.println("After removing: " + myArrayList.toString());
    }

    @Test
    public void clearTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(3);
        myArrayList.pushFront(1);
        myArrayList.pushBack(2);
        myArrayList.pushBack(3);
        System.out.println("Before clearing: " + myArrayList.toString());
        myArrayList.clear();
        System.out.println("After clearing: " + myArrayList.toString());
    }

    @Test
    public void isEmptyTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.pushFront(1);
        myArrayList.clear();
        Assert.assertTrue(myArrayList.isEmpty());
    }

    @Test
    public void trimToSizeTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.pushFront(3);
        myArrayList.pushBack(5);
        System.out.println("Before trimming to size: " + myArrayList.toString());
        myArrayList.trimToSize();
        System.out.println("After trimming to size: " + myArrayList.toString());
    }

    @Test
    public void indexOfTest() {
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.pushFront("first");
        myArrayList.pushBack("second");
        Assert.assertTrue(myArrayList.indexOf("first") == 0);
        Assert.assertTrue(myArrayList.indexOf("third") == -1);
    }

    @Test
    public void lastIndexOfTest() {
        MyArrayList<Double> myArrayList = new MyArrayList<Double>(3);
        myArrayList.pushFront(1.0);
        myArrayList.pushBack(2.0);
        Assert.assertTrue(myArrayList.lastIndexOf(2.0) == 2);
        Assert.assertTrue(myArrayList.indexOf(4.0) == -1);
    }

    @Test
    public void reverseTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(3);
        myArrayList.pushFront(1);
        myArrayList.pushBack(2);
        myArrayList.pushBack(3);
        System.out.println("Before reverse: " + myArrayList.toString());
        myArrayList.reverse();
        System.out.println("After reverse: " + myArrayList.toString());
    }

    @Test
    public void shuffleTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(5);
        myArrayList.pushFront(1);
        myArrayList.pushBack(2);
        myArrayList.pushBack(3);
        myArrayList.pushBack(4);
        myArrayList.pushBack(5);
        System.out.println("Before shuffle: " + myArrayList.toString());
        myArrayList.shuffle();
        System.out.println("After shuffle: " + myArrayList.toString());
    }

    @Test
    public void equalsTest() {
        MyArrayList<Integer> firstMyArrayList = new MyArrayList<Integer>();
        firstMyArrayList.pushFront(1);
        firstMyArrayList.pushBack(2);
        firstMyArrayList.pushBack(3);

        MyArrayList<Integer> secondMyArrayList = new MyArrayList<Integer>();
        secondMyArrayList.pushFront(1);
        secondMyArrayList.pushBack(2);
        secondMyArrayList.pushBack(3);

        Assert.assertTrue(firstMyArrayList.equals(secondMyArrayList));

        secondMyArrayList.pushBack(4);
        Assert.assertFalse(firstMyArrayList.equals(secondMyArrayList));
    }

    @Test
    public void getElementTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(2);
        myArrayList.pushFront(1);
        Assert.assertTrue(myArrayList.getElementAt(0) == 1);
    }

    @Test
    public void cloneTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.pushFront(1);
        MyArrayList<Integer> cloned = myArrayList.clone();
        Assert.assertNotNull(cloned);
        Assert.assertTrue(cloned.getSize() == 1);
        Assert.assertTrue(cloned.getCapacity() == 9);
        Assert.assertTrue(myArrayList.equals(cloned));
    }
}
