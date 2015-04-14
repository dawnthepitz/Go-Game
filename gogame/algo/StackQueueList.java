package gogame.algo;

/**
 * SQL=Stack-Queue-List, an overall linear data structure that has generic
 * operations, Some methods are of same function yet of same purpose so that it
 * would be friendly to fellow programmers to identify the data structure based
 * on utilized operations
 *
 * @author Josh
 */
public class StackQueueList {
    /**
     * Initializes the head, tail and the utility pointer
     */
    private ListNode head, tail, util;
    /**
     * Class constructor for <code>SQL</code> class
     */
    public StackQueueList() {
        head = tail = null;
    }

    /**
     * Used for array-like indexing
     * @param x
     * @return 
     */
    public ListNode traverse(int x) {
        int temp = 0;
        ListNode util = head;
        for (; temp < x && util != null; util = util.next) {
            temp++;
        }
        return util;
    }

    /**
     * Adds an element to the list
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void add(int x, int y) {
        util = new ListNode(x, y);
        if (head == null) {
            head = tail = util;
        } else {
            tail.next = util;
            util.prev = tail;
            tail = util;
        }
    }

    /**
     * For formality purposes, using the LLs as a Queue
     * @param x
     * @param y 
     */
    void enqueue(int x, int y) {
        add(x, y);
    }

    /**
     * for formality purposes, using the LLs as a Stack
     * @param x
     * @param y 
     */
    void push(int x, int y) {
        add(x, y);
    }

    /**
     * Gets the <code>ListNode</code> which contains the data being searched
     * @param x
     * @param y
     * @return 
     */
    ListNode search(int x, int y) {
        for (ListNode util = head; util != null; util = util.next) {
            if (util.x == x && util.y == y) {
                return util;
            }
        }
        return null;
    }

    /**
     * Identifies if the data being searched is in the list
     * @param x
     * @param y
     * @return 
     */
    public boolean isInList(int x, int y) {
        for (ListNode util = head; util != null; util = util.next) {
            if (util.x == x && util.y == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removal of data in Linked Lists
     * @param x
     * @param y 
     */
    public void delete(int x, int y) {
        for (ListNode util = head; util != null; util = util.next) {
            if (x == util.x && y == util.y) {
                if (util == head) {
                    dequeue();
                } else if (util == tail) {
                    pop();
                } else {
                    util.next.prev = util.prev;
                    util.prev.next = util.next;
                }
            }
        }
    }

    /**
     * Utility method to return the <code>head</code>
     * @return <code>head</code> of the list
     */
    ListNode head() {
        return head;
    }

    /**
     * Utility method to return the <code>tail</code>
     * @return <code>tail</code> of the list
     */
    ListNode tail() {
        return tail;
    }

    /**
     * Utility method to return the <code>front</code>
     * @return <code>front</code> of the queue
     */
    ListNode front() {
        return head;
    }

    /**
     * Utility method to return the <code>rear</code>
     * @return <code>rear</code> of the queue
     */
    ListNode rear() {
        return tail;
    }

    /**
     * Utility method to return the <code>bottom</code>
     * @return 
     */
    ListNode bottom() {
        return head;
    }
    /**
     * Utility method to return the <code>top</code>
     * @return <code>top</code> of the stack
     */
    ListNode top() {
        return tail;
    }//stack tail

    /**
     * Determines if the data structure is empty
     * @return <code>true</code> if data structure is empty, else <code>false</code>
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Clears all data in the data structure
     */
    public void clear() {//Removal of data in Linked Lists
        for (ListNode x = head; x != tail; x = x.next) {
            head = head.next;
            x = null;
        }
        head = tail = null;
    }

    /**
     * Stack removal operation
     */
    public void pop() {
        if (!isEmpty()) {
            tail = tail.prev;
            tail.next = null;
        }
    }

    /**
     * Queue removal operation
     */
    public void dequeue() {
        if (!isEmpty()) {
            head = head.next;
            head.prev = null;
        }
    }

    /**
     * Counts how many nodes are in existence in the data structure
     * @return length of the data structure
     */
    public int length() {
        int x = 0;
        for (ListNode util = head; util != null; util = util.next) {
            x++;
        }
        return x;
    }
}