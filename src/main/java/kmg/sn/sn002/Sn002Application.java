package kmg.sn.sn002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * マラソン日記分析プロトタイプの起動クラス
 * <p>
 * 本パッケージ配下の機能パッケージをすべてコンポーネントスキャンの対象とする。
 * </p>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@SpringBootApplication
public class Sn002Application {

    /**
     * アプリケーションを起動する。
     *
     * @since 0.1.0
     *
     * @param args
     *             起動引数
     */
    public static void main(final String[] args) {

        SpringApplication.run(Sn002Application.class, args);

    }

    /**
     * デフォルトコンストラクタ
     *
     * @since 0.1.0
     */
    public Sn002Application() {

        // 処理なし
    }

}
