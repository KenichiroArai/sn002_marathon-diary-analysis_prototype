package kmg.sn.sn002.sample.presentation.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import kmg.sn.sn002.sample.application.service.HelloService;

/**
 * {@link HelloController} のテスト
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@WebMvcTest(HelloController.class)
@SuppressWarnings({
    "nls",
})
public class HelloControllerTest {

    /**
     * MockMvc
     *
     * @since 0.1.0
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Hello サービスのモック
     *
     * @since 0.1.0
     */
    @MockitoBean
    private HelloService helloService;

    /**
     * デフォルトコンストラクタ
     *
     * @since 0.1.0
     */
    public HelloControllerTest() {

        // 処理なし
    }

    /**
     * getHello メソッドのテスト - 正常系:Hello のメッセージを JSON で返す場合
     *
     * @since 0.1.0
     *
     * @throws Exception
     *                   MockMvc の実行で例外が発生した場合
     */
    @Test
    public void testGetHello_normalMessage() throws Exception {

        /* 期待値の定義 */
        final int    expectedStatus  = 200;
        final String expectedContent = "{\"message\":\"Hello World\"}";

        /* 準備 */
        Mockito.when(this.helloService.getHelloMessage()).thenReturn("Hello World");

        /* テスト対象の実行 */
        final MvcResult testResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/sample/hello")).andReturn();

        /* 検証の準備 */
        final int    actualStatus  = testResult.getResponse().getStatus();
        final String actualContent = testResult.getResponse().getContentAsString();

        /* 検証の実施 */
        Assertions.assertEquals(expectedStatus, actualStatus, "ステータスが一致しません");
        Assertions.assertEquals(expectedContent, actualContent, "レスポンスが一致しません");

    }

}
