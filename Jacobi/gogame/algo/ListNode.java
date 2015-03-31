package gogame.algo;
/**
 * Utility Class of an SQL (Stack-Queue-List data structure)
 * @author Joshua
 */
public class ListNode{//ListNode is a node of the SQL
	public int x,y;
        /**
         * Goes to next node (if any)
         */
	ListNode next;
        /**
         * Goes to previous node (if any)
         */
	ListNode prev;
        /**
         * Class constructor for <code>ListNode</code> class
         * @param x x-coordinate
         * @param y y-coordinate
         */
	ListNode(int x,int y){
		this.x=x;
		this.y=y;
		next=prev=null;
        }
}
