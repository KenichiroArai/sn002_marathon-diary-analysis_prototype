package kmg.sn.sn002.sample.application.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link HelloServiceImpl} のテスト
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class HelloServiceImplTest {

    /**
     * デフォルトコンストラクタ
     *
     * @since 0.1.0
     */
    public HelloServiceImplTest() {

        // 処理なし
    }

    /**
     * getHelloMessage メソッドのテスト - 正常系:Hello のメッセージを返す場合
     *
     * @since 0.1.0
     */
    @Test
    public void testGetHelloMessage_normalMessage() {

        /* 期待値の定義 */
        final String expectedMessage = "Hello World";

        /* 準備 */
        final HelloServiceImpl testTarget = new HelloServiceImpl();

        /* テスト対象の実行 */
        final String testResult = testTarget.getHelloMessage();

        /* 検証の準備 */
        final String actualMessage = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }

}
