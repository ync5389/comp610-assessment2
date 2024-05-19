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
public class Node <Memo, E extends Comparable<E>> implements Comparable <Node <Memo, E>>{
    Memo element; 
    E  key;     
    Node<Memo, E> left; 
    Node<Memo, E> right;
    int height; 
    public Node(Memo element, E  key) {
        this.element = element;
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 1;
    }


    // @Override
    // public int compareTo(Node t) {
    //     return 0;
    // }

    @Override
    public int compareTo(Node<Memo, E> other) {
        return this.key.compareTo(other.key);
    }
    public Memo getElement() {
        return element;
    }

    public E  getKey() {
        return key;
    }

    public Node<Memo, E> getLeft() {
        return left;
    }

    public Node<Memo, E> getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
