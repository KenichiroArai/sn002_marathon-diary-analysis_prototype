"use client";

import { useEffect, useState } from "react";

import { apiGet } from "@/lib/api/apiClient";

import type { HelloResponse } from "./types";

export function HelloMessage() {
  const [message, setMessage] = useState<string>("読み込み中...");

  useEffect(() => {
    apiGet<HelloResponse>("/api/sample/hello")
      .then((response) => setMessage(response.message))
      .catch((error: unknown) => setMessage(error instanceof Error ? error.message : String(error)));
  }, []);

  return <p data-testid="hello-message">{message}</p>;
}
