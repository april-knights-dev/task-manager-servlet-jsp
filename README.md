# タスク管理アプリ - 研修課題

このプロジェクトは、JavaのServletとJSPを使用して作成されたシンプルなタスク管理アプリです。研修課題として、段階的に機能を追加し、完全なタスク管理アプリを作成することが目標です。

## 基本構成

- **Servlet**: タスクの追加と一覧表示を処理する`AddTaskServlet`と`ListTasksServlet`
- **JSP**: タスクリストを表示する`listTasks.jsp`
- **モデル**: タスクを表す`Task`クラス
- **DAO**: タスクのデータを管理する`TaskDAO`クラス

## 環境構築

### 必要なもの

- JDK 1.8以上
- Apache Maven
- Apache Tomcat（または他のServletコンテナ）

### セットアップ手順

1. リポジトリをクローンします。

   ```bash
   git clone https://github.com/april-knights-dev/task-manager-servlet-jsp.git
   cd task-manager-servlet-jsp
   ```

2. Mavenプロジェクトをビルドします。

   ```bash
   mvn clean install
   ```

3. 生成されたWARファイルをTomcatの`webapps`ディレクトリに配置します。

4. Tomcatを起動します。

5. ブラウザで以下のURLにアクセスします。

   ```
   http://localhost:8080/listTasks.jsp
   ```

## 開発ステップ

### STEP 1: 基本機能の実装とバグ修正

1. タスク削除機能の追加
   - `DeleteTaskServlet`を作成し、タスクを削除する機能を実装してください。
   - `listTasks.jsp`に削除ボタンを追加し、`DeleteTaskServlet`にリクエストを送信するようにしてください。

2. 日付表示形式の改善
   - `Task`クラスの`getDueDate()`メソッドを修正し、日付を「yyyy年MM月dd日」形式で返すようにしてください。

3. NullPointerExceptionの修正
   - `AddTaskServlet`で、日付が入力されていない場合にNullPointerExceptionが発生する問題を修正してください。

4. Servletを使用したリクエストハンドリング
   - `web.xml`を修正し、`/listTasks`へのリクエストを`ListTasksServlet`にマッピングしてください。
   - アプリケーションのエントリーポイントを`http://localhost:8080/task-manager/listTasks`に変更してください。

ヒント：

- Servletの作成方法は`AddTaskServlet`を参考にしてください。
- 日付のフォーマットには`SimpleDateFormat`クラスを使用できます。
- NullPointerExceptionを避けるには、日付が入力されていない場合の処理を追加してください。
- `web.xml`ファイルでServletマッピングを設定するか、`@WebServlet`アノテーションを使用してマッピングを行うことができます。
- `welcome-file-list`の設定を更新して、デフォルトでServletにリダイレクトするようにすることもできます。

### STEP 2: UIの改善

1. Bootstrap導入
   - プロジェクトにBootstrapを導入し、UIを改善してください。
   - `listTasks.jsp`のスタイルをBootstrapを使用して整えてください。

2. タスク入力フォームの改善
   - 現在のインラインフォームを、モーダルウィンドウを使用した入力フォームに変更してください。

3. ページネーション機能の追加
   - タスクリストにページネーション機能を追加してください。

ヒント：

- Bootstrapは、CDNを使用して簡単に導入できます。
- モーダルウィンドウの実装には、Bootstrapのモーダルコンポーネントを使用できます。
- ページネーションには、Bootstrapのページネーションコンポーネントと、サーバーサイドでの処理が必要です。

### STEP 3: 高度な機能の追加

1. タスクステータス更新機能
   - タスクのステータス（未完了/完了）を更新できる機能を追加してください。
   - `Task`クラス、`TaskDAO`、`listTasks.jsp`を修正し、新しい`UpdateTaskStatusServlet`を作成してください。

2. タスクの編集機能
   - 既存のタスクを編集できる機能を追加してください。
   - 編集用のモーダルウィンドウを作成し、`UpdateTaskServlet`を実装してください。

3. タスクのソート機能
   - タスクリストを日付順や優先度順でソートできる機能を追加してください。

ヒント：

- ステータス更新には、チェックボックスとJavaScriptを使用すると良いでしょう。
- 編集機能は、追加機能と似た実装になりますが、既存のデータを表示し、更新する必要があります。
- ソート機能は、クエリパラメータを使用してサーバーサイドで実装できます。

### STEP 4: セキュリティと最適化

1. 入力値のバリデーション
   - すべての入力フィールドに適切なバリデーションを追加してください。
   - サーバーサイドとクライアントサイドの両方でバリデーションを実装してください。

2. XSS対策
   - ユーザー入力をエスケープし、XSS攻撃を防ぐ対策を実装してください。

3. パフォーマンス最適化
   - データベース接続プールを実装し、パフォーマンスを向上させてください。

ヒント：

- バリデーションには、JavaScriptとサーバーサイドでのチェックを組み合わせてください。
- XSS対策には、JSTLの`<c:out>`タグやApache Commons Langの`StringEscapeUtils`を使用できます。
- コネクションプールには、Apache Commons DBCPなどのライブラリを使用できます。

これらのステップを完了することで、基本的な機能を持つシンプルなタスク管理アプリから、セキュアで使いやすい完全なタスク管理アプリへと進化させることができます。各ステップで学んだことを活かし、さらなる機能の追加や改善にチャレンジしてください。

## 依存関係

- Servlet API
- JSP API
- JSTL

## ライセンス

このプロジェクトはMITライセンスの下で提供されています。
