package oneNote.duty;

public class Clerk extends AbstractClerk{
    public Clerk(){
        super.type = "职员";
    }

    @Override
    public int getLimit() {
        return 5000;
    }
}
