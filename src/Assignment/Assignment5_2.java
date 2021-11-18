package Assignment;

// 배열을 이용한 오픈주소 방식의 해시 테이블
// 2017110523 오한음
public class Assignment5_2 {
    public static void main(String[] args){
        // size 10 의 HashTable 선언 및 생성.
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);
        hashTable.put("four", 4);
        hashTable.put("five", 5);
        hashTable.put("six", 6);
        hashTable.put("seven", 7);
        hashTable.put("eight", 8);
        hashTable.put("nine", 9);
        // size 10 의 해시테이블의 적재율을 90 % 까지 채운다.
        System.out.println("key: one, value: " + hashTable.get("one"));
        System.out.println("key: two, value: " + hashTable.get("two"));
        System.out.println("key: three, value: " + hashTable.get("three"));
        System.out.println("key: eight, value: " + hashTable.get("eight"));
        System.out.println("key: nine, value: " + hashTable.get("nine"));
        // 기존 해시테이블에선 잘 작동한다.

        // size 20 인 해시테이블로 재해시 진행.

        System.out.println("해시테이블 resize 후 재해싱을 진행합니다.");

        HashTable<String ,Integer> newHashTable = hashTable.resize();
        System.out.println("key: one, value: " + newHashTable.get("one"));
        System.out.println("key: two, value: " + newHashTable.get("two"));
        System.out.println("key: three, value: " + newHashTable.get("three"));
        System.out.println("key: four, value: " + newHashTable.get("four"));
        System.out.println("key: eight, value: " + newHashTable.get("eight"));
        System.out.println("key: nine, value: " + newHashTable.get("nine"));
        // 잘 동작함을 확인 가능.
    }
}

@SuppressWarnings("unchecked")
// 선형조사 방식을 이용.
class HashTable<Key, Value>{
    private final int size;
    private final Key[] keys; // 해시테이블
    private final Value[] values; // 데이터 저장.

    public HashTable(int size){ // 생성자
        this.size = size;
        keys = (Key[]) new Object[size]; // 해시테이블 생성
        values = (Value[]) new Object[size]; // value 배열 생성.
    }

    private int hash(Key key){ // key 해싱.
        return (key.hashCode() & 0x7fffffff) % size;
        // key.hashcode() 값과 부호비트를 제외한 int 형으로 나타낼 수 있는 가장 큰 수의 AND 연산 후 size 로 나눈 나머지가 hash 값.
    }

    public void put(Key key, Value value){ // put 메서드
        int initialPos = hash(key); // key 값을 해싱.
        int i = initialPos;
        if(keys[i] == null){ // 배열[i] 가 비어있으면 그 공간에 삽입.
            keys[i] = key; values[i] = value;
        }
        else if (keys[i].equals(key)) { // 이미 배열[i] 에 key 가 들어있다면 데이터 갱신
            values[i] = value;
        }
        else { // 배열[i] 에 다른 key 가 들어있으면 다음 인덱스로 넘어감
            i = (++i) % size;
            while(i != initialPos){ // overflow 발생하면 종료. (한바퀴 돌았는데도 자리가 없는경우)
                if(keys[i] == null) {
                    keys[i] = key;
                    values[i] = value;
                    return;
                }
                else if(keys[i].equals(key)) {
                    values[i] = value;
                    return;
                }
                i = (++i) % size;
            }
        }
    }

    public Value get(Key key){
        int i = hash(key);
        while(keys[i] != null){
            if(keys[i].equals(key)) return values[i];
            i = (++i) % size;
        }
        return null; // while 문 내에 못찾았으면 key 값이 keys 내에 없는 것.
    }

     public void remove(Key key){ // 삭제 메서드.
        int i = hash(key);
        while(keys[i] != null){
            if(keys[i].equals(key)){
                keys[i] = null;
                values[i] = null;
            }
            i = (++i) % size;
        }
     }

     public boolean contains(Key key){
        Value value = get(key);
         return value != null;
     }

     public HashTable<Key, Value> resize(){ // 해시테이블 확장 함수
        HashTable<Key, Value> newTable = new HashTable<>(size * 2);  // 크기 2배의 해시테이블 생성.
        for(int i=0; i<size; i++){ // 재해시 진행
            Key key = keys[i]; Value value = values[i];
            if (key != null) newTable.put(key, value);
        }
        return newTable;
     }
}
