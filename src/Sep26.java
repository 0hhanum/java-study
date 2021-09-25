public class Sep26 {
    public static void main(String[] args){
        Sep26 test = new Sep26();
        int result = test.add(3, 5);
        System.out.println(result);

        int[] newResult = {0};
        test.add(3, 5, newResult);
        System.out.println(newResult[0]);
    }
    int add(int a, int b) {
        return a + b;
    }
    void add(int a, int b, int[] result){
        result[0] = a + b; // 배열로 받은 매개변수의 값을 변경. => 참조형 매개변수는 주소를 받아오기 때문에 가능
    }

}


/*
[java] 9/25 학습기록
JVM 의 메모리 구조
응용프로그램이 실행되면, JVM 은 시스템으로부터 프로그램을 수행하는데 필요한 메모리를 할당받고 JVM 은 이 메모리를 용도에 따라 여러 영역으로 나누어 관리한다.

세 가지 영역

Method Area
Call stack
Heap
메서드 영역
프로그램 실행 중 어떤 클래스가 사용되면, JVM 은 해당 클래스의 클래스파일 *.class 을 읽어 클래스에 대한 정보(클래스 데이터)를 이곳에 저장한다. 이 때, 그 클래스의 클래스 변수 도 메서드 영역에 저장.

힙(heap)
인스턴스가 생성되는 공간, 프로그램 실행 중 생성되는 인스턴스는 모두 이곳에 생성된다. 즉, 인스턴스변수들이 생성되는 공간이다.

호출스택 (call stack or execution stack)
호출스택은 메서드의 작업에 필요한 메모리 공간을 제공한다. 메서드가 호출되면, 호출스택에 호출된 메서드를 위한 메모리가 할당되며, 이 메모리는 메서드가 지역변수(매개변수 포함) 들과 연산의 중간결과 등을 저장하는데 사용된다. 그리고 메서드가 작업을 마치면 할당되었던 메모리공간은 반환되어 비워진다.

각 메서드를 위한 메모리상의 작업공간은 서로 구별되며, 첫 번째로 호출된 메서드를 위한 작업공간이 호출스택의 맨 밑에 마련되고, 첫 번째 메서드 수행 중에 다른 메서드를 호출하면, 첫 번째 메서드의 바로 위에 두 번째로 호출된 메서드를 위한 공간이 마련된다. -> 호출'스택' 이므로 후입선출 (메서드 작동방식)

즉, 호출스택의 제일 상위에 위치하는 메서드가 현재 실행중인 메서드이며, 나머지는 대기상태에 있게 된다.

호출스택의 특징 정리
 • 메서드가 호출되면 수행에 필요한 만큼의 메모리를 스택에 할당받는다.
 • 수행을 마친 메서드는 사용했던 메모리를 반환하고 스택에서 제거된다.
 • 호출스택의 제일 위에 있는 메서드가 현재 실행중인 메서드이다.
 • 아래에 있는 메서드가 바로 위의 메서드를 호출한 메서드이다.

기본형 매개변수와 참조형 매개변수
메서드를 호출할 때 매개변수를 입력한다. 매개변수의 타입이 기본형 (primitive type) 일 때는 기본형 값을 메서드에서 받지만, 참조형(reference type) 이면 인스턴스의 주소가 복사된다.
참조형 매개변수는 저장된 곳의 주소를 알 수 있기 때문에, 값을 읽어 오는 것은 물론 값을 변경하는 것도 가능하다.

예시
class Data {int x;} // 인스턴스 변수 달랑 하나인 클래스.
class PrimitiveParam{
  public static void main(String[] args){
  Data d = new Data(); // 인스턴스 생성
  d.x = 10; // 인스턴스 변수 초기화
  System.out.println(d.x) // 10 출력

  change(d.x); // 기본형 매개변수 받는 함수 출력
  System.out.println(d.x) // 10 출력
  }

 static void change(int x){ // 기본형 매개변수 받는 메서드
   x = 1000;
 }
}
// 결과는 둘 다 10이 출력된다.
얼핏 보면 d.x = 1000; 을 실행한 것 같아 바뀔 것처럼 헷갈리지만 그렇지 않다.
d.x 가 들어간 게 아니라 지역변수 int x 값에 d.x 가 복사되어 들어간 것.

즉, d.x 의 값이 변경된 것이 아니라, change 메서드의 매개변수 x 값이 변경된 것. 매개변수 x는 곧 지역변수로, 호출 스택에서 할 일이 끝나면 메모리에서 제거된다.

예시
class Data { int x; }
class ReferenceParam{
  public static void main(String[] args){
    Data data = new Data();
    data.x = 10;
    System.out.println(data.x); // 10 출력

    change(data);
    System.out.println(data.x); // 1000 출력
  }
  static void change(Data d){
    d.x = 1000;
  }
}

// d.x 값이 변경되어 1000이 출력.
change(Data d) 는 '값이 저장된 주소' 를 매개변수로 넘겨받고 그 주소값에 해당하는 객체에 접근이 가능. 따라서 값의 변경도 가능해진다. 이전 예시의 경우 주소값을 아는 게 아닌 d.x 의 값만 복사한 것이기 때문에 실제 d.x 에 접근해 다룰 수 없다.

여기서 든 내 의문점

change 메서드의 매개변수 d 는 지역변수인가? 지역변수는 메서드 내에서만 쓰이고 삭제되는데
어떻게 외부의 값을 건드리는 걸까.

고민 끝 내 생각

지역변수가 맞다. 하지만 중요한 것은 매개변수 d 이던 data이던 모두 *참조변수* 란 것.
주소만 담은 변수이기 때문에 같은 객체를 여러 변수가 가리켜도 상관이 없다.
메서드 내의 d 는 지역변수로 메서드가 종료되면 사라지지만
그 주소를 이용해 실제 객체의 값을 변경할 수 있다.
하하

다른 예제.

public class Sep26 {
    public static void main(String[] args){
        Sep26 test = new Sep26();
        int result = test.add(3, 5);
        System.out.println(result);

        int[] newResult = {0};
        test.add(3, 5, newResult);
        System.out.println(newResult[0]);
    }
    int add(int a, int b) {
        return a + b;
    }
    void add(int a, int b, int[] result){
        result[0] = a + b; // 배열로 받은 매개변수의 값을 변경. => 참조형 매개변수는 주소를 받아오기 때문에 가능
    }
}
void 메서드에서도 반환값 저장은 할 수 있다는 걸 보여주는 예제. 이것을 응용하면 여러 개의 값을 반환받는 것과 같은 효과를 낼 수 있다. (메서드는 단 하나의 값만을 반환할 수 있음)

그냥 배열을 반환하면 되지 않나?
void 에서 반환을 받는 방법보다 처음 봐서 내 흥미를 끌었던 것은 클래스 내에서 자신의 인스턴스를 생성한 부분.
그리고 같은 이름의 메서드를 정의한 부분.

같은 이름의 메서드를 정의 하는걸 "메서드 오버로딩" 이라 한다고 함.
예상한 대로 매개변수의 타입과 개수를 이용해 어떤 메서드를 호출한 것인지를 파악.
메서드에 사용되는 이름을 절약할 수 있다.

자바엔 *args, **kwargs 같은 게 없는걸까?
 */