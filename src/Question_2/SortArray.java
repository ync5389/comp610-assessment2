/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

/**
 *
 * @author xhu
 */
public class SortArray <E extends Comparable>{
    E[] array;
    public SortArray(E[] array){
        this.array = array;
    }
    
    public void setArray(E[] array){
        this.array = array;
    }
    
    public void quickSort(){
        quickSort(array, 0, array.length - 1);
    }
    
    private void quickSort(E[] list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private int partition(E[] list, int low, int high) {
        E pivot = list[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list[j].compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }
    
    private void swap(E[] list, int a, int b){
        E temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }    
}
