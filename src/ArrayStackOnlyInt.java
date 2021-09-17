import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStackOnlyInt {
    private int[] s;
    private int top;
    public ArrayStackOnlyInt(){
        s = new int[1];
        top = -1;
    }
    public int size() { return top + 1;}
    public int[] getStack() { return s; }
    public boolean empty() {return (top == -1);}
    public void resize(int newLen){
        int[] tmp = new int[newLen];
        System.arraycopy(s, 0, tmp, 0, top + 1);
        s = tmp;
    }
    public void push(int newItem){
        if(size() == s.length){
            resize(2*s.length);
        }
        s[++top] = newItem;
    }
    public void pop(){
        if (empty()) throw new EmptyStackException();
        System.out.println(top);
        top--;
        if (top > 0) {
            resize(size());
            // int 배열에서 비어있는 값을 0으로 처리 시 연산 처리에 문제가 생겨 매번 배열 길이를 조절해준다.
            // 이 부분때문에 링크드 리스트로 처리하는게 나을 듯 하다.
        }
        System.out.println(Arrays.toString(s));
    }
    public int top(){
        if(empty()) throw new EmptyStackException();
        return s[top];
    }
}