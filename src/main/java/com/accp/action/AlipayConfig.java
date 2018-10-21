package com.accp.action;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id ="2016092200569515";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDXBn5um1JurZnYhQUQR1j6g48QlFg2NZxCXR28+HmvLT57wGyQAp5UjGZSBMMyqa/UtDwpUFZDJG6q9iQuttNX2tYk6XDdE0m2i27cxTrmBy1/Dxr9ZUe5DxEpBRQt8ZllyGB/nV/xQUH87lA1M1R/pcibMgaPBYo+I4Vh/B+MPM0HA9TiScf7aLVtmvjXGKm2w4fQQRMpIUBpxSa0u0RvCaABLbr1Qs5qFBCJmDbiqXTPNiECx6IiA1A3HmWX0Jts/jM8QL8Pt9AHCV1u7t5MtGN3TqOdpc9BgN7eupQO0PcA9ZcCghIF8g9Q4pFCGkgUokE4eLK9L65z/wvDP1iBAgMBAAECggEBAKNrPAuz4CJdrd7wubh1gRpjggeHtsL8W5XUTxWfgluwdxx2Ugvg8ZQwYFNVa0TF0exGTrLXa7f7qGAmUblvGZBbsQS8phpe3lbuAYOoIetQ6TL3t/t9TdVHrjMOuRdx1rOUZkKWyKQChLRGKo9EQ6P/y0an7nQkMbyoImclxpQ8/IfTKxsC0RWp0BI+uWh2D2isF83NvfHVzlBUMy9Qdg7PCw2UxtrSb0IDWRnMQZPjnahXNIS/ZYaGRJJmj+NCI79lZFQGnuNz/YO1OKVRITR533VBSKQgbZw3vfj5VnC0o2j6QZ8RF/8XATtBQ1T/sP6CHnLZAH+Gw9ezTVYnL0ECgYEA8iJDe9UsE4DhZBr0wMExnfhjTH1F9VsYkqKYz5w8lxdvJDCW6dskZn+4IyFDGqBpA5wuLrNZZ2CuQeyQ0Y7QaaA8a5GTjXsZUxOsLnKT43Cw0tJVVRgm+HK+ZcBzdx2Xb3kLQsVqTbyyRcKnEm3Vfyt1wakNs/ES/+CB5iAnAvMCgYEA41bQXmfqPtZ+kjomM0dpRFQRcoklU0Kf/e0nOTndI2/BKoA+4kqXE4TI1SmkKamYbTDJInBjEytbFZDOsn6BWdc8dOOcEtrVaqecW/8u80PSHv/CIyfIREfdjv1Df2i9FeSwdnupCoO5VIW/0e/3c85ZVRndXjqujQglC+5RS7sCgYBptdPIiHTJvwan8azRSoci9IJFrpuQVskPm7UjTo6VWEHJhv0b8/ScWz5E+AyX31h5nwH6mYp6u5bYaTOAid0rgC1guRm2NvwDbR9K1/MA5P4NzI48rGK3LUE6ox7F7kFjBXGJIS8b6TnbgvP188W103+BoRC+co1c8ONFWNwvSQKBgC6WPcD63n/eCLYCgI2FlsbPy3uDK0jyoEKy9JS/jNeUMSt6eGh7DJaNYXJ9RAzdmkTV+IG8MjFdcx7qO9FMJ0m318XEVtluSsm+a0ZW9tIXFdoQY0I9BscnSvngYJKdbhIseRTupmdnMvVlKzfkSvtKT/gmgryqndZ80sqtHa+9AoGBAO1sNgnX7cN2gmWQovUnHP7OL6Mfn92uBGGIScEvqgAEL46I9BjOO9rWVP4SX5nJJlqOuASZNuJ9QoNFn2fL5/T/1zeORmvxHmMO6XOSPUAkAHtxlmQgELYSEjazk58119ud6XGMQLWh3vIp5QAobtoXkq2VP8TFHRxKI4AozBRI"; 
			;	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1wZ+bptSbq2Z2IUFEEdY+oOPEJRYNjWcQl0dvPh5ry0+e8BskAKeVIxmUgTDMqmv1LQ8KVBWQyRuqvYkLrbTV9rWJOlw3RNJtotu3MU65gctfw8a/WVHuQ8RKQUULfGZZchgf51f8UFB/O5QNTNUf6XImzIGjwWKPiOFYfwfjDzNBwPU4knH+2i1bZr41xiptsOH0EETKSFAacUmtLtEbwmgAS269ULOahQQiZg24ql0zzYhAseiIgNQNx5ll9CbbP4zPEC/D7fQBwldbu7eTLRjd06jnaXPQYDe3rqUDtD3APWXAoISBfIPUOKRQhpIFKJBOHiyvS+uc/8Lwz9YgQIDAQAB";
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://127.0.0.1:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1:8080/c/getMyGoldnotes?num=1&size=3";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl="https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

