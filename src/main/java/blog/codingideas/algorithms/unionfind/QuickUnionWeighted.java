package blog.codingideas.algorithms.unionfind;

import java.util.Arrays;

public class QuickUnionWeighted extends UnionFind {

    public QuickUnionWeighted(int numberOfElements) {
        super(numberOfElements);
        sizeOfTree = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            sizeOfTree[i] = 1;
        }
    }

    int[] sizeOfTree;

    @Override
    public void union(int p, int q) {
        int rootOfElementP = rootOfElement(p);
        int rootOfElementQ = rootOfElement(q);
        if (rootOfElementP != rootOfElementQ) {
            if (sizeOfTree[rootOfElementP] < sizeOfTree[rootOfElementQ]) {
                id[rootOfElementP] = rootOfElementQ;
                sizeOfTree[rootOfElementQ] += sizeOfTree[rootOfElementP];
            } else {
                id[rootOfElementQ] = rootOfElementP;
                sizeOfTree[rootOfElementP] += sizeOfTree[rootOfElementQ];
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {                // Because of this while loop the root check takes N-1 time
        return rootOfElement(p) == rootOfElement(q);
    }

    public int rootOfElement(int i) {                      // Because of this while loop the root check takes N-1 time
        while (id[i] != i) {
            i = id[i];
        }
        return i;

    }

    void printTreeSizes() {
        System.out.println("Nodes in trees: " + Arrays.toString(this.sizeOfTree));
    }
}
