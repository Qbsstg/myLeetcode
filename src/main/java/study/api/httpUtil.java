package study.api;

/**
 * @author: Qbss
 * @date: 2024/5/17
 * @desc:
 */

public class httpUtil {

    // public String getAccessToken(boolean forceRefresh) throws Exception {
    //     if (!forceRefresh && !this.getWxMpConfigStorage().isAccessTokenExpired()) {
    //         return this.getWxMpConfigStorage().getAccessToken();
    //     }
    //
    //     Lock lock = this.getWxMpConfigStorage().getAccessTokenLock();
    //     long timeOutMillis = System.currentTimeMillis() + 3000;
    //     boolean locked = false;
    //     try {
    //         do {
    //             if (!forceRefresh && !this.getWxMpConfigStorage().isAccessTokenExpired()) {
    //                 return this.getWxMpConfigStorage().getAccessToken();
    //             }
    //             locked = lock.tryLock(100, TimeUnit.MILLISECONDS);
    //             if (!locked && System.currentTimeMillis() > timeOutMillis) {
    //                 throw new InterruptedException("获取accessToken超时：获取时间超时");
    //             }
    //         } while (!locked);
    //
    //         String response;
    //         if (getWxMpConfigStorage().isStableAccessToken()) {
    //             response = doGetStableAccessTokenRequest(forceRefresh);
    //         } else {
    //             response = doGetAccessTokenRequest();
    //         }
    //         return extractAccessToken(response);
    //     } catch (IOException | InterruptedException e) {
    //         throw new Exception(e);
    //     } finally {
    //         if (locked) {
    //             lock.unlock();
    //         }
    //     }
    // }
    //
    //
    // protected <T, E> T executeInternal(RequestExecutor<T, E> executor, String uri, E data, boolean doNotAutoRefresh) throws Exception {
    //     // 数据脱敏处理
    //     // E dataForLog = DataUtils.handleDataWithSecret(data);
    //     E dataForLog = data;
    //
    //     if (uri.contains("access_token=")) {
    //         throw new IllegalArgumentException("uri参数中不允许有access_token: " + uri);
    //     }
    //
    //     String accessToken = getAccessToken(false);
    //     String uriWithAccessToken = uri + (uri.contains("?") ? "&" : "?") + "access_token=" + accessToken;
    //
    //     try {
    //         T result = executor.execute(uriWithAccessToken, data, WxType.MP);
    //         // log.debug("\n【请求地址】: {}\n【请求参数】：{}\n【响应数据】：{}", uriWithAccessToken, dataForLog, result);
    //         return result;
    //     } catch (Exception e) {
    //         WxError error = e.getError();
    //         if (WxConsts.ACCESS_TOKEN_ERROR_CODES.contains(error.getErrorCode())) {
    //             // 强制设置wxMpConfigStorage它的access token过期了，这样在下一次请求里就会刷新access token
    //             Lock lock = this.getWxMpConfigStorage().getAccessTokenLock();
    //             lock.lock();
    //             try {
    //                 if (StringUtils.equals(this.getWxMpConfigStorage().getAccessToken(), accessToken)) {
    //                     this.getWxMpConfigStorage().expireAccessToken();
    //                 }
    //             } catch (Exception ex) {
    //                 this.getWxMpConfigStorage().expireAccessToken();
    //             } finally {
    //                 lock.unlock();
    //             }
    //             if (this.getWxMpConfigStorage().autoRefreshToken() && !doNotAutoRefresh) {
    //                 log.warn("即将重新获取新的access_token，错误代码：{}，错误信息：{}", error.getErrorCode(), error.getErrorMsg());
    //                 //下一次不再自动重试
    //                 //当小程序误调用第三方平台专属接口时,第三方无法使用小程序的access token,如果可以继续自动获取token会导致无限循环重试,直到栈溢出
    //                 return this.executeInternal(executor, uri, data, true);
    //             }
    //         }
    //
    //         if (error.getErrorCode() != 0) {
    //             log.warn("\n【请求地址】: {}\n【请求参数】：{}\n【错误信息】：{}", uriWithAccessToken, dataForLog, error);
    //             throw new Exception(error, e);
    //         }
    //         return null;
    //     } catch (IOException e) {
    //         log.warn("\n【请求地址】: {}\n【请求参数】：{}\n【异常信息】：{}", uriWithAccessToken, dataForLog, e.getMessage());
    //         throw new WxErrorException(e);
    //     }
    // }

}
