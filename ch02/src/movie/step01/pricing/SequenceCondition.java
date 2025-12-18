package movie.step01.pricing;

import movie.step01.DiscountCondition;
import movie.step01.Screening;

/**
 * 순번 조건
 */
public class SequenceCondition implements DiscountCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
