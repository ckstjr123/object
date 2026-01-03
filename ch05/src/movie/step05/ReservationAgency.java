package movie.step05;

import money.Money;
import movie.Customer;

public class ReservationAgency {

//    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
//        boolean discountable = checkDiscountable(screening);
//        Money fee = calculateFee(screening, discountable, audienceCount);
//        return createReservation(screening, customer, audienceCount, fee);
//    }

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return createReservation(screening, customer, audienceCount, fee);
    }

//    private boolean checkDiscountable(Screening screening) {
//        return screening.getMovie().getDiscountConditions().stream()
//                .anyMatch(discountCond -> discountCond.isDiscountable(screening));
//    }

/*
    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie().getDiscountConditions().stream()
                .anyMatch(discountCond -> isDiscountable(discountCond, screening));
    }

    private boolean isDiscountable(DiscountCondition discountCond, Screening screening) {
        if (discountCond.getType() == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(discountCond, screening);
        }

        return isSatisfiedBySequence(discountCond, screening);
    }

    private boolean isSatisfiedByPeriod(DiscountCondition discountCond, Screening screening) {
        return screening.getWhenScreened().getDayOfWeek().equals(discountCond.getDayOfWeek()) &&
                discountCond.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                discountCond.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }

    private boolean isSatisfiedBySequence(DiscountCondition discountCond, Screening screening) {
        return discountCond.getSequence() == screening.getSequence();
    }
*/

//    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
//        if (discountable) {
//            return screening.getMovie().getFee()
//                    .minus(calculateDiscountedFee(screening.getMovie()))
//                    .times(audienceCount);
//        }
//
//        return screening.getMovie().getFee();
//    }

/*
    private Money calculateDiscountedFee(Movie movie) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountedFee(movie);
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountedFee(movie);
            case NONE_DISCOUNT:
                return calculateNoneDiscountedFee(movie);
        }

        throw new IllegalArgumentException();
    }

    private Money calculateAmountDiscountedFee(Movie movie) {
        return movie.getDiscountAmount();
    }

    private Money calculatePercentDiscountedFee(Movie movie) {
        return movie.getFee().times(movie.getDiscountPercent());
    }

    private Money calculateNoneDiscountedFee(Movie movie) {
        return Money.ZERO;
    }
*/

    private Reservation createReservation(Screening screening,
                                          Customer customer, int audienceCount, Money fee) {
        return new Reservation(customer, screening, fee, audienceCount);
    }

}
