package Assignment;

import MidtermStudy.IntNode;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;

// 히스토그램 문제
// 2017110523 오한음
public class Assignment5_1 {
    public static void main(String[] args){

        // 히스토그램 입력 받는 부분.
        Scanner scanner = new Scanner(System.in);
        System.out.print("히스토그램 막대의 개수 입력 > ");

        int numberOfHist = scanner.nextInt();
        int[] histogram = new int[numberOfHist]; // 배열 생성

        for(int i=0; i<numberOfHist; i++){
            System.out.print("" + i + "번 막대의 높이 입력 > ");
            histogram[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println();
        System.out.println("입력한 히스토그램 > " + Arrays.toString(histogram));

        // maxArea 찾는 과정.
        Stack stack = new Stack();
        int maxArea = 0;

        for(int i=0; i<histogram.length; i++){
            int height = histogram[i]; // 현재 높이
            int topOfStack = 0;
            try{
                topOfStack = histogram[stack.peek()];
            } catch (EmptyStackException exception){
                // 스택이 비어있을 경우 아래에서 push()
            }
            while (topOfStack >= height){ // topOfStack > height 라면 while 문 진입.
                int topIndex = stack.pop(); // stack top 원소의 index
                int currentArea;
                int nextIndex;
                try{
                    nextIndex = stack.peek();
                } catch (EmptyStackException exception){ // stack 의 마지막 원소인경우.
                    currentArea = topOfStack * i; // width 는 현재 반복문을 도는 히스토그램 원소의 인덱스 한 칸 아래 만큼의 길이가 된다.
                    if(currentArea > maxArea) maxArea = currentArea;
                    break; // stack 에 원소가 없으면 반복문 탈출.
                }
                currentArea = topOfStack * ((i - 1) - nextIndex);
                if(currentArea > maxArea) {
                    maxArea = currentArea; // pop() 으로 얻은 높이의 직사각형과 maxArea 를 비교.
                }
                topOfStack = histogram[nextIndex]; // 다음 원소를 topOfStack 으로 지정.
            }
            stack.push(i); // index 를 push


            System.out.println("현재 height index: " + i);
            System.out.print("현재 index stack ( 가장 왼쪽이 Last in ): ");
            stack.print();
            System.out.println("현재 maxArea: " + maxArea);
            System.out.println();
        }

        // 히스토그램 배열을 처음부터 끝까지 돈 후 stack 에 남아있는 원소 처리.
        System.out.println("Stack 에 남아있는 원소들 처리");
        int stackSize = stack.size();
        int lastIndex = histogram.length - 1; // 인덱스는 0부터 시작하므로 길이 - 1 로 마지막 막대의 인덱스를 얻는다.
        for (int i=0; i<stackSize;i++ ){
            int currentArea;
            int currentIndex = stack.pop();
            int height = histogram[currentIndex];
            try{
                int nextIndex = stack.peek();
                currentArea = height * (lastIndex - nextIndex);
            } catch(EmptyStackException e){
                // 마지막 원소이면 제일 작은 원소라는 뜻 => 너비가 전체 길이가 된다.
                currentArea = height * (histogram.length);
            }
            if(currentArea > maxArea) maxArea = currentArea;
            System.out.println("현재 height index: " + currentIndex);
            System.out.print("현재 index stack ( 가장 왼쪽이 Last in ): ");
            stack.print();
            System.out.println("현재 maxArea: " + maxArea);
            System.out.println();
        }

        System.out.println("남은 스택 처리 후 최종 maxArea: " + maxArea);
    }
}

class Stack{
    private IntNode top;
    private int size;
    public Stack(){
        top = null;
        size = 0;
    }
    public int size(){ return size; }
    public boolean isEmpty() { return (size == 0); }
    public int peek(){
        if(isEmpty()) throw new EmptyStackException();
        return top.getItem();
    }
    public void push(int newItem){
        top = new IntNode(newItem, top);
        size++;
    }
    public int pop(){
        IntNode topNode = top;
        int item = topNode.getItem();
        top = topNode.getNext();
        topNode.setNext(null);
        size--;
        return item;
    }
    public void print(){
        IntNode node = top;
        for(int i=0;i<size;i++){
            System.out.print(node.getItem() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
