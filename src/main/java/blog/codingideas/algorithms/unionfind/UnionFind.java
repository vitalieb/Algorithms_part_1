package blog.codingideas.algorithms.unionfind;

import java.util.Arrays;

public abstract class UnionFind {

    protected final int[] id;

    UnionFind(int numberOfElements) {
        id = new int[numberOfElements];
        for (int i = 0; i <= numberOfElements - 1; i++) {   //Because of this for loop the initialization takes N time
            id[i] = i;
        }
    }

    abstract void union(int p, int q);

    abstract boolean connected(int p, int q);

    public void displayIdArray() {
        System.out.println(Arrays.toString(this.id));
    }

}
