package oneNote;

public class ConcreteHandler3 extends Handler{

    @Override
    protected Level getHandlerLevel() {
        return new Level(3);
    }

    @Override
    public Response response(Request request) {
        System.out.println("该请求由ConcreteHandler3处理");
        return new Response("响应结果3");
    }

}
