package movie.step02;

import money.Money;
import movie.step01.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
