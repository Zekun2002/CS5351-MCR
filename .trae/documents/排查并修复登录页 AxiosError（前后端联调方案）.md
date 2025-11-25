## 可能原因
- 后端未启动：前端 `devServer` 代理到 `http://localhost:8080`，后端不运行会导致网络错误（AxiosError）。
- 代理目标端口不一致：前端 `vue.config.js:39` 指向 8080；若后端改了端口，会报错。
- 数据库不可用或配置错误：后端启动后接口报 500；见 `ruoyi-admin/application-druid.yml`。
- 令牌/路径不匹配：前端以 `/dev-api` 为前缀，后端 `application.yml:120` 也配置了 `pathMapping: /dev-api`，当前匹配正常。

## 我已确认的配置
- 前端：`VUE_APP_BASE_API = '/dev-api'`（`.env.development:8`），代理到 `http://localhost:8080`（`vue.config.js:39`）。
- 后端端口：`server.port=8080`（`ruoyi-admin/application.yml:19`）。
- 登录接口：`POST /login`（`SysLoginController.java:48`）。

## 处理方案
1. 启动后端服务（任选其一）：
   - 在根目录：`mvn -pl ruoyi-admin -am spring-boot:run`
   - 或运行打包的 `ruoyi-admin/target/ruoyi-admin.jar`；或执行 `bin/run.bat`
2. 数据库检查：
   - 确认 MySQL 正在运行，且库/账号与 `application-druid.yml` 一致（`ry-aux3`、`root/123123`）。
3. 前端验证：
   - 浏览器打开 `http://localhost:80`，在控制台 Network 检查 `POST /dev-api/login`：
     - 如果是 `Network Error`：后端/端口不通；
     - 如果是 `5xx/4xx`：看响应体中的 `msg`，按错误处理（例如数据库/认证）。
4. 端口/代理对齐：
   - 若后端不是 8080，更新 `ruoyi-ui/vue.config.js` 的 `proxy.target` 与实际端口一致。

## 备选调整（按需）
- 添加一个健康检查接口或在登录页显示简要的后端状态提示（如“后端未连接”），提升体验。
- 在前端请求错误拦截里进一步输出响应体以便定位。

## 执行与验证
- 我将先启动后端并联调登录接口；如需变更代理端口，我会修改 `vue.config.js` 后重启前端，确保登录恢复。