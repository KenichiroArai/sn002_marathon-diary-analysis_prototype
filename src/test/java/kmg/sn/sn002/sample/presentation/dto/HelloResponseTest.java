package kmg.sn.sn002.sample.presentation.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link HelloResponse} のテスト
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
public class HelloResponseTest {

    /**
     * デフォルトコンストラクタ
     *
     * @since 0.1.0
     */
    public HelloResponseTest() {

        // 処理なし
    }

    /**
     * getMessage メソッドのテスト - 正常系:コンストラクタで指定したメッセージを返す場合
     *
     * @since 0.1.0
     */
    @Test
    public void testGetMessage_normalMessage() {

        /* 期待値の定義 */
        final String expectedMessage = "Hello World";

        /* 準備 */
        final HelloResponse testTarget = new HelloResponse("Hello World");

        /* テスト対象の実行 */
        final String testResult = testTarget.getMessage();

        /* 検証の準備 */
        final String actualMessage = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }

}
