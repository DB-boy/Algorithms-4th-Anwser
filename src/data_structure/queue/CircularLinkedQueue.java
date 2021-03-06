package data_structure.queue;

import util.ChapterUtil;

import java.util.Iterator;

/**
 * 通过环形链表实现队列
 * 题目1.3.29
 */

public class CircularLinkedQueue<Item> implements Queue<Item> {

    public CircularLinkedQueue(){

    }

    /**
     * 队列的复制
     * 1.3.41
     * */
    public CircularLinkedQueue(CircularLinkedQueue<Item> circularLinkedQueues){
        int size = circularLinkedQueues.size();
        for(int i = 0; i< size; i++){
            Item item = circularLinkedQueues.dequeue();
            circularLinkedQueues.enqueue(item);
            this.enqueue(item);
        }
    }

    public Node last;
    private int count = 0;

    @Override
    public void enqueue(Item item) {
        if(last == null){
            last = new Node(item);
            last.next = last;
        }else{
            //与在头部添加元素的方法一样。
            last.next = new Node(item,last.next);
        }
        count++;
    }

    @Override
    public Item dequeue() {
        if(last == null){
            throw new RuntimeException("空队列不能出列");
        }
        Node index = null;
        for(index = last;index.next != last;index = index.next);   //找到last的上一个节点
        Item item = last.item;
        index.next = last.next;
        last = index;
        count--;
        if(count == 0){
            last = null;
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
    @Override
    public String toString() {
        return ChapterUtil.iterableToString(this);
    }
    @Override
    public Iterator<Item> iterator() {
        return new CircularLinkedQueueIterator();
    }

    private class CircularLinkedQueueIterator implements Iterator<Item>{

        private Node index = last.next;
        private int currCount = count;

        @Override
        public boolean hasNext() {
            return currCount != 0;
        }

        @Override
        public Item next() {
            Item item = index.item;
            index = index.next;
            currCount--;
            return item;
        }
    }

    public class Node{
        public Item getItem() {
            return item;
        }

        private Item item;
        private Node next;

        Node(Item item){
            this.item = item;
        }
        Node(Item item,Node next){
            this(item);
            this.next = next;
        }
    }
}
