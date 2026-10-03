# marathon-diary-analysis prototype

マラソン日記分析のプロトタイプ（Web システム）である。

## 概要

Spring Boot（バックエンド）と Next.js（フロントエンド）を 1 つのリポジトリで管理する。

- 本番: Next.js を静的エクスポートし、Spring Boot の jar に同梱する。Spring Boot 1 プロセスで画面と REST API を配信する
- 開発: Spring Boot（8080）を Eclipse からデバッグ起動し、Next.js の開発サーバー（3000）から `/api/**` を Spring Boot に転送する（CORS 設定は不要）

```text
[本番]  Browser ──> Spring Boot :8080 ──> static/（Next.js の静的エクスポート）
                                    └──> /api/**（REST API）

[開発]  Browser ──> Next.js dev :3000 ──(/api/** を転送)──> Spring Boot :8080
```

技術スタック:

- Java 25 / Spring Boot 4.1.1（Spring MVC）
- Maven（frontend-maven-plugin で Next.js のビルドも実行）
- Next.js 16 / React 19 / TypeScript
- 基盤ライブラリ: kmg-core / kmg-fund
- テスト: JUnit 5 / MockMvc / JaCoCo（行・分岐カバレッジ 100%）

## 必要環境

- JDK 25
- Maven 3.9 以降
- kmg-core / kmg-fund（GitHub Packages から取得するため `~/.m2/settings.xml` に認証情報が必要）
- Node.js は不要（Maven がプロジェクト内の `frontend/node/` に Node 24 を取得する）。`npm run dev` を手動で使う場合はローカルの Node 24 などを使う

## ビルド

```bash
# フロントエンドのビルド + テスト（JaCoCo 100% チェック）+ 実行可能 jar の作成
mvn clean package

# フロントエンドのビルドを省略してテストのみ実行
mvn test -Dskip.frontend=true
```

- 成果物: `target/sn002_marathon-diary-analysis_prototype-0.1.0.jar`（実行可能 jar）
- カバレッジレポート: `target/site/jacoco/index.html`（`target/jacoco.exec` は Eclipse のカバレッジ表示と共有できる）

## 起動

### 本番構成（jar）

```bash
java -jar target/sn002_marathon-diary-analysis_prototype-0.1.0.jar
```

`http://localhost:8080/` を開くと Hello World が表示される。

### 開発構成

1. Spring Boot を起動する（Eclipse からデバッグ起動、または `mvn spring-boot:run -Dskip.frontend=true`）
2. Next.js の開発サーバーを起動する

   ```bash
   cd frontend
   npm install
   npm run dev
   ```

3. `http://localhost:3000/` を開く（画面はホットリロード、`/api/**` は 8080 に転送される）

転送先は環境変数 `BACKEND_URL` で変更できる（既定値: `http://localhost:8080`）。

## エンドポイント

| メソッド | パス | 内容 |
| --- | --- | --- |
| GET | `/api/sample/hello` | サンプル挨拶（`{"message":"Hello World"}`） |

## Eclipse の設定

1. 「ファイル」→「インポート」→「Maven」→「既存 Maven プロジェクト」で本フォルダをインポートする
2. 初回は「実行」→「Maven ビルド...」でゴール `package` を実行し、フロントエンドのビルド結果を `target/classes/static` に配置する（Eclipse の自動ビルドでは npm は実行されない）
3. 「デバッグ」→「sn002_marathon-diary-analysis_prototype」で Spring Boot を起動する（起動構成は `eclipse/sn002_marathon-diary-analysis_prototype.launch`）。または `Sn002Application` を右クリック→「デバッグ」→「Java アプリケーション」
4. 画面を修正しながら確認する場合は、上記「開発構成」の手順で `npm run dev` を併用する

Eclipse のビルド・パス（`.classpath`）は Git で管理している。
内容は m2e が `pom.xml` から生成する標準の構成（JRE は `JavaSE-25`、出力先は `target/classes` / `target/test-classes`）で、PC 固有の絶対パスは含まない。
`.settings/` と `bin/` は Git で管理しない。

- `.classpath` は手で編集しない。`pom.xml` を変更した場合は「Maven」→「プロジェクトの更新」で反映する
- 「プロジェクトの更新」の実行後は `.classpath` に差分が出ていないことを確認する（差分が出た場合は意図した変更か確認してからコミットする）

## ディレクトリ構成

```text
pom.xml
src/main/java/kmg/sn/sn002/
  Sn002Application.java      # 起動クラス
  sample/                    # 機能パッケージ（配線確認用のサンプル）
    presentation/            # Web や REST API などの UI 系層（controller / dto）
    application/             # ユースケースや業務ロジック層（service / service.impl）
    domain/                  # 共通ロジック、ドメインモデル層
    infrastructure/          # 基盤となる処理層
    repository/              # Dao などのデータアクセス層
src/main/resources/
  application.yml
src/test/java/kmg/sn/sn002/  # main と同じ構成
frontend/                    # Next.js（App Router）+ TypeScript
  src/app/                   # ルーティング（layout.tsx / page.tsx）
  src/components/            # 共通 UI
  src/features/              # 機能単位（バックエンドの機能パッケージ名と揃える）
    sample/
  src/lib/api/               # API クライアント
  src/types/                 # 共通の型
eclipse/                     # Eclipse の起動構成
```

## ライセンス

[MIT License](./LICENSE)
