// Class ExampleTests
// Dafny class ExampleTests compiled into Java
package _System;


/** these imports are added manually */
import org.junit.Test;
import org.mockito.Mockito;
import utils.MultiMatcher;

import static org.mockito.ArgumentMatchers.any;


@SuppressWarnings({"unchecked", "deprecation"})
public class ExampleTests {
    public ExampleTests() {
    }

    /** Implementation added manually */
    public Example<java.math.BigInteger> getFreshIntExample() {
        return Mockito.mock(Example.class);
    }

    /** Implementation added manually */
    public <__T> void stubGetOther(dafny.TypeDescriptor<__T> _td___T, Example<__T> e, Example<__T> other) {
        Mockito.doReturn(other).when(e).getOther();
    }

    public boolean argIsTwo(java.math.BigInteger i) {
        return java.util.Objects.equals(i, java.math.BigInteger.valueOf(2L));
    }
    public boolean argIsThree(java.math.BigInteger i) {
        return java.util.Objects.equals(i, java.math.BigInteger.valueOf(3L));
    }

    /** Implementation added manually */
    public <__T> void stubIsArgEven2(dafny.TypeDescriptor<__T> _td___T, Example<__T> e, boolean b) {
        Mockito.doReturn(b).when(e).isArgEven(Mockito.argThat((i) -> argIsTwo(i)));
    }

    /** Implementation added manually */
    public <__T> void stubIsArgEven3(dafny.TypeDescriptor<__T> _td___T, Example<__T> e, boolean b) {
        Mockito.doReturn(b).when(e).isArgEven(Mockito.argThat((i) -> argIsThree(i)));
    }

    public boolean sumIsForty(java.math.BigInteger a, java.math.BigInteger b)
    {
        return java.util.Objects.equals((a).add((b)), java.math.BigInteger.valueOf(40L));
    }
    public boolean sumIsTwenty(java.math.BigInteger a, java.math.BigInteger b)
    {
        return java.util.Objects.equals((a).add((b)), java.math.BigInteger.valueOf(20L));
    }

    /** Implementation added manually */
    public <__T> void stubSumForty(dafny.TypeDescriptor<__T> _td___T, Example<__T> e, java.math.BigInteger sum) {
        MultiMatcher matcher = new MultiMatcher(2, (args) ->
                sumIsForty((java.math.BigInteger) args[0],
                        (java.math.BigInteger) args[1]));
        Mockito.doReturn(sum).when(e).sum(Mockito.argThat((arg) -> matcher.matches(arg)),
                Mockito.argThat((arg) -> matcher.matches(arg)));
    }

    /** Implementation added manually */
    public <__T> void stubSumTwenty(dafny.TypeDescriptor<__T> _td___T, Example<__T> e, java.math.BigInteger sum) {
        MultiMatcher matcher = new MultiMatcher(2, (args) ->
                sumIsTwenty((java.math.BigInteger) args[0],
                        (java.math.BigInteger) args[1]));
        Mockito.doReturn(sum).when(e).sum(Mockito.argThat((arg) -> matcher.matches(arg)),
                Mockito.argThat((arg) -> matcher.matches(arg)));
    }

    public java.math.BigInteger sum(java.math.BigInteger a, java.math.BigInteger b)
    {
        return (a).add((b));
    }

    /** Implementation added manually */
    public <__T> void stubSumSmart(dafny.TypeDescriptor<__T> _td___T, Example<__T> e) {
        Mockito.when(e.sum(any(), any())).thenAnswer(inv -> sum(inv.getArgument(0), inv.getArgument(1)));
    }

    @Test // annotation added manually
    public void testCircularDependenceInFields()
    {
        Example<java.math.BigInteger> _24_e1;
        Example<java.math.BigInteger> _out0;
        _out0 = (this).getFreshIntExample();
        _24_e1 = _out0;
        Example<java.math.BigInteger> _25_e2;
        Example<java.math.BigInteger> _out1;
        _out1 = (this).getFreshIntExample();
        _25_e2 = _out1;
        (_24_e1).other = _25_e2;
        (_25_e2).other = _24_e1;
        if (!((_24_e1.other) == (Object)  (_25_e2))) {
            throw new dafny.DafnyHaltException("/home/sasha/Desktop/examplesDafny/mockToCompile.dfy(31,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
        }
        if (!((_25_e2.other) == (Object)  (_24_e1))) {
            throw new dafny.DafnyHaltException("/home/sasha/Desktop/examplesDafny/mockToCompile.dfy(32,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
        }
    }

    @Test // annotation added manually
    public void testCircularDependenceInMethods()
    {
        Example<java.math.BigInteger> _26_e1;
        Example<java.math.BigInteger> _out2;
        _out2 = (this).getFreshIntExample();
        _26_e1 = _out2;
        Example<java.math.BigInteger> _27_e2;
        Example<java.math.BigInteger> _out3;
        _out3 = (this).getFreshIntExample();
        _27_e2 = _out3;
        (this).<java.math.BigInteger>stubGetOther(dafny.TypeDescriptor.BIG_INTEGER, _26_e1, _27_e2);
        (this).<java.math.BigInteger>stubGetOther(dafny.TypeDescriptor.BIG_INTEGER, _27_e2, _26_e1);
        if (!(((_26_e1).getOther()) == (Object)  (_27_e2))) {
            throw new dafny.DafnyHaltException("/home/sasha/Desktop/examplesDafny/mockToCompile.dfy(40,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
        }
        if (!(((_27_e2).getOther()) == (Object)  (_26_e1))) {
            throw new dafny.DafnyHaltException("/home/sasha/Desktop/examplesDafny/mockToCompile.dfy(41,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
        }
    }

    @Test // annotation added manually
    public void testArgumentMatching()
    {
        Example<java.math.BigInteger> _52_e1;
        Example<java.math.BigInteger> _out4;
        _out4 = (this).getFreshIntExample();
        _52_e1 = _out4;
        Example<java.math.BigInteger> _53_e2;
        Example<java.math.BigInteger> _out5;
        _out5 = (this).getFreshIntExample();
        _53_e2 = _out5;
        Example<java.math.BigInteger> _54_e3;
        Example<java.math.BigInteger> _out6;
        _out6 = (this).getFreshIntExample();
        _54_e3 = _out6;
        (this).<java.math.BigInteger>stubIsArgEven2(dafny.TypeDescriptor.BIG_INTEGER, _52_e1, true);
        (this).<java.math.BigInteger>stubIsArgEven3(dafny.TypeDescriptor.BIG_INTEGER, _52_e1, false);
        if (!((_52_e1).isArgEven(java.math.BigInteger.valueOf(2L)))) {
            throw new dafny.DafnyHaltException("/home/sasha/Desktop/examplesDafny/mockToCompile.dfy(69,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
        }
        if (!(!((_52_e1).isArgEven(java.math.BigInteger.valueOf(3L))))) {
            throw new dafny.DafnyHaltException("/home/sasha/Desktop/examplesDafny/mockToCompile.dfy(70,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
        }
    }

    @Test // annotation added manually
    public void testMultipleArgumentMatching()
    {
        Example<java.math.BigInteger> _98_e1;
        Example<java.math.BigInteger> _out7;
        _out7 = (this).getFreshIntExample();
        _98_e1 = _out7;
        (this).<java.math.BigInteger>stubSumForty(dafny.TypeDescriptor.BIG_INTEGER, _98_e1, java.math.BigInteger.valueOf(40L));
        (this).<java.math.BigInteger>stubSumTwenty(dafny.TypeDescriptor.BIG_INTEGER, _98_e1, java.math.BigInteger.valueOf(20L));
        if (!(java.util.Objects.equals((_98_e1).sum(java.math.BigInteger.valueOf(7L), java.math.BigInteger.valueOf(33L)), java.math.BigInteger.valueOf(40L)))) {
            throw new dafny.DafnyHaltException("/home/sasha/Desktop/examplesDafny/mockToCompile.dfy(94,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
        }
        if (!(java.util.Objects.equals((_98_e1).sum(java.math.BigInteger.valueOf(5L), java.math.BigInteger.valueOf(15L)), java.math.BigInteger.valueOf(20L)))) {
            throw new dafny.DafnyHaltException("/home/sasha/Desktop/examplesDafny/mockToCompile.dfy(95,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
        }
    }

    @Test // annotation added manually
    public void testReturnValueDependingOnArgument()
    {
        Example<java.math.BigInteger> _119_e1;
        Example<java.math.BigInteger> _out8;
        _out8 = (this).getFreshIntExample();
        _119_e1 = _out8;
        (this).<java.math.BigInteger>stubSumSmart(dafny.TypeDescriptor.BIG_INTEGER, _119_e1);
        if (!(java.util.Objects.equals((_119_e1).sum(java.math.BigInteger.valueOf(7L), java.math.BigInteger.valueOf(12L)), java.math.BigInteger.valueOf(19L)))) {
            throw new dafny.DafnyHaltException("/home/sasha/Desktop/examplesDafny/mockToCompile.dfy(108,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
        }
        if (!(java.util.Objects.equals((_119_e1).sum(java.math.BigInteger.ONE, java.math.BigInteger.valueOf(5L)), java.math.BigInteger.valueOf(6L)))) {
            throw new dafny.DafnyHaltException("/home/sasha/Desktop/examplesDafny/mockToCompile.dfy(109,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
        }
    }

    private static final dafny.TypeDescriptor<ExampleTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(ExampleTests.class, () -> (ExampleTests) null);
    public static dafny.TypeDescriptor<ExampleTests> _typeDescriptor() {
        return (dafny.TypeDescriptor<ExampleTests>) (dafny.TypeDescriptor<?>) _TYPE;
    }

}
