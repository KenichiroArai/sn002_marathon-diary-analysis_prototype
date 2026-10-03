import type { NextConfig } from "next";

const isDev = process.env.NODE_ENV === "development";

/** 開発時に /api/** を転送する Spring Boot の URL */
const backendUrl = process.env.BACKEND_URL ?? "http://localhost:8080";

// rewrites と output: "export" は同時に使えないため、開発時と本番ビルド時で切り替える
const nextConfig: NextConfig = isDev
  ? {
      async rewrites() {
        return [
          {
            source: "/api/:path*",
            destination: `${backendUrl}/api/:path*`,
          },
        ];
      },
    }
  : {
      output: "export",
      images: { unoptimized: true },
    };

export default nextConfig;
