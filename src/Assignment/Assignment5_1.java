package Assignment;

import MidtermStudy.IntNode;

import java.util.EmptyStackException;

public class Assignment5_1 {
    public static void main(String[] args){
        // scanner 로 배열 길이, 각 막대의 높이 받아서 채우기.
        int[] histogram = new int[8];
        Stack stack = new Stack();

        int maxArea = 0;

        for(int i=0; i<histogram.length; i++){
            int height = histogram[i];
            int topOfStack;
            try{
                topOfStack = stack.peek();
            } catch (EmptyStackException exception){
                stack.push(height); // 인덱스를 넣어야 하나? 그래야 넓이 계산될거같은데
                continue;
                // 스택이 비어있다면 현재 height 를 stack 에 push 후 다음 반복.
            }
            int width = 1;
            while (topOfStack >= height){ // topOfStack > height 라면 while 문을 돈다.
                int topHeight = stack.pop();
                int currentArea = topHeight * width;
                if(currentArea > maxArea) maxArea = currentArea; // pop() 으로 얻은 높이의 직사각형과 maxArea 를 비교.
                width++; // 너비는 1 증가
                try{
                    topOfStack = stack.peek();
                } catch (EmptyStackException exception){
                    break; // stack 에 원소가 없으면 반복문 탈출.
                }
            }
            if (topOfStack < height) {
                // topOfStack 이 height 보다 작다면 height 을 stack 에 push.
                stack.push(height);
            }
        }
        System.out.println(maxArea);


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
        System.out.println("앞 쪽이 나중에 들어온 값");
        for(int i=0;i<size;i++){
            System.out.print(node.getItem() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
