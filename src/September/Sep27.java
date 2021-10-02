package September;

public class Sep27 {
    static String concatenate(int delim, String... args){
        String result = "";
        for(String str: args){
            result += str + Integer.toString(delim);
        }
        return result;
    }
    static String concatenate(String... args){
        return concatenate(0, args);
    }
    public static  void main(String[] args){
        String[] test = {"hello", "testing"};
        System.out.println(concatenate("test", "hello", "by"));
    }
}


/*
[java] 9/27 학습기록
클래스 멤버와 인스턴스 멤버간의 참조와 호출
같은 클래스에 속한 멤버들 간에는 별도의 인스턴스를 생성하지 않고도 서로 참조 또는 호출이 가능하다.
단, 클래스멤버가 인스턴스 멤버를 참조 또는 호출하고자 하는 경우에는 인스턴스를 생성해야 한다.

인스턴스 멤버가 같은 클래스 내의 멤버를 호출할 때 가능하다고 얘기하는듯?
그 이유는 인스턴스 멤버가 존재하는 시점에 클래스 멤버는 항상 존재하지만,클래스 멤버가 존재하는 시점에 인스턴스 멤버가 존재하지 않을 수도 있기 때문이다.

이런게 가능하단 얘기

class ClassTest{
  void instanceMethod(){} // 인스턴스 메서드
  static void staticMethod() {} // static 메서드

  void anotherInstanceMethod() {
    instanceMethod();
    staticMethod(); // 인스턴스 생성없이 인스턴스 메서드 호출. 참조변수 없이 클래스 메서드 호출.
  }
}

클래스 메서드에서 인스턴스 변수, 메서드 호출이 안된다고 했지만 이런 방식으로는 가능하다.

class Test{
  int instanceVariable = 10;
  void instanceMethod() { System.out.println("I'm instance method.");}

  public static void main(String[] args){ // 클래스 메서드
  Test test = new Test(); // 메서드 내에서 인스턴스를 생성.
  int localVariable = test.instanceVariable;
  System.out.println(localVariable);
  test.instanceMethod();
  }
}

하지만 이런 방식으로 사용하는 경우는 드물다.
만약 클래스 메서드 내에서 인스턴스 멤버를 참조 또는 호출해야 한다면, 인스턴스 메서드로
작성해야할 메서드를 클래스 메서드로 한 것은 아닌지 생각해봐야 한다.
오버로딩
오버로딩이란?
매개변수의 개수 또는 타입이 다르면 클래스 내에서 같은 이름을 가진 메서드를 정의할 수 있는 것.
이때, 오버로딩된 메서드들은 매개변수에 의해서만 구별될 수 있으므로 반환 타입은 오버로딩을 구현하는데 아무런 영향을 주지 못한다.

즉, 반환 타입만 다른 같은 이름의 메서드를 정의할 수는 없다.

int add(int a, int b) { return a + b; }
long add(int a, int b) { return (long) a + b; }
// 이렇게는 안된다는 뜻.
오버로딩의 예
println 메서드가 대표적.
println 메서드를 호출시, 사실 매개변수에 따라 호출되는 메서드가 달라진다.
오버로딩을 이용했기 때문에 타입에 관계없이 출력이 가능했던 것.

long add(int a, long b){ return a + b; }
long add(long a, int b){ return a + b; }
// 이 경우 호출 시 매개변수의 값에 의해 호출될 메서드가 구분될 수 있으므로 오버로딩으로 간주한다.
매개변수의 값에 의해 메서드를 구분할 수 있어야 오버로딩이 가능하다.
위의 반환 타입만 다른 경우에는 두 매개변수 모두 int 가 들어오기 때문에 무슨 메서드를 호출하는 것인지 구분할 수 없다.

// 올바른 오버로딩

int add(int a, int b) { return a+b; }
long add(long a, long b) { return a+b; }
long add(int[] a){
  long result = 0;
  for(int i: a){
    result += i;
  }
  return result;
}
오버로딩의 장점
같은 기능을 하는 메서드들의 이름을 통일할 수 있고, 메서드의 이름 또한 절약할 수 있다.

가변인자와 오버로딩
JDK1.5 부터 매개변수 개수를 동적 으로 지정해 줄 수 있게 되었다 => 가변인자

printf 메서드를 생각하면 된다. 포맷이 필요한 수에 따라 인자의 개수도 달라진다.

가변인자는 타입... 변수명 과 같은 형식으로 선언.

public PrintStream printf(String format, Object... args){ ~ } // printf
String concatenate(String... str){ ~ } // 이런식
가변인자 외에 매개변수가 더 있다면 가변인자를 매개변수 중에서 제일 마지막에 선언해야한다.
그렇지 않으면 가변인자인지 아닌지를 구별할 방법이 없기 때문에 컴파일 에러가 발생한다.

public class September.Sep27 {
    static void concatenate(String... strs){
        for(String str : strs){
            System.out.println(str);
        }
    }
    public static  void main(String[] args){
        String[] test = {"hello", "testing"};
        concatenate(test); // 배열을 받음
        concatenate("hello", "test"); // 당연히 가능
        concatenate() // 심지어 인자가 없어도 작동.
    }
}
// 가변인자를 사용할 경우 **배열도 인자가 될 수 있다.**
가변인자는 내부적으로 배열을 이용해 구현된다. 그래서 가변인자가 선언된 메서드를 호출할 때마다 배열이 새로 생성된다. 따라서 비효율적인 요소가 존재하므로, 꼭 필요한 경우에만 가변인자를 사용하는 것이 좋다.

가변인자를 오버로딩 할 때 주의사항
static String concatenate(String delim, String... args){
  String result = "";
  for(String str: args){
    result += str + delim;
  }
return result;
}
static String concatenate(String... args){
  return concatenate("", args); // 오버로딩하며 자기 자신을 호출이 가능. 매개변수로 구분 가능하기 때문에~
}
위와 같은 경우 매개변수를 통해 어떤 메서드를 호출한 건지 구분할 수 없어 문제가 발생한다.
delim 이 int 형일 경우 가능하지만,
가변인자 선언한 메서드를 오버로딩하면 메서드를 호출했을 때, 구별되지 못하는 경우가 발생하기 쉽기 때문에
가능하면 가변인자 메서드는 오버로딩 하지 말도록 하자.
 */