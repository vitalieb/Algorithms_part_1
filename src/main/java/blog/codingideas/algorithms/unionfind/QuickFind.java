package blog.codingideas.algorithms.unionfind;

public class QuickFind extends UnionFind {

    QuickFind(int numberOfElements) {
        super(numberOfElements);
    }

    @Override
    public void union(int p, int q) {
        if (!connected(p, q)) {
            for (int i = 0; i < id.length; i++) {           //Because of this for loop the union takes N time
                if (id[i] == id[p]) {
                    id[i] = id[q];
                }
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];                              //Time of connected check is constant: 1
    }
}
