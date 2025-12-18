package movie.step02.pricing;

import money.Money;
import movie.step01.DiscountCondition;
import movie.step01.Screening;
import movie.step02.DefaultDiscountPolicy;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
