import Keycloak from "keycloak-js";
import routes from "./routes";

var { self } = routes;

let initOptions = {
  url: `http://${process.env.VUE_APP_KEYCLOAK_HOST ?? "localhost"}:${
    process.env.VUE_APP_KEYCLOAK_PORT ?? 8080
  }/auth`,
  realm: process.env.VUE_APP_KEYCLOAK_REALM ?? "master",
  clientId: process.env.VUE_APP_KEYCLOAK_CLIENT ?? "client",
  //onLoad: "check-sso", //"login-required",
};

let keycloak = Keycloak(initOptions);

export default {
  init() {
    return keycloak.init({ onLoad: initOptions.onLoad });
  },
  updateToken() {
    keycloak.updateToken(70);
  },
  login(url) {
    if (keycloak.authenticated == false) {
      return keycloak.login({ redirectUri: self + url });
    }
    this.updateToken();
  },
  logout() {
    keycloak.logout();
  },
  register() {
    keycloak.register();
    this.updateToken();
  },
  getToken() {
    return "Bearer " + keycloak.token;
  },
};
