// Class Example
// Dafny class Example compiled into Java
package _System;


@SuppressWarnings({"unchecked", "deprecation"})
public class Example<T> {
    private dafny.TypeDescriptor<T> _td_T;
    public Example(dafny.TypeDescriptor<T> _td_T) {
        this._td_T = _td_T;
        this.other = (Example<T>) null;
    }
    public Example<T> other;
    public void __ctor(Example<T> other)
    {
        (this).other = other;
    }
    public Example<T> getOther() {
        return this.other;
    }
    public boolean isArgEven(java.math.BigInteger i) {
        return (dafny.DafnyEuclidean.EuclideanModulus(i, java.math.BigInteger.valueOf(2L))).signum() == 0;
    }
    public java.math.BigInteger sum(java.math.BigInteger a, java.math.BigInteger b)
    {
        return (a).add((b));
    }
    public static <T> dafny.TypeDescriptor<Example<T>> _typeDescriptor(dafny.TypeDescriptor<T> _td_T) {
        return (dafny.TypeDescriptor<Example<T>>) (dafny.TypeDescriptor<?>) dafny.TypeDescriptor.referenceWithInitializer(Example.class, () -> (Example<T>) null);
    }
}
