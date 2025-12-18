package movie.step01.pricing;

import movie.step01.DiscountCondition;
import movie.step01.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 기간 조건
 */
public class PeriodCondition implements DiscountCondition {

    private DayOfWeek dayOfWeek; // 상영 요일
    private LocalTime startTime; // 상영 시작 시간
    private LocalTime endTime; // 상영 종료 시간

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}
