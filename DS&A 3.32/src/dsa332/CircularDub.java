package dsa332;

import java.util.*;

public class CircularDub<d> {
//==================================================================    
    private static class Node<d> {
        private d data;
        private Node<d> prev;
        private Node<d> next;

        public Node(d el, Node<d> p, Node<d> n) {
            data = el;
            prev = p;
            next = n;
        }

        public d getData() {
            return data;
        }

        public void setNext(Node<d> el) {
            next = el;
        }

        public void setPrev(Node<d> el) {
            prev = el;
        }

        public Node<d> getNext() {
            return next;
        }

        public Node<d> getPrev() {
            return prev;
        }
    }
//==================================================================
    private Node<d> head;
    private int size;

    public CircularDub() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(d el) {
        if (isEmpty()) {
            Node<d> newNode = new Node<>(el, null, null);
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            head = newNode;
        } else {
            Node<d> newNode = new Node<>(el, head.getPrev(), head);
            head.getPrev().setNext(newNode);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(d el) {
        if (isEmpty()) {
            addFirst(el);
        } else {
            Node<d> newNode = new Node<>(el, head.getPrev(), head);
            head.getPrev().setNext(newNode);
            head.setPrev(newNode);
            size++;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty.");
        }

        if (size == 1) {
            head = null;
        } else {
            Node<d> newHead = head.getNext();
            head.getNext().setPrev(head.getPrev());
            head.getPrev().setNext(newHead);
            head = newHead;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty.");
        }

        if (size == 1) {
            head = null;
        } else {
            Node<d> lastNode = head.getPrev();
            lastNode.getPrev().setNext(head);
            head.setPrev(lastNode.getPrev());
        }
        size--;
    }

    public void rotate() {
        if (!isEmpty()) {
            head = head.getNext();
        }
    }

    public void rotateBackward() {
        if (!isEmpty()) {
            head = head.getPrev();
        }
    }

    public void output() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            Node<d> current = head;
            int[] arr = new int[size];
            for (int k = 0; k < size; k++) {
                arr[k] = (current.getData() != null) ? (int) current.getData() : 0;
                current = current.getNext();
            }
            System.out.println(Arrays.toString(arr));
            System.out.println("=============================================================================");
            System.out.println("");
        }
    }
}
