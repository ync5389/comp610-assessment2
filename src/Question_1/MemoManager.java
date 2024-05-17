/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.tree.TreeNode;

/**
 *
 * @author xhu
 */
public class MemoManager<E extends Comparable> {
    public BinaryTree bTreeDate;
    public BinaryTree bTreeTitle;
    
    
    public void addMemo(String date, String title, String message){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Memo memo = new Memo();
        try {
            //converting a string to date
            memo.date = dateFormat.parse(date);
            memo.title = title;
            memo.message = message;
        } catch (ParseException ex) {
            Logger.getLogger(MemoManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        addToTree(memo, memo.date);
    }
    
    public void addToTree(Memo memo, Date key){        
        
        if (bTreeDate == null) {
            bTreeDate = new BinaryTree(memo, key);
        } else {
            bTreeDate.addElement(memo, key);
        }
    }
    
    public Memo findMemo(E key){        
        // if (bTreeDate == null 
        // || bTreeTitle == null) {
        //     return null; 
        // }
        // if (bTreeTitle == null) {
        //     return null; 
        // }
        Node currentNode = null;
        if (key instanceof String) {
            currentNode = bTreeTitle.root;
        } else if (key instanceof Date) {
            currentNode = bTreeDate.root;
        }
        // Node currentNode = bTreeTitle.root;
        while (currentNode != null) {
            int comparison = key.compareTo(currentNode.getKey());
            System.out.println(comparison + "ccccc");
            
            if (comparison == 0) {
                return (Memo) currentNode.getKey();
            } else if (comparison < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }


        // Memo memo = new Memo();
        //     // memo.date = dateFormat.parse(currentNode.date);
        //     memo.title = (String) currentNode.key;
        //     memo.message = (String) currentNode.element;
        //     System.out.println(memo.title + "<<<<><>");
        return null;
    
    }
    
    public Memo[] getSortedMemoList(E key){        
        if (bTreeDate == null) {
            return new Memo[0]; // Empty array if no memos
        }

        // Collect memos during an in-order traversal
        List<Memo> memoList = new ArrayList<>();
        inOrderTraversal(bTreeDate.root, memoList);

        // Sort the memos based on the specified key
        Memo[] sortedMemos = memoList.toArray(new Memo[0]);
        Arrays.sort(sortedMemos, (m1, m2) -> m1.date.compareTo(m2.date));

        return sortedMemos;
    }

    private void inOrderTraversal(Node<Memo, E> current, List<Memo> memoList) {
        if (current != null) {
            inOrderTraversal(current.getLeft(), memoList);
            memoList.add(current.getElement());
            inOrderTraversal(current.getRight(), memoList);
        }
    }
    
    public void reverseOrder(){
        if (bTreeDate != null) {
            reverseSubtreeOrder(bTreeDate.root);
        }
        if (bTreeTitle != null) {
            reverseSubtreeOrder(bTreeTitle.root);
        }
    }    

    private void reverseSubtreeOrder(Node<Memo, ?> current) {
        if (current != null) {
            // Swap left and right subtrees
            Node<Memo, ?> temp = current.getLeft();
            current.setLeft(current.getRight());
            current.setRight(temp);
    
            // Recurse for left and right subtrees
            reverseSubtreeOrder(current.getLeft());
            reverseSubtreeOrder(current.getRight());
        }
    }
}
