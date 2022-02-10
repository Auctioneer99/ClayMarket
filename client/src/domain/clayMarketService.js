import $ from "jquery";
import keycloak from "./keycloak";
import routes from "./routes";

const { hostApi } = routes;

export default {
  getCategories: () => {
    return $.ajax({
      url: hostApi + "/category",
    });
  },
  getSuppliers: () => {
    return $.ajax({
      url: hostApi + "/supplier",
    });
  },
  getItems: (type, id) => {
    return $.ajax({
      url: hostApi + `/clay/${type}/${id}`,
    });
  },
  getBasket: () => {
    return $.ajax({
      url: hostApi + "/basket",
      headers: {
        Authorization: keycloak.getToken(),
      },
    });
  },
  addToBasket: (id) => {
    return $.ajax({
      url: hostApi + `/basket/${id}`,
      method: "POST",
      headers: {
        Authorization: keycloak.getToken(),
      },
      contentType: "application/json; charset=utf-8",
    });
  },
  removeFromBasket: (id) => {
    return $.ajax({
      url: hostApi + `/basket/${id}`,
      method: "DELETE",
      headers: {
        Authorization: keycloak.getToken(),
      },
      contentType: "application/json; charset=utf-8",
    });
  },
  orderBasket: () => {
    return $.ajax({
      url: hostApi + "/basket/order",
      method: "POST",
      headers: {
        Authorization: keycloak.getToken(),
      },
      contentType: "application/json; charset=utf-8",
    });
  },
  getOrders: () => {
    return $.ajax({
      url: hostApi + "/basket/order",
      method: "GET",
      headers: {
        Authorization: keycloak.getToken(),
      },
      contentType: "application/json; charset=utf-8",
    });
  },
};
