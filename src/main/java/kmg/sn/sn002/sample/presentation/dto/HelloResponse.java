package kmg.sn.sn002.sample.presentation.dto;

/**
 * Hello のレスポンス
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
public class HelloResponse {

    /**
     * メッセージ
     *
     * @since 0.1.0
     */
    private final String message;

    /**
     * コンストラクタ
     *
     * @since 0.1.0
     *
     * @param message
     *                メッセージ
     */
    public HelloResponse(final String message) {

        this.message = message;

    }

    /**
     * メッセージを返す。
     *
     * @since 0.1.0
     *
     * @return メッセージ
     */
    public String getMessage() {

        final String result = this.message;
        return result;

    }

}
