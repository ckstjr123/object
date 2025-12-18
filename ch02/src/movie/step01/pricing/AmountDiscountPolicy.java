package movie.step01.pricing;

import money.Money;
import movie.step01.DiscountCondition;
import movie.step01.DiscountPolicy;
import movie.step01.Screening;

/**
 * 고정 금액 할인 정책
 */
public class AmountDiscountPolicy extends DiscountPolicy {
    
    private Money discountAmount; // 할인 금액

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
