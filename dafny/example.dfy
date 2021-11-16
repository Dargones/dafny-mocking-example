class Example<T> {

    var other:Example?<T>

    constructor(other:Example?<T>) {
        this.other := other;
    }

    function method getOther():Example?<T> reads this {
        other
    }

    function method isArgEven(i:int):bool {
        i % 2 == 0
    }

    function method sum(a:int, b:int):int {
        a + b
    }

}

class ExampleTest {

    method {:extern} {:fresh} getFreshIntExample() 
        returns (e:Example<int>) 
        ensures fresh(e)

    method {:extern} {:stubMethod} stubGetOther<T>(e:Example<T>, other:Example<T>) 
        ensures e.getOther() == other;

    function method argIsTwo(i:int):bool {
        i == 2
    }

    function method argIsThree(i:int):bool {
        i == 3
    }

    function method sumIsForty(a:int, b:int):bool {
        a + b == 40
    }

    function method sumIsTwenty(a:int, b:int):bool {
        a + b == 20
    }

    function method sum(a:int, b:int):int {
        a + b
    }

    method {:extern} {:stubMethod} stubIsArgEven2<T>(e:Example<T>, b:bool) 
        ensures forall i :: argIsTwo(i) ==> e.isArgEven(i) == b;

    method {:extern} {:stubMethod} stubIsArgEven3<T>(e:Example<T>, b:bool) 
        ensures forall i :: argIsThree(i) ==> !e.isArgEven(i) == b;

    method {:extern} {:stubMethod} stubSumForty<T>(e:Example<T>, sum:int) 
        ensures forall a :: forall b :: sumIsForty(a, b) ==> e.sum(a, b) == sum;

    method {:extern} {:stubMethod} stubSumTwenty<T>(e:Example<T>, sum:int) 
        ensures forall a :: forall b :: sumIsTwenty(a, b) ==> e.sum(a, b) == sum;

    method {:extern} {:stubMethod} stubSumSmart<T>(e:Example<T>) 
        ensures forall a :: forall b :: sumIsTwenty(a, b) ==> e.sum(a, b) == sum(a,b);

    method {:test} testCircularDependenceInFields() {
        var e1 := getFreshIntExample();
        var e2 := getFreshIntExample();
        e1.other := e2;
        e2.other := e1;
        expect e1.other == e2;
        expect e2.other == e1;
    }

    method {:test} testCircularDependenceInMethods() {
        var e1 := getFreshIntExample();
        var e2 := getFreshIntExample();
        stubGetOther(e1, e2);
        stubGetOther(e2, e1);
        expect e1.getOther() == e2;
        expect e2.getOther() == e1;
    }

    method {:test} testArgumentMatching() {
        var e1 := getFreshIntExample();
        var e2 := getFreshIntExample();
        var e3 := getFreshIntExample();
        stubIsArgEven2(e1, true);
        stubIsArgEven3(e1, false);
        expect e1.isArgEven(2);
        expect !e1.isArgEven(3);
    }

    method {:test} testMultipleArgumentMatching() {
        var e1 := getFreshIntExample();
        stubSumForty(e1, 40);
        stubSumTwenty(e1, 40);
        expect e1.sum(7, 33) == 40;
        expect e1.sum(5, 15) == 20;
    }

    method {:test} testReturnValueDependingOnArgument() {
        var e1 := getFreshIntExample();
        stubSumSmart(e1);
        expect e1.sum(7, 12) == 19;
        expect e1.sum(1, 5) == 6;
    }
}