package MidtermStudy;

import java.util.NoSuchElementException;

public class MidtermStudy_ArrayQueue {
    public static void main(String[] args){
        ArrayQueue queue = new ArrayQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.print();
        queue.remove();
        queue.print();
        queue.remove();
        queue.print();
    }
}

class ArrayQueue{
    private int[] queue; // 큐를 위한 배열.
    private int front, rear, size;
    public ArrayQueue(){ // 큐 생성자.
        queue = new int[2]; // 한 칸을 비우고 사용하니 크기 2 인 배열 생성. [0] [1] 두칸. 비어있다고 한 칸만 생성하면 첫 add 부터 resize 가 필요하다.
        front = rear = size = 0;
    }
    public int size() { return size; }
    public void add(int newItem){
        if((rear + 1) % queue.length == front){ // 큐가 full 인 경우 (front 칸을 제외하고)
            resize(2*queue.length);
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = newItem;
        size++;
    }
    public int remove(){
        if(isEmpty()) throw  new NoSuchElementException();
        front = (front + 1) % queue.length;
        int item = queue[front]; // 지금 front 를 한칸 앞으로 이동한 상태이므로 front 로 인덱싱
        queue[front] = 0;
        size--;
        if(size > 0 && size == queue.length / 4){
            resize(queue.length / 2);
        }
        return item;
    }
    public boolean isEmpty(){ return (size == 0); }

    private void resize(int newSize){
        int[] tmp = new int[newSize];
        for(int i = 1, j=front + 1; i < size + 1; i++, j++){ // 원형 큐이므로 원소가 어디 위치할지, 시작점이 어디인지에 유연하게 복사해야함.
            tmp[i] = queue[j % queue.length]; // 이렇게 해야 원형으로 돌면서 모두 접근할 수 있다. tmp[0] 은 front 자리로 비워준다.
        }
        front = 0;
        rear = size; // front 가 0을 차지하고있으니 rear 의 index 가 size 와 동일해짐.
        queue = tmp;
    }
    public void print(){
        for(int i = front + 1, j = 0; j < size; i++, j++){
            System.out.print(queue[i % queue.length] + " ");
        }
        System.out.println();
    }
}

