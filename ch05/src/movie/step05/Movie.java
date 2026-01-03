package movie.step05;

import money.Money;
import movie.MovieType;

import java.time.Duration;
import java.util.List;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountedFee());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(discountCond -> discountCond.isSatisfiedBy(screening));
    }

    private Money calculateDiscountedFee() {
        switch (movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountedFee();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountedFee();
            case NONE_DISCOUNT:
                return calculateNoneDiscountedFee();
        }

        throw new IllegalArgumentException();
    }

    private Money calculateAmountDiscountedFee() {
        return discountAmount;
    }

    private Money calculatePercentDiscountedFee() {
        return fee.times(discountPercent);
    }

    private Money calculateNoneDiscountedFee() {
        return Money.ZERO;
    }

/*
    public MovieType getMovieType() {
        return movieType;
    }

    public Money getFee() {
        return fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return Collections.unmodifiableList(discountConditions);
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }
*/

}
