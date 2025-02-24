import { type RouteConfig, index, route } from "@react-router/dev/routes";

export default [
  index("routes/home.tsx"),
  route("/use-effect", "routes/use-effect.tsx"),
  route("/use-context", "routes/use-context.tsx"),
  route("/use-memo", "routes/use-memo.tsx"),
  route("/memo", "routes/memo.tsx"),
  route("/forward-ref", "routes/forward-ref.tsx"),
  route("/error-boundary", "routes/error-boundary.tsx"),
] satisfies RouteConfig;
