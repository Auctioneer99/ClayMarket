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
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
