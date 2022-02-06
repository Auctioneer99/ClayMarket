import { createApp, h } from "vue";
import App from "./App.vue";
import router from "./router.js";
import keycloak from "./domain/keycloak";

const app = createApp(h(App, { props: { keycloak: keycloak } }));

app.use(router);

app.mount("#app");
