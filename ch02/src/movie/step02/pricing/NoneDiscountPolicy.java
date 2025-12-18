package movie.step02.pricing;

import money.Money;
import movie.step01.Screening;
import movie.step02.DiscountPolicy;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
