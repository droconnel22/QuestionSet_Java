package binarytrees;


import com.binarytrees.BinaryTree;
import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(JUnitParamsRunner.class)
public class BinaryTreeTestFixture {

    private BinaryTree<Character> wordTree;

    @Before
    public void Before() {
        wordTree = new BinaryTree<>();
    }

    @Test
    public void GivenWord_MakeTree() throws  Exception{
        String word  = "the fat cat is fun to eat";
        word.replaceAll("\\s+","");

        List<Character> filteredSequence = word
                .chars()
                .mapToObj(c -> (char) c)
                .filter(i  -> i != ' ')
                .collect(Collectors.toList());


        for(char c : filteredSequence){
            wordTree.AddNode(c);
        }

        wordTree.PrintInOrder();
        System.out.println("---------");
        wordTree.PrintPreOrder();
    }
}
