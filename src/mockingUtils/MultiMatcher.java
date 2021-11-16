package utils;

import org.mockito.ArgumentMatcher;

/**
 * A class that allows delaying Mockito's argument matching until all
 * arguments are read. This is useful when the matching condition depends on
 * multiple arguments at the same time.
 */
public class MultiMatcher implements ArgumentMatcher<Object> {

    private final int argsTotal;
    private int argsRead;
    private final Object[] args;
    private final Predicate predicate;

    public MultiMatcher(int nOfArgs, Predicate predicate) {
        this.argsTotal = nOfArgs;
        this.argsRead = 0;
        this.args = new Object[nOfArgs];
        this.predicate = predicate;
    }

    @Override
    public boolean matches(Object o) {
        args[argsRead] = o;
        argsRead++;
        if (argsRead < argsTotal)
            return true;
        argsRead = 0;
        return predicate.p(args);
    }

    public interface Predicate {
        boolean p(Object[] args);
    }
}