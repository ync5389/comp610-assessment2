/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author xhu
 */
public class BinaryTree <E extends Comparable<E>, Memo> {
    public Node<Memo, E> root; 
    int number_of_nodes = 0;
    // public BinaryTree(Node node){
    //     this.root = node;
    // }
    // public BinaryTree(Memo  element, E key){
    //     this.root = new Node<>(element, key);
    // }
    // public BinaryTree(){
    //     this.root = null; 
    // }
    
    public void add(Memo element, E key){
        root = addRecursive(root, element, key);
    }
    
    public Node<Memo, E> addRecursive(Node<Memo, E> current, Memo element, E key){     
        if (current == null) {
        number_of_nodes++;
            System.out.println(">>>>current<<<<"+number_of_nodes );
            System.out.println(">>>>key<<<<"+key);

            return new Node<Memo, E>(element, key);
        }

        int comparison = key.compareTo(current.key);
        System.out.println(">>>comparison"+ comparison);

        if (comparison < 0) {
            System.out.println(">>>left"+ current.left);
            current.left = addRecursive(current.left, element, key);
        } else if (comparison > 0) {
            System.out.println(">>>right"+ current.right);
            current.right = addRecursive(current.right, element, key);
        } else {
  
            current.element = element; 
            return current;
        }
        // return current;
        current.height = 1 + Math.max(height(current.left), height(current.right));
        return balance(current);
    }

    public Memo search(E key) {
        return searchRecursive(root, key);
    }
       
    public Memo searchRecursive(Node<Memo, E> current, E key) {
        if (current == null) {
            System.out.println(">>>>current<<<<"+ number_of_nodes);
            System.out.println(">>>>key<<<<"+key);

            return null;
        }
        
        int comparison = key.compareTo(current.key);
        System.out.println(">>>comparison"+ comparison);

       if (comparison < 0
        && current.left != null) {
            System.out.println(">>>left"+ current.left.key);
            return searchRecursive(current.left, key);
        } else if (comparison > 0
        && current.right != null) {
            System.out.println(">>>right"+ current.right.key);
            return searchRecursive(current.right, key);
        } else {
            System.out.println(">>>>key<<<<"+current.element);
            return current.element;
        }

        // int comparison = key.compareTo(current.key);
        // System.out.println(">>>comparison"+ comparison);
        // if (comparison == 0) {
        //     return current.element; 
        // } else if (comparison < 0) {
        //     return searchRecursive(current.left, key);
        // } else {
        //     return searchRecursive(current.right, key);
        // }
    }
    


    //for your debugging
    public void traversal(Node<Memo , E> current) {
        if (current != null) {
            traversal(current.getLeft());
            System.out.println(current.getElement() + " (" + current.getKey() + ")");
            traversal(current.getRight());
        }
    }
    
    public Node[] toSortedList(){
        Node<Memo , E>[] sortedNodes = new Node[number_of_nodes]; // Initialize the array
        toSortedList(root, sortedNodes, new AtomicInteger(0));
        return sortedNodes;
    }
    
    private void toSortedList(Node<Memo , E> current, Node<Memo , E>[] sortedNodes, AtomicInteger index) {
        if (current != null) {
            toSortedList(current.getLeft(), sortedNodes, index);
            sortedNodes[index.getAndIncrement()] = current;
            toSortedList(current.getRight(), sortedNodes, index);
        }
    }
    



    public void reverseOrder(){
        reverseOrderRecursive(root);
    }

    private void reverseOrderRecursive(Node<Memo , E> current) {
        if (current != null) {
            Node<Memo, E> temp = current.left;
            current.left = current.right;
            current.right = temp;

            reverseOrderRecursive(current.right);
            reverseOrderRecursive(current.left);
        }
    }




    private int height(Node<Memo, E> node) {
        if (node == null) return 0;
        return node.height;
    }

    private int getBalanceFactor(Node<Memo, E> node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private Node<Memo, E> balance(Node<Memo, E> node) {
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) >= 0) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) <= 0) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        return node;
    }

    private Node<Memo, E> rotateLeft(Node<Memo, E> node) {
        Node<Memo, E> x = node.right;
        Node<Memo, E> T2 = x.left;

        x.left = node;
        node.right = T2;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node<Memo, E> rotateRight(Node<Memo, E> y) {
        Node<Memo, E> x = y.left;
        Node<Memo, E> T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }
}
