package Assignment;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Assignment3_1 {
    public static void main(String[] args){
        ArrayQueueOnlyInt queue = new ArrayQueueOnlyInt();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("큐에 넣을 숫자 입력. 중지는 999, 삭제는 0 입력. > ");
            int num = scanner.nextInt();
            if(num == 999) break;
            else if (num == 0) queue.remove();
            else queue.add(num);
            queue.print();

        }
        scanner.close();
    }
}

class ArrayQueueOnlyInt{
    private final int[] QUEUE; // 큐를 위한 배열.
    private int front, rear, size;
    public ArrayQueueOnlyInt(){ // 생성자
        QUEUE = new int[6]; // 한 칸을 front 를 위해 비워두니 5개를 저장할 수 있는 큐를 위해선 크기 6인 배열 생성.
        front = rear = size = 0;
    }
    public int size() {return size;}
    public boolean isEmpty(){ return (size == 0);} // 큐가 비었는지 boolean 반환. front == rear 로도 가능하다.
    public boolean isFull() {
        return (rear + 1) % QUEUE.length == front;
        // rear 다음 칸이 front 라면 큐가 꽉 찬것.
    }
    public void add(int newItem){
        if(isFull()) {
            System.out.println("큐가 꽉 찼습니다. " + newItem + " 을 넣을 수 없습니다.");
            return;
        }
        // 큐가 꽉 찼다면(원형 큐에서 rear 다음 칸이 front 라면) 에러 처리.
        rear = (rear + 1) % QUEUE.length; // rear 를 한 칸 뒤로 민다.
        QUEUE[rear] = newItem; // 밀린 rear 에 newItem 대입.
        size++;
    }
    public void remove(){
        if(isEmpty()) throw new NoSuchElementException();
        front = (front + 1) % QUEUE.length; // front 를 뒤로 한 칸 민다.
        int item = QUEUE[front]; // front 를 한 칸 밀었으니 현재 front 는 제일 앞 원소의 인덱스이다.
        QUEUE[front] = 0; // 기본값인 0 으로 삭제.
        size--;
    }
    public void print(){
        System.out.print("큐: ");
        for(int i = front + 1, j = 0; j < size; i++, j++){
            System.out.print(QUEUE[i % QUEUE.length] + " ");
        }
        System.out.println("\n배열: " + Arrays.toString(QUEUE));
        System.out.println();
    }

}
