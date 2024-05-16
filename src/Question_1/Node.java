/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

/**
 *
 * @author xhu
 */
public class Node <E, F extends Comparable> implements Comparable <Node>{
    private E element; 
    private F key;     
    private Node<E, F> left; 
    private Node<E, F> right;
    public Node(E element, F key) {
        this.element = element;
        this.key = key;
        this.left = null;
        this.right = null;
    }


    // @Override
    // public int compareTo(Node t) {
    //     return 0;
    // }

    @Override
    public int compareTo(Node other) {
        // Compare nodes based on their keys
        return this.key.compareTo(other.key);
    }
    public E getElement() {
        return element;
    }

    public F getKey() {
        return key;
    }

    public Node<E, F> getLeft() {
        return left;
    }

    public Node<E, F> getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
