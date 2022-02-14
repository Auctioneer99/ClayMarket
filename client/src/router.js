import { createWebHistory, createRouter } from "vue-router";

var routes = [
  {
    path: "/",
    name: "home",
    component: () => import("./views/Home.vue"),
  },
  {
    path: "/catalog",
    name: "catalog",
    component: () => import("./views/Catalog.vue"),
  },
  {
    path: "/showcase",
    name: "showcase",
    component: () => import("./views/Showcase.vue"),
    props: (route) => ({ id: route.query.id, type: route.query.type }),
  },
  {
    path: "/basket",
    name: "basket",
    component: () => import("./views/Basket.vue"),
  },
  {
    path: "/orders",
    name: "orders",
    component: () => import("./views/Orders.vue"),
  },
  {
    path: "/statistics",
    name: "statistics",
    component: () => import("./views/Statistics.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
