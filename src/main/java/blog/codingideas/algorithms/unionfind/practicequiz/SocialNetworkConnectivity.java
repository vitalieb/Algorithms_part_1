package blog.codingideas.algorithms.unionfind.practicequiz;

import blog.codingideas.algorithms.unionfind.QuickUnionWeighted;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.Arrays.sort;

public class SocialNetworkConnectivity {


    public static void main(String[] args) throws IOException, URISyntaxException {

        TreeSet<Integer> members = new TreeSet<>();
        Path path = Paths.get(ClassLoader.getSystemResource("SocialNetwork.txt").toURI());
        Stream<String> lines = Files.lines(path);
        lines.forEach(line -> {
            String[] s = line.split(" ");
            if (s.length == 3) {
                members.add(Integer.parseInt(s[1]));
                members.add(Integer.parseInt(s[2]));
            }
        });

        Integer[] membersArray = members.toArray(new Integer[0]);


        QuickUnionWeightedWithTreesCountCheck unionFind = new QuickUnionWeightedWithTreesCountCheck(membersArray.length);
        Stream<String> txtFileLines = Files.lines(path);
        final boolean[] timeShown = {false};
        txtFileLines.forEach(line -> {
            String[] s = line.split(" ");
            if (s.length == 3) {
                unionFind.union(Integer.parseInt(s[1]), Integer.parseInt(s[2]));

                for (int i = 0; i < 10; i++) {
                    System.out.print(unionFind.rootOfElement(i) + " ");
                }
                System.out.println();
                if (unionFind.structureHasSingleTree()) {
                    if(!timeShown[0]){
                        System.out.println("Timestamp of friendship is: " + s[0]);
                        timeShown[0] =true;
                    }
                }
            }
        });

    }


}
