package oneNote;

public class ConcreteHandler1 extends Handler {

    @Override
    protected Level getHandlerLevel() {
        return new Level(1);
    }
    @Override
    public Response response(Request request) {
        System.out.println("该请求由ConcreteHandler1处理");
        return new Response("响应结果1");
    }

}
