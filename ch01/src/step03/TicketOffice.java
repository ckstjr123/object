package step03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 매표소 */
public class TicketOffice {

    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }


    // TicketOffice에서 Audience에 대한 의존성이 추가됨.
    // 로직 캡슐화를 통해 TicketOffice의 자율성은 높아졌지만, 전체 설계 관점에선 결합도가 상승했음.
    // 트레이드오프: TicketOffice의 자율성 ↔ Audience에 대한 결합도 낮추기
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
