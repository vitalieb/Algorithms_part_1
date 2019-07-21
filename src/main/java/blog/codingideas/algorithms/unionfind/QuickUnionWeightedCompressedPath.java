package blog.codingideas.algorithms.unionfind;

import java.util.Arrays;

public class QuickUnionWeightedCompressedPath extends UnionFind {

    QuickUnionWeightedCompressedPath(int numberOfElements) {
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

    private int rootOfElement(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];          // Single pass path compression by setting the root to grandparent
            i = id[i];
        }
        return i;

    }

    void printTreeSizes() {
        System.out.println("Nodes in trees: " + Arrays.toString(this.sizeOfTree));
    }
}
