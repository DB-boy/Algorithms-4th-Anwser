package data_structure.graph.digraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Iterator;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 有向图
 */
public class Digraph {

    /**有向图的邻接表*/
    private Bag<Integer>[] adj;

    /**有向图顶点的个数*/
    private int v;

    /**有向图中有向边的个数*/
    private int e;

    public Digraph(int v){
        this.v = v;
        adj = (Bag<Integer>[]) new Bag[v];
        for(int i = 0;i<v;i++){
            adj[i] = new Bag<>();
        }
    }

    public Digraph(In in){
        //读取v
        this(in.readInt());
        //读取e
        int e = in.readInt();
        //读取后面的e对int
        for(int i = 0;i<e;i++){
            int a = in.readInt();
            int b = in.readInt();
            addEdge(a,b);
        }
    }

    /**4.2.3要求的构造方法*/
    public Digraph(Digraph digraph){
        this.v = digraph.v;
        this.e = digraph.e;
        this.adj = (Bag<Integer>[]) new Bag[v];
        for(int i = 0;i<v;i++){
            adj[i] = new Bag<>();
            for(int x : digraph.adj(i)){
                adj[i].add(x);
            }
        }
    }

    public void addEdge(int v,int w){
        if(v == w){ //不允许存在自环
            return;
        }
        if(hasEdge(v,w)){  //不允许存在平行边
            return;
        }
        adj[v].add(w);
        e++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.v + " vertices, " + this.e + " edges ");

        s.append("\r\n");
        for(int v = 0; v < this.v; ++v) {
            s.append(String.format("%d: ", new Object[]{Integer.valueOf(v)}));
            Iterator i$ = this.adj[v].iterator();

            while(i$.hasNext()) {
                int w = ((Integer)i$.next()).intValue();
                s.append(String.format("%d ", new Object[]{Integer.valueOf(w)}));
            }
            s.append("\r\n");
        }

        return s.toString();
    }

    public boolean hasEdge(int v,int w){
        for(int x : adj[v]){
            if(x == w){
                return true;
            }
        }
        return false;
    }

    public int V(){
        return v;
    }

    public int E(){
        return e;
    }

    public Digraph reverse(){
        Digraph d = new Digraph(v);
        for(int i = 0;i<v;i++){
            for(int w : adj[i]){
                d.addEdge(w,i);
            }
        }
        return d;
    }
}
