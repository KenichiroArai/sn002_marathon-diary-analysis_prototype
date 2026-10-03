package kmg.sn.sn002.sample.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kmg.sn.sn002.sample.application.service.HelloService;
import kmg.sn.sn002.sample.presentation.dto.HelloResponse;

/**
 * Hello のコントローラ（配線確認用のサンプル）
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@RestController
@RequestMapping("/api/sample")
public class HelloController {

    /**
     * Hello サービス
     *
     * @since 0.1.0
     */
    private final HelloService helloService;

    /**
     * コンストラクタ
     *
     * @since 0.1.0
     *
     * @param helloService
     *                     Hello サービス
     */
    public HelloController(final HelloService helloService) {

        this.helloService = helloService;

    }

    /**
     * Hello のメッセージを返す。
     *
     * @since 0.1.0
     *
     * @return Hello のレスポンス
     */
    @GetMapping("/hello")
    public HelloResponse getHello() {

        HelloResponse result = null;

        /* メッセージの取得 */
        final String message = this.helloService.getHelloMessage();

        /* レスポンスの作成 */
        result = new HelloResponse(message);

        return result;

    }

}
