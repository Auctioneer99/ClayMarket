import Keycloak from "keycloak-js";
import routes from "./routes";

var { host } = routes;

let initOptions = {
  url: `http://localhost:${process.env.KEYCLOAK_PORT ?? 8080}/auth`,
  realm: process.env.KEYCLOAK_REALM ?? "master",
  clientId: process.env.KEYCLOAK_VUE_CLIENT ?? "client",
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
      return keycloak.login({ redirectUri: host + url });
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
