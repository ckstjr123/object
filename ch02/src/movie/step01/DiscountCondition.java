package movie.step01;

/** 할인 조건 */
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
