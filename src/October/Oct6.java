package October;

public class Oct6 {
    static{
        System.out.println("클래스 초기화");
    }
    {
        System.out.println("인스턴스 초기화");
    }
    Oct6(){
        System.out.println("생성자");
    }
    public static void main(String[] args){
        System.out.println("start");
        Oct6 test = new Oct6();
        int[] arr = new int[5];
    }
}
/*
class October.Car{
    static int count; // 클래스변수 count. 자동으로 0으로 초기화된다.
    int serialNo; // 인스턴스변수 serialNo. 아직 초기화되지 않은 상태.
    String color; // 인스턴스변수 color.

    October.Car(){ // 생성자 1
        count++;
        serialNo = count;
        color = "white";
    }

    October.Car(String color){ // 생성자 2
        count++;
        serialNo = count; // 위의 생성자와 중복되는 코드가 사용.
        this.color = color;
    }
}
*/
class Car{
    static int count;
    int serialNo;
    String color;

    { // 인스턴스 초기화 블럭
        serialNo = ++count;
    }
    Car(){
        color = "white";
    }
    Car(String color){
        this.color = color;
    } // 중복된 코드를 사용할 필요가 없다.
}

/*
[java] 10/6 학습기록 - 초기화
변수의 초기화
변수 선언 후 처음으로 값을 저장하는 것을 변수의 초기화라고 한다.
멤버변수는 초기화를 하지 않아도 자동적으로 변수의 자료형에 맞는 기본값으로 초기화가 이루어짐.
지역변수는 사용 전에 반드시 초기화해야함.

class Initialize{
  static int x;
  public static void main(String[] args){
    System.out.println(x); // 0 출력.
  }
}
멤버변수와 배열의 초기화는 선택적이지만, 지역변수의 초기화는 필수적이다.

배열은 참조변수 선언 -> new 생성 -> 초기화로 이어지기 때문에 생성에서 기본값 0 이 들어간다. 참조변수 선언은 변수만 선언할 뿐임.
멤버변수의 초기화 방법
명시적 초기화 (explicit initialization)
생성자 (constructor)
초기화 블럭(initialization block)
• 인스턴스 초기화 블럭: 인스턴스변수를 초기화
• 클래스 초기화 블럭: 클래스변수를 초기화
명시적 초기화 Explicit initialization
변수를 선언과 동시에 초기화하는 것을 명시적 초기화라고 한다.

int x = 4; // 기본형 (primitive type) 변수의 명시적 초기화
String y = new String("initial"); // 참조형 (reference type) 변수의 명시적 초기화
명시적 초기화가 간단하고 명료하지만, 보다 복잡한 초기화 작업이 필요할 때는 "초기화 블럭" 또는 생성자를 사용한다.

초기화 블럭 Initialization block
클래스 초기화 블럭
인스턴스 초기화 블럭
인스턴스 초기화 블럭은 클래스 내에 블럭 {} 을 만들고 그 안에 코드를 작성해 만든다. 클래스 초기화 블럭은 인스턴스 초기화 블럭 앞에 static 을 붙인다.

클래스 초기화 블럭은 클래스가 메모리에 처음 로딩될 때 한 번 수행되며, 인스턴스 초기화 블럭은 생성자와 같이 인스턴스가 생성될 때마다 수행된다. ** 이 때, 인스턴스 초기화 블럭이 생성자보다 먼저 수행된다.

클래스가 로딩될 때, 클래스변수들이 메모리에 만들어지고, 곧바로 클래스 초기화블럭이 클래스변수들을 초기화.
인스턴스 변수의 초기화는 주로 생성자를 사용하지만, 모든 생성자에서 공통으로 수행되어야 하는 코드를 넣을 때 인스턴스 초기화 블럭을 사용한다.

예시

// 초기화 블럭을 사용하지 않은 코드
class October.Car{
  static int count; // 클래스변수 count. 자동으로 0으로 초기화된다.
  int serialNo; // 인스턴스변수 serialNo. 아직 초기화되지 않은 상태.
  String color; // 인스턴스변수 color.

  October.Car(){ // 생성자 1
  count++;
  serialNo = count;
  color = "white";
  }

  October.Car(String color){ // 생성자 2
  count++;
  serialNo = count; // 위의 생성자와 중복되는 코드가 사용.
  this.color = color;
  }
}

// 초기화블럭을 사용한 코드
class October.Car{
  static int count;
  int serialNo;
  String color;

  { // 인스턴스 초기화 블럭
  serialNo = ++count;
  }
  October.Car(){
  color = "white";
  }
  October.Car(String color){
  this.color = color;
  } // 중복된 코드를 사용할 필요가 없다.
}
코드의 중복을 제거하는 것은 재사용성과 신뢰성을 높이고, 오류 발생 가능성을 줄여준다. 객체지향프로그래밍의 궁극적 목표.

예시
class BlockTest{
 static {
 System.out.println("클래스 초기화블럭");
 }
 {
 System.out.println("인스턴스 초기화블럭");
 }
 BlockTest(){
   System.out.println("생성자");
 }
 public static void main(String[] args){
 System.out.println("start");
 BlockTest test = new BlockTest();
 }
}

출력순서

"클래스 초기화블럭" => "start" => "인스턴스 초기화블럭" => "생성자"
** 클래스 초기화블럭이 가장 먼저 실행 -> main 메서드
프로그램이 실행중 클래스에 대한 정보가 요구될 때 메모리에 올라가므로 클래스 초기화블럭이 먼저 실행됨을 확인할 수 있다.

예시
class StaticBlock{
  static int[] arr = new int[10];
  static{
    for(int i=0; i<arr.length; i++){
      arr[i] = (int)(Math.random() * 10) + 1;
    } // 클래스 초기화블럭을 이용해 클래스변수의 초기화. 배열이나 복잡한 초기화에 사용할 수 있다.
  }
}
인스턴스변수의 복잡한 초기화는 생성자를 이용해서도 가능하다.
멤버변수의 초기화 시기와 순서
클래스변수의 초기화시점
클래스가 처음 로딩될 때 단 한번 초기화.

인스턴스변수의 초기화시점
인스턴스가 생성될 때마다 각 인스턴스별로 초기화.

클래스변수의 초기화순서
기본값 -> 명시적초기화 -> 클래스 초기화블럭

인스턴스변수의 초기화순서
기본값 -> 명시적초기화 -> 인스턴스 초기화 블럭 -> 생성자
*한 단계가 더 존재한다.

클래스 멤버를 사용하거나, 인스턴스를 생성하는 등 클래스 정보가 요구될 때 클래스는 메모리에 로딩된다.

클래스의 로딩 시기는 JVM 의 종류에 따라 좀 다를 수 있다. 클래스가 필요할 때 로딩되는 것도 있고,
사용할 클래스들을 프로그램이 시작될 때 미리 로딩하도록 되어있는 것도 있다.
 */