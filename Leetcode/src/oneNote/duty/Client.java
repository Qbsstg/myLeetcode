package oneNote.duty;

public class Client {
    public static void main(String[] args) {
        AbstractClerk clerk = new Clerk();
        AbstractClerk leader = new Leader();
        AbstractClerk manager = new Manager();

        clerk.setSuperior(leader);
        leader.setSuperior(manager);

        clerk.approveRequest(new BorrowRequest(2000));

    }
}
