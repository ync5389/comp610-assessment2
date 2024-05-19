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

/**
 *
 * @author xhu
 */
public class MemoManager<E extends Comparable<E>> {
    // public BinaryTree<Memo, Date> bTreeDate;
    // public BinaryTree<Memo, String> bTreeTitle;
    // private final BinaryTree<Date, Memo> bTreeDate;
    // private final BinaryTree<String, Memo> bTreeTitle;
    public BinaryTree bTreeDate;
    public BinaryTree bTreeTitle;
    public MemoManager(){
        this.bTreeDate = new BinaryTree<>();
        this.bTreeTitle = new BinaryTree<>();
    }

    
    
    public void addMemo(String date, String title, String message){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date parsedDate = dateFormat.parse(date);
            Memo memo = new Memo(parsedDate, title, message);
            // System.out.println(memo.message + memo.title+ memo.date);
            bTreeDate.add(memo, parsedDate);
            bTreeTitle.add(memo, title);
        } catch (ParseException ex) {
            Logger.getLogger(MemoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Memo findMemo(E key){     
        if (key instanceof Date) {
            // System.out.println("dateeee");
            return (Memo) bTreeDate.search(key);
        } else if (key instanceof String) {
            // System.out.println("strinngggg");
            return (Memo) bTreeTitle.search(key);

        } else {
            throw new IllegalArgumentException("Key must be either Date or String");
        }
    }
    
    public Memo[] getSortedMemoList(E key){        
        if (key instanceof Date) {
            
            List<Memo> memoList = new ArrayList<>();
            inOrderTraversal(bTreeDate.root, memoList);

            Memo[] sortedMemos = memoList.toArray(new Memo[0]);
            Arrays.sort(sortedMemos, (m1, m2) -> m1.date.compareTo(m2.date));

            return sortedMemos;
            
        } else if (key instanceof String) {
            
            List<Memo> memoList = new ArrayList<>();
            inOrderTraversal(bTreeTitle.root, memoList);

            Memo[] sortedMemos = memoList.toArray(new Memo[0]);
            Arrays.sort(sortedMemos, (m1, m2) -> m1.title.compareTo(m2.title));

            return sortedMemos;
            
        } else {
            throw new IllegalArgumentException("Key must be either Date or String");
        }


    }

    public Memo[] getSortedMemoListReverse(E key){        
        if (key instanceof Date) {
            
            List<Memo> memoList = new ArrayList<>();
            inOrderTraversal(bTreeDate.root, memoList);

            Memo[] sortedMemos = memoList.toArray(new Memo[0]);
            Arrays.sort(sortedMemos, (m1, m2) -> m2.date.compareTo(m1.date));

            return sortedMemos;
            
        } else if (key instanceof String) {
            
            List<Memo> memoList = new ArrayList<>();
            inOrderTraversal(bTreeTitle.root, memoList);

            Memo[] sortedMemos = memoList.toArray(new Memo[0]);
            Arrays.sort(sortedMemos, (m1, m2) -> m2.title.compareTo(m1.title));

            return sortedMemos;
            
        } else {
            throw new IllegalArgumentException("Key must be either Date or String");
        }
    }

    private void inOrderTraversal(Node<Memo, E> current, List<Memo> memoList) {
        if (current != null) {
            inOrderTraversal(current.getLeft(), memoList);
            memoList.add(current.getElement());
            inOrderTraversal(current.getRight(), memoList);
        }
    }
    
    public void reverseOrder(){
        bTreeDate.reverseOrder();
        bTreeTitle.reverseOrder();
    }    

}
