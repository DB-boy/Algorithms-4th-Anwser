package chapter1;

import edu.princeton.cs.algs4.StdRandom;
import linked.DoubleLinked;
import linked.SimpleLinked;
import queue.CircularLinkedQueue;
import util.ChapterUtil;
import static edu.princeton.cs.algs4.StdOut.*;

public class Chapter1_3ListExercises {

	public static void question18(){
		ChapterUtil.questionLue();
	}
	
	public static void question19(){
		SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
		for(int i = 0;i<3;i++){
			simpleLinked.addFirst(i);
		}
		println(simpleLinked);
		for(int i = 0;i<3;i++){
			simpleLinked.deleteLast();
			println(simpleLinked);
		}
	}

	public static void question20(){
		SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
		for(int i = 0;i<5;i++){
			simpleLinked.addFirst(i);
		}
		println(simpleLinked);
		simpleLinked.deleteForIndex(4);
		println(simpleLinked);
		simpleLinked.deleteForIndex(0);
		println(simpleLinked);
		simpleLinked.deleteForIndex(1);
		println(simpleLinked);
		simpleLinked.deleteForIndex(1);
		println(simpleLinked);
		simpleLinked.deleteForIndex(0);
		println(simpleLinked);
	}

	public static void question21(){
	    SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
	    for(int i = 0;i<5;i++){
	        simpleLinked.addFirst(i);
        }
		println(simpleLinked);
        int curr = 4;
        println("链表中"+(simpleLinked.find(simpleLinked.getFirst(),curr)?"存在":"不存在")+curr);
        curr = 6;
        println("链表中"+(simpleLinked.find(simpleLinked.getFirst(),curr)?"存在":"不存在")+curr);
        curr = 0;
        println("链表中"+(simpleLinked.find(simpleLinked.getFirst(),curr)?"存在":"不存在")+curr);
    }

    public static void question22(){
		ChapterUtil.questionLue();
	}

	public static void question23(){
		ChapterUtil.questionLue();
	}

	public static void question24(){
		SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
		for(int i = 0;i<5;i++){
			simpleLinked.addFirst(i);
		}
		println(simpleLinked);
		simpleLinked.removeAfter(simpleLinked.getItemForIndex(2));  //会把2以后的元素都删除
		println(simpleLinked);
		simpleLinked.removeAfter(simpleLinked.getFirst());  //把除first的元素都删除
		println(simpleLinked);
	}

	/**创建链表并填充测试数据*/
	private static SimpleLinked<Integer> createSimpleList(int start, int end){
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        for(int i = start;i<=end;i++){
            simpleLinked.addFirst(i);
        }
        return simpleLinked;
    }

	public static void question25(){
        SimpleLinked<Integer> simpleLinked = createSimpleList(0,5);
        SimpleLinked<Integer> simpleLinked2 = createSimpleList(6,10);
        simpleLinked.insertAfter(simpleLinked.getFirst(), simpleLinked2.getFirst());
        println(simpleLinked);

        simpleLinked = createSimpleList(0,5);
        simpleLinked2 = createSimpleList(6,10);
        simpleLinked.insertAfter(simpleLinked.getLast(), simpleLinked2.getFirst());
        println(simpleLinked);

        simpleLinked = createSimpleList(0,5);
        simpleLinked2 = createSimpleList(6,10);
        simpleLinked.insertAfter(simpleLinked.getItemForIndex(3), simpleLinked2.getFirst());
        println(simpleLinked);
    }

    public static void question26(){
		SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
		for(int i = 0;i<11;i++){
			if(i % 2 == 0){
				simpleLinked.addFirst(1);
			}else{
				simpleLinked.addFirst(i / 2);
			}
		}
		println(simpleLinked);
		simpleLinked.removeForKey(1);
		println(simpleLinked);

		simpleLinked.clearLink();
		for(int i = 0;i<10;i++){
			simpleLinked.addFirst(1);
		}
		println(simpleLinked);
		simpleLinked.removeForKey(1);
		println(simpleLinked);
	}

	public static void question27(){
		SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
		for(int i = 0;i<10;i++){
			int rand = StdRandom.uniform(20);
			print(rand + "  ");
			simpleLinked.addFirst(rand);
		}
		println();
		println("最大值："+ simpleLinked.max());
	}

    public static void question28(){
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        for(int i = 0;i<10;i++){
            int rand = StdRandom.uniform(20);
            print(rand + "  ");
            simpleLinked.addFirst(rand);
        }
        println();
        println("最大值："+ simpleLinked.max(simpleLinked.getFirst()));
    }

    public static void question29(){
        CircularLinkedQueue<Integer> circularLinkedQueue = new CircularLinkedQueue<>();
        for(int i = 0;i<20;i++){
            circularLinkedQueue.enqueue(i);
            if(StdRandom.bernoulli())
                println("出列:"+circularLinkedQueue.dequeue());
            println(circularLinkedQueue);  //打印轨迹
        }
    }

    public static void question30(){
        ChapterUtil.questionLue();
    }

    public static void question31(){
		DoubleLinked<Integer> doubleLinked = new DoubleLinked<>();
		String format = "%-9s:";
		for(int i = 0; i<3; i++){
			doubleLinked.insertFirst(i);
			printf(format,"在头部添加节点"+i);println(doubleLinked);
		}

		for(int i = 3;i<5;i++){
			doubleLinked.insertLast(i);
			printf(format,"在尾部添加节点"+i);println(doubleLinked);
		}

		for(int i = 0;i<3;i++){
			doubleLinked.deleteFirst();
			printf(format,"从头部删除节点");println(doubleLinked);
		}

		while(!doubleLinked.isEmpty()){
			doubleLinked.deleteLast();
			printf(format,"从尾部删除节点");println(doubleLinked);
		}

		for(int i = 0;i<5;i++){
			doubleLinked.insertLast(i);
		}
		printf(format,"重新构造单链表");println(doubleLinked);
		doubleLinked.insertItemForPre(doubleLinked.findNodeByIndex(0),10);
		printf(format,"在第一个元素前插入元素");println(doubleLinked);
		doubleLinked.insertItemForPre(doubleLinked.findNodeByIndex(2),15);
		printf(format,"在中间位置插入元素");println(doubleLinked);

		doubleLinked.insertItemForNext(doubleLinked.findNodeByIndex(4),20);
		printf(format,"在中间位置插入元素");println(doubleLinked);
		doubleLinked.insertItemForNext(doubleLinked.findNodeByIndex(7),25);
		printf(format,"在最后一个元素后插入元素");println(doubleLinked);

		while(!doubleLinked.isEmpty()){
			doubleLinked.deleteNode(doubleLinked.findNodeByIndex(0));
			printf(format,"删除第一个元素");println(doubleLinked);
		}
	}
}
