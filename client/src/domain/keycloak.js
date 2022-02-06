import Keycloak from "keycloak-js";

let initOptions = {
  url: `http://localhost:${process.env.KEYCLOAK_PORT ?? 8080}/auth`,
  realm: process.env.KEYCLOAK_REALM ?? "master",
  clientId: process.env.KEYCLOAK_VUE_CLIENT ?? "client",
  onLoad: "login-required",
};

let keycloak = Keycloak(initOptions);

keycloak
  .init({ onLoad: initOptions.onLoad })
  .then((auth) => {
    if (auth == false) {
      window.location.reload();
    } else {
      console.log("Authenticated");
    }

    setInterval(() => {
      keycloak
        .updateToken(70)
        .then((refreshed) => {
          if (refreshed) {
            console.log("Token refreshed" + refreshed);
          } else {
            console.log(
              "Token not refreshed, valid for " +
                Math.round(
                  keycloak.tokenParsed.exp +
                    keycloak.timeSkew -
                    new Date().getTime() / 1000
                ) +
                " seconds"
            );
          }
        })
        .catch(() => {
          console.log("Failed to refresh token");
        });
    }, 6000);
  })
  .catch(() => {
    console.log("Authenticated Failed");
  });

export default keycloak;
