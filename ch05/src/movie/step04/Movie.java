package movie.step04;

import money.Money;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * Movie의 상속 계층 안에 구현된 할인 정책을
 * 독립적인 DiscountPolicy로 분리 후 Movie에 합성시키면,
 * 코드의 복잡성은 높아지더라도 할인 정책 변경을 쉽게 수용할 수 있는 유연한 코드로 만든다.
 * Movie "1" → "0..1" DiscountPolicy "1" → "*" DiscountCondition
 */
public abstract class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(discountCond -> discountCond.isSatisfiedBy(screening));
    }

    protected Money getFee() {
        return fee;
    }

    abstract protected Money calculateDiscountAmount();
}
