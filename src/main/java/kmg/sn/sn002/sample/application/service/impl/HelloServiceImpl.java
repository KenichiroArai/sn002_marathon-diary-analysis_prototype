package kmg.sn.sn002.sample.application.service.impl;

import org.springframework.stereotype.Service;

import kmg.sn.sn002.sample.application.service.HelloService;

/**
 * Hello サービスの実装
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@Service
public class HelloServiceImpl implements HelloService {

    /**
     * Hello のメッセージ
     *
     * @since 0.1.0
     */
    private static final String HELLO_MESSAGE = "Hello World"; //$NON-NLS-1$

    /**
     * デフォルトコンストラクタ
     *
     * @since 0.1.0
     */
    public HelloServiceImpl() {

        // 処理なし
    }

    /**
     * Hello のメッセージを返す。
     *
     * @since 0.1.0
     *
     * @return Hello のメッセージ
     */
    @Override
    public String getHelloMessage() {

        final String result = HelloServiceImpl.HELLO_MESSAGE;
        return result;

    }

}
