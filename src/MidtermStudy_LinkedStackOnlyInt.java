import java.util.EmptyStackException;

public class MidtermStudy_LinkedStackOnlyInt {
    public static void main(String[] args){
        LinkedStackOnlyInt stack = new LinkedStackOnlyInt();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();

    }

}

class LinkedStackOnlyInt{
    private IntNode top;
    private int size;
    public LinkedStackOnlyInt(){
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
