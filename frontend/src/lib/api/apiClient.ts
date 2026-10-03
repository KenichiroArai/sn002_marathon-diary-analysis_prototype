/**
 * API の GET リクエストを送信し、JSON のレスポンスを返す。
 *
 * パスは同一オリジンの /api/** を指定する（開発時は Next.js が Spring Boot に転送する）。
 */
export async function apiGet<T>(path: string): Promise<T> {
  const response = await fetch(path, { headers: { Accept: "application/json" } });
  if (!response.ok) {
    throw new Error(`API の呼び出しに失敗しました: ${response.status} ${path}`);
  }
  return (await response.json()) as T;
}
