package September;

public class Sep26_2 {
    public static void main(String[] args){
//        September.Sep26_2 example = new September.Sep26_2();
//        System.out.println(example.factorial(5));
        System.out.println(factorial(5));
    }
    static int factorial(int x){
        if (x ==  1) return 1;
        return factorial(x - 1) * x;
    }
}

/*
[java] 9/26 학습기록
참조형 반환타입
매개변수 분 아니라 반환타입도 참조형이 될 수 있다.
매개변수에서와 마찬가지로 모든 참조형 타입의 값은 '객체의 주소' 이므로 그저 정수값이 반환되는 것으로 생각.

예시
class Data {int x;}

public class Main {
    public static void main(String[] args){
        Data data1 = new Data();
        data1.x = 10;
        Data data2 = copyX(data1);
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data1.x);
        System.out.println(data2.x);
    }
    static Data copyX (Data data){
        Data tmp = new Data();
        tmp.x = data.x;
        return tmp;
    }
}
// x 값은 같지만 주소가 서로 다름을 확인 가능( 서로 다른 객체이다. ).
주요 과정

copyX(data); 가 실행되며 새로운 객체가 생성. 객체는 heap 영역에 저장되며 참조변수 tmp 가 이를 가리킨다.
메서드가 종료되면 tmp (주소가 담겨있음) 가 반환되며 data2 가 이를 받는다.
메서드가 끝났기 때문에 호출 스택에서 제거되며 지역변수 tmp 도 제거.
객체는 heap 에 존재하기 때문에 사라지지 않는다.
반환타입이 '참조형' 이라는 것은 메서드가 '객체의 주소'를 반환함을 의미.

재귀호출 (recursive call)
메서드의 내부에서 메서드 자신을 다시 호출하는 것을 '재귀호출' 이라 하고, 재귀호출을 하는 메서드를 '재귀 메서드' 라고 한다.
호출된 메서드는 '값에 의한 호출' 을 통해, 원래의 값이 아닌 복사된 값으로 작업하기 때문에 호출한 메서드와 관계없이 독립적인 작업수행이 가능하다.

재귀호출은 반복문과 유사한 점이 많으며, 대부분의 재귀호출은 반복문으로 작성하는 것이 가능.
어떤 작업을 반복적으로 처리해야한다면, 먼저 반복문으로 작성해보고 너무 복잡하면 재귀호출로 간단히 할 수 없는지 고민해볼 필요가 있다.
재귀호출은 비효율적(매개변수 복사, 종료 후 복귀할 주소 저장 등)이므로 재귀 호출에 드는 비용보다 재귀호출의 간결함이 주는 이득이 충분히 큰 경우에만 사용하는 것이 좋다.

팩토리얼 함수
public class September.Sep26_2 {
   public static void main(String[] args){
       System.out.println(factorial(5));
   }
   static int factorial(int x){
       if (x ==  1) return 1;
       return factorial(x - 1) * x;
   }
}
 ** static 이 자꾸 헷갈린다.
 '정적' 이라는 사전적 의미보다, 클래스 변수 • 클래스 메서드 라는 개념에 집중하자.
 모든 인스턴스들이 공유하는 데이터, 메서드라 생각.
만약 위 함수에 0을 x 로 넣는다면?

-> 조건문에서 잡아주지 못하기 때문에 factorial(x-1) 이 무한히 호출될 것이고, 호출 스택의 저장한계를 넘으면 stack overflow error 가 발생한다.

클래스 메서드와 인스턴스 메서드
static 이 붙어있는 것이 클래스 메서드. 클래스 변수와 마찬가지로 인스턴스 생성 없이 메서드 호출이 가능.
(클래스 변수, 메서드는 클래스가 메모리에 올라갈 때 자동적으로 같이 생성되 올라감)

-> 어떤 경우에 static 을 사용해야 하는 것일까.

클래스는 '데이터(변수) 와 데이터에 관련된 메서드의 집합' 이므로, 같은 클래스 내에 있는 메서드와 멤버변수는 아주 밀접한 관계가 있다. (멤버변수 = 클래스변수 + 인스턴스변수)

인스턴스 메서드는 인스턴스 변수와 관련된 작업을 하는, 즉 메서드의 실행에 인스턴스 변수를 필요로 하는 메서드.
인스턴스 변수는 객체를 생성해야만 만들어지므로, 인스턴스 메서드 역시 객체를 생성해야만 호출할 수 있음.

인스턴스와 관계없는(인스턴스 변수나 메서드를 사용하지 않는) 메서드를 클래스 메서드로 정의한다.

클래스 설계 시 용도에 따라 변수를 분류하고, 그에 맞춰 static 인지 아닌지 메서드를 정의하면 된다고 이해하면 될 듯하다.
클래스 메서드는 인스턴스 변수를 사용할 수 없다. 인스턴스 메서드도 당연히 마찬가지.
인스턴스 변수는 인스턴스가 반드시 존재해야만 사용할 수 있는데(그 전에는 존재 X), 클래스 메서드는 인스턴스 생성 없이 사용할 수 있는 부분에서 문제가 생길 수 있어 사용을 금지.
반면에 인스턴스 변수나 메서드에서는 static 이 붙은 멤버들을 사용하는 것이 언제나 가능하다. 인스턴스 변수가 존재한다는 것은 static 변수가 이미 메모리에 존재한다는 것을 의미하기 때문.
인스턴스 변수를 사용하지 않는 메서드라면 static 을 붙이는 것을 고려하자.
메서드 호출시간이 짧아지므로 성능이 향상된다. 인스턴스 메서드는 실행 시 호출될 메서드를 찾는 과정이 추가적으로 필요.
 */