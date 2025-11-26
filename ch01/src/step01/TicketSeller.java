package step01;

/**
 * 판매원: 초대장을 티켓으로 교환해 주거나 판매
 */
public class TicketSeller {

    private TicketOffice ticketOffice; // 일하는 매표소

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
}
