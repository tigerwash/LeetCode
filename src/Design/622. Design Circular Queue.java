
/**
 622. Design Circular Queue
* **/
class MyCircularQueue {
    int capacity;
    int[] arr;
    int head;
    int tail;
    int size;
    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
        head = 0;
        tail = 0;
        size = 0;
        capacity = k;
    }

    public boolean enQueue(int value) {
        if(!isFull()) {
            arr[tail++] = value;
            size++;
            tail = tail%capacity;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(!isEmpty()){
            arr[head++] = -1;
            size--;
            head = head%capacity;
            return true;
        }
        return false;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return arr[head];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return arr[(tail-1 + capacity)%capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */