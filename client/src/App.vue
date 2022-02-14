<template>
  <div>
    <table
      border="0"
      align="right"
      width="100%"
      cellpadding="0"
      cellspacing="0"
    >
      <tr>
        <td colspan="6" align="center" bgcolor="#ccccff">
          <b>Магазин глины</b>
        </td>
      </tr>
      <tr>
        <td align="center" bgcolor="#aaddff">
          <router-link to="/catalog"><b>Каталог</b></router-link>
        </td>
        <td align="center" bgcolor="#ddaaff">
          <router-link to="/basket"><b>Корзина</b></router-link>
        </td>
        <td align="center" bgcolor="#ffaaff">
          <router-link to="/orders"><b>Заказ</b></router-link>
        </td>
        <td align="center" bgcolor="#ffaaff">
          <router-link to="/statistics"><b>Статистика</b></router-link>
        </td>
        <td align="center" bgcolor="#aaaaff">
          <a href="#"><b v-on:click="login">Войти</b></a>
        </td>
        <td align="center" bgcolor="#aaaaff">
          <a href="#"><b v-on:click="register">Регистрация</b></a>
        </td>
        <td align="center" bgcolor="#aaffee">
          <a href="#"><b v-on:click="logout">Выход</b></a>
        </td>
      </tr>
    </table>
  </div>
  <router-view />
  <br />
  <hr />
  <br />
  <router-link to="/"><b>На главную страницу</b></router-link>
</template>

<script>
  import keycloak from "./domain/keycloak.js";

  export default {
    name: "App",
    methods: {
      login() {
        keycloak.login(this.$router.currentRoute.value.fullPath);
      },
      logout() {
        keycloak.logout();
      },
      register() {
        keycloak.register();
      },
    },
  };
</script>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
