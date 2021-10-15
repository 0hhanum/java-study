import java.util.Arrays;
import java.util.EmptyStackException;

public class MidtermStudy_ArrStack {
    public static void main(String[] args){
        ArrStack stack = new ArrStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        stack.pop();
        stack.print();
        System.out.println(stack.peek());
        stack.pop();
        stack.print();
        stack.pop();

    }

}

class ArrStack{ // int stack
    private int[] stack;
    private int top; // 스택 탑 항목(제일 위) 의 인덱스.
    public ArrStack(){
        stack = new int[1];
        top = -1; // stack 이 비었을 때는 배열의 빈 공간을 가리킴.
    }
    public int size(){ return top + 1; }
    public boolean isEmpty(){ return (top == -1);}

    public int peek(){
        if(isEmpty()) throw new EmptyStackException();
        return stack[top];
    }
    public void push(int item){
        if(size() == stack.length)
            resize(2 * stack.length);
        stack[++top] = item;
    }
    public int pop(){
        if(isEmpty()) throw new EmptyStackException();
        int item = stack[top];
        stack[top--] = 0;
        if(size() > 0 && size() == (stack.length) / 4){
            resize(stack.length / 2);
        }
        return item;
    }
    public void resize(int size){
        int[] tmp = new int[size];
        System.arraycopy(stack, 0, tmp, 0, size());
        stack = tmp;
    }
    public void print(){
        System.out.println(Arrays.toString(stack));
    }

}

