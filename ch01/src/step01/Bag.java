package step01;

/** 관람객 소지품 가방 */
public class Bag {
    
    private Long amount; // 현금
    private Invitation invitation; // 초대장(이벤트에 당첨된 경우만 소지)
    private Ticket ticket;

    public Bag(long amount) {
        this(null, amount); // 이벤트에 당첨되지 않은 관람객의 경우
    }

    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }


    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
