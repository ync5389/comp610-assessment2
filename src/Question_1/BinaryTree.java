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
public class BinaryTree <E, F extends Comparable> {
    Node root; 
    int number_of_nodes;
    public BinaryTree(Node node){
        this.root = node;
    }
    
    public BinaryTree(E element, F key){
        this.root = new Node<>(element, key);
    }
    
    public BinaryTree(){
        this.root = null; 
    }
    
    public void addElement(E element, F key){
        Node<E, F> newNode = new Node<>(element, key);
        addNode(root, newNode);
    }
    
    public void addNode(Node current, Node newNode){        
        if (current == null) {
            root = newNode; // If the tree is empty, set the new node as the root
        } else {
            int comparison = newNode.getKey().compareTo(current.getKey());
            if (comparison < 0) {
                if (current.getLeft() == null) {
                    current.setLeft(newNode);
                } else {
                    addNode(current.getLeft(), newNode);
                }
            } else if (comparison > 0) {
                if (current.getRight() == null) {
                    current.setRight(newNode);
                } else {
                    addNode(current.getRight(), newNode);
                }
            }
            // If keys are equal, decide how to handle duplicates (e.g., ignore or update)
        }
    }
    
    //for your debugging
    public void traversal(Node<E, F> current) {
        if (current != null) {
            traversal(current.getLeft());
            System.out.println(current.getElement() + " (" + current.getKey() + ")");
            traversal(current.getRight());
        }
    }
    
    public Node[] toSortedList(){
        Node<E, F>[] sortedNodes = new Node[number_of_nodes]; // Initialize the array
        toSortedList(root, sortedNodes, new AtomicInteger(0));
        return sortedNodes;
    }
    
    private void toSortedList(Node<E, F> current, Node<E, F>[] sortedNodes, AtomicInteger index) {
        if (current != null) {
            toSortedList(current.getLeft(), sortedNodes, index);
            sortedNodes[index.getAndIncrement()] = current;
            toSortedList(current.getRight(), sortedNodes, index);
        }
    }
    
    public E searchElement(F key) {

        Node<E, F> targetNode = new Node<>(null, key);
        Node<E, F> foundNode = searchNode(root, targetNode);
        return (foundNode != null) ? foundNode.getElement() : null;
    }
       
    // public Node searchNode(Node root, Node node){
    //     return null;
    // }
    private Node<E, F> searchNode(Node current, Node target) {
        if (current == null) {
            return null; 
        }
        int comparison = target.getKey().compareTo(current.getKey());
        if (comparison == 0) {
            return current; 
        } else if (comparison < 0) {
            return searchNode(current.getLeft(), target);
        } else {
            return searchNode(current.getRight(), target);
        }
    }
    
    public void reverseOrder(){
        reverseOrder(root);
    }
    
    // private void reverseOrder(Node root){
    // }
    private void reverseOrder(Node<E, F> current) {
        if (current != null) {
            reverseOrder(current.getRight());
            System.out.println(current.getElement() + " (" + current.getKey() + ")");
            reverseOrder(current.getLeft());
        }
    }
       
}
