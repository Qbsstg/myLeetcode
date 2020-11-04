package oneNote.duty;

public abstract class AbstractClerk {

    private AbstractClerk superior = null;
    protected String type;

    public void setSuperior(AbstractClerk abstractClerk) {
        this.superior = abstractClerk;
    }

    public void approveRequest(BorrowRequest request) {
        if (this.getLimit() >= request.getMoney()) {
            System.out.println(this.getType() + "同意借款请求");
        }else {
            if (this.superior != null){
                this.superior.approveRequest(request);
            }else {
                System.out.println("没有人能够同意借款请求");
            }
        }
    }

    public abstract int getLimit();

    public String getType() {
        return type;
    }
}
