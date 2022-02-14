package oneNote;

public class ConcreteHandler2 extends Handler {

    @Override
    protected Level getHandlerLevel() {
        return new Level(2);
    }

    @Override
    public Response response(Request request) {
        System.out.println("该请求由ConcreteHandler2处理");
        return new Response("响应结果2");
    }


}
