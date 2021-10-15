import java.util.Arrays;
import java.util.NoSuchElementException;

public class MidtermStudy_Array {
    static public class ArrayIntList{ // int 배열 구현.
        private  int[] array; // 배열 선언
        private int size; // 리스트의 항목 수, array[size] 는 비어있음을 기억. 마지막 원소는 array[size - 1]
        public ArrayIntList(){ // 생성자
            array = new int[1]; // array.length != size
            size = 0;
        }
        public int peek(int k){
            if (size == 0){
                throw new NoSuchElementException();
            }
            return array[k];
        }
        public void insert(int newInt){ // insert 오버로딩 (마지막에 넣을 때)
            if (size == array.length){
                 resize(2 * array.length);
            }
            array[size++] = newInt; // 후위연산자로 해야함. size = 0 부터 시작했음.
        }
        public void insert(int newInt, int k){
            if (size == array.length) resize(2 * array.length);
            for(int i=size - 1; i >= k; i--) { // 순서 주의. 제일 끝자리부터 밀어내는거임. k 번까지 민 다음에 k 자리에 넣기.
                array[i + 1] = array[i];
            }
            array[k] = newInt;
            size++;
            }

        private void resize(int newSize){ // 클래스 내부적으로 동작하므로 private 로 만든다.
            int[] tmp = new int[newSize];
            System.arraycopy(this.array, 0, tmp, 0, size); // 여기서 array.length 로 하게되면 줄이기 resize 시 잘못됨. 축소해야하는데 null 들고와서 크기 안맞음.
            array = tmp;
        }
        public int delete(int k){ // 삭제 후 반환
            if (isEmpty()) throw new NoSuchElementException();
            int item = array[k];
            for(int i=k;i < size;i++){
                array[i] = array[i + 1]; // 마지막 자리 즉, array[size - 1] 은 null 로 채워질것임.
            }
            size--;
            if(size > 0 && size == array.length / 4) resize(array.length / 2);
            return item;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public void print(){
            System.out.println(Arrays.toString(array));
        }
    }
    public static void main(String[] args){
        ArrayIntList array = new ArrayIntList();
        array.insert(10); array.print();
        array.insert(30); array.print();
        array.insert(34); array.print();
        array.insert(3); array.print();
        array.insert(1000, 1); array.print();
        array.insert(1000, 4); array.print();
        array.insert(5); array.print();
        array.delete(0); array.print();
        array.delete(0); array.print();
        array.delete(3); array.print();
        array.delete(0); array.print();
        array.delete(0); array.print();
        array.delete(0); array.print();
    }
}
