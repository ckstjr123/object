package movie.step01.pricing;

import money.Money;
import movie.step01.DiscountCondition;
import movie.step01.DiscountPolicy;
import movie.step01.Screening;

/**
 * 비율 할인 정책
 */
public class PercentDiscountPolicy extends DiscountPolicy {

    private double percent; // 할인 비율

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
