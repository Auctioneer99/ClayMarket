import { createApp, h } from "vue";
import App from "./App.vue";
import router from "./router.js";
import keycloak from "./domain/keycloak";

(async () => {
  const app = createApp(h(App));

  app.use(router);
  await keycloak.init();
  app.mount("#app");
})();
