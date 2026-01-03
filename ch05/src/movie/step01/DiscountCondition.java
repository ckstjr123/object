package movie.step01;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 변경에 취약한 클래스(코드 수정 이유가 많은 클래스)
 *  - 새로운 할인 조건 추가 시 if ~ else문 수정해야 함
 *  - 기간 조건을 판단하는 로직이 변경되는 경우
 *  - 순번 조건을 판단하는 로직이 변경되는 경우
 *  → 낮은 응집도(서로 연관없는 기능이나 데이터가 한 클래스 내에 모여있음)
 */
public class DiscountCondition {

    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isSatisfiedBy(Screening screening) {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }

        return isSatisfiedBySequence(screening);
    }

    private boolean isSatisfiedByPeriod(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0;
    }

    private boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }

}
