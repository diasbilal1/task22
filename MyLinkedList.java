public class MyLinkedList<E> implements MyList<E> {
    private class Node {
        private E element;
        private Node next;
        private Node prev;

        public Node(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(E element) {
        Node newNode = new Node(element);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode;
        if (index < size/2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size-1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }

        return currentNode.element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode;
        if (index == 0) {
            currentNode = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size-1) {
            currentNode = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            if (index < size/2) {
                currentNode = head;
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.next;
                }
            } else {
                currentNode = tail;
                for (int i = size-1; i > index; i--) {
                    currentNode = currentNode.prev;
                }
            }

            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }

        size--;
    }

    public int size() {
        return size;
    }

}