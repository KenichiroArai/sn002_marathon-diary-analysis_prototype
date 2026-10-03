package kmg.sn.sn002;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

/**
 * {@link Sn002Application} のテスト
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
public class Sn002ApplicationTest {

    /**
     * デフォルトコンストラクタ
     *
     * @since 0.1.0
     */
    public Sn002ApplicationTest() {

        // 処理なし
    }

    /**
     * コンストラクタ メソッドのテスト - 正常系:インスタンスが生成される場合
     *
     * @since 0.1.0
     */
    @Test
    public void testConstructor_normalInstance() {

        /* 期待値の定義 */

        /* 準備 */

        /* テスト対象の実行 */
        final Sn002Application testTarget = new Sn002Application();

        /* 検証の準備 */
        final Sn002Application actualTarget = testTarget;

        /* 検証の実施 */
        Assertions.assertInstanceOf(Sn002Application.class, actualTarget, "インスタンスが生成されていません");

    }

    /**
     * main メソッドのテスト - 正常系:SpringApplication.run が起動引数で呼び出される場合
     *
     * @since 0.1.0
     */
    @Test
    public void testMain_normalRun() {

        /* 期待値の定義 */
        final String[] expectedArgs = {
            "--server.port=0",
        };

        /* 準備 */
        try (MockedStatic<SpringApplication> testMockSpringApplication = Mockito.mockStatic(SpringApplication.class)) {

            /* テスト対象の実行 */
            Sn002Application.main(expectedArgs);

            /* 検証の準備 */

            /* 検証の実施 */
            testMockSpringApplication.verify(() -> SpringApplication.run(Sn002Application.class, expectedArgs));

        }

    }

}
