package blog.codingideas.algorithms.unionfind;

public class QuickUnion extends UnionFind {


    QuickUnion(int numberOfElements) {
        super(numberOfElements);
    }

    @Override
    public void union(int p, int q) {
////          Although it looks better this approach does too many calls
////          rootOfElement() being called way too many times
//
//        if (!connected(p, q)) {
//            id[rootOfElement(p)] = rootOfElement(q);
//        }

        int rootOfElementP = rootOfElement(p);
        int rootOfElementQ = rootOfElement(q);
        if(rootOfElementP!=rootOfElementQ){
            id[rootOfElementP] = rootOfElementQ;
        }
    }

    @Override
    public boolean connected(int p, int q) {                // Because of this while loop the root check takes N-1 time
        return rootOfElement(p) == rootOfElement(q);
    }

    private int rootOfElement(int i) {                      // Because of this while loop the root check takes N-1 time
        while (id[i] != i) {
            i = id[i];
        }
        return i;

    }
}
