import java.util.EmptyStackException;

public class ArrayStack <E> {
    private E[] s; // 스택을 위한 배열
    private int top; // 스택 top 의 인덱스
    public ArrayStack(){ // 생성자
        s = (E[]) new Object[1]; // 초기에 크기 1인 배열 생성
        top = -1; // 생성자가 실행될 때는 stack 이 empty 이므로 -1 부터 시작.
    }

    public int size() { return top + 1;} // 스택 항목 수를 리턴
    public E[] getStack() { return s; } // getter 설정 (test 용)
    public boolean empty() {return (top == -1);} // 스택이 empty 인지 확인
    public void resize(int newLen){
        E[] tmp = (E[]) new Object[newLen]; // newLen 길이만큼의 새로운 stack 생성.
        System.arraycopy(s, 0, tmp, 0, top + 1);
        // 기존 stack 정보를 새로운 stack 으로 복사, top 이 0 부터 시작하므로 원소 개수인 top + 1 을 length 로 지정.
        s = tmp;
    }
    public void push(E newItem){
        if(size() == s.length){
            resize(2*s.length);
        } // push 전 stack 이 꽉 찼다면 2배로 확장해준다.
        s[++top] = newItem; // top + 1 위치에 newItem 넣고, top 은 1 키운다.
    }
    public E pop(){
        if (empty()) throw new EmptyStackException(); // stack 비어있는데 실행시 프로그램 정지.
        E item = s[top];
        s[top--] = null; // top 의 원소 삭제 후 top 은 1 줄인다.
        if (size() > 0 && size() == s.length / 4){
            resize(s.length / 2); // pop() 실행 후 stack 이 3/4 이상 비어있다면 스택의 크기를 절반으로 축소.
        }

        return item;
    }
    public E top(){
        if(empty()) throw new EmptyStackException(); // stack 이 비어있으면 에러 던짐.
        return s[top];  // 가장 상위 원소를 반환.
    }
}
