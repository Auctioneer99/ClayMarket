<template>
  <table border="0" align="right" width="90%" cellpadding="0" cellspacing="0">
    <tr>
      <td>
        <table border="0" align="right" width="100%">
          <tr>
            <td align="center" bgcolor="#cccccc">
              <form action="auto.phtml">
                <table>
                  <tr>
                    <td align="right"><font size="-2">Логин:</font></td>
                    <td align="left">
                      <input
                        type="text"
                        style="width: 60; height: 20"
                        name="login"
                      />
                    </td>
                  </tr>

                  <tr>
                    <td align="right"><font size="-2">Пароль:</font></td>
                    <td align="left">
                      <input
                        type="password"
                        style="width: 60; height: 20"
                        name="pass"
                      />
                    </td>
                  </tr>

                  <input type="submit" value="ok" style="height: 20" />
                </table>
              </form>
            </td>
          </tr>
        </table>
      </td>
      <td colspan="4" align="center" bgcolor="#ccccff">
        <font face="Arial" size="+3">
          <i><b>Магазин глины</b></i>
        </font>
      </td>
    </tr>
    <tr>
      <td align="center" bgcolor="#aaddff" width="20%">
        <router-link to="/catalog"><b>Каталог</b></router-link>
      </td>
      <td align="center" bgcolor="#ddaaff" width="20%">
        <router-link to="/basket"><b>Корзина</b></router-link>
      </td>
      <td align="center" bgcolor="#aaaaff" width="20%">
        <router-link to="/register"><b>Регистрация</b></router-link>
      </td>
      <td align="center" bgcolor="#ffaaff" width="20%">
        <router-link to="/order"><b>Заказ</b></router-link>
      </td>
      <td align="center" bgcolor="#aaffee" width="20%">
        <router-link to="/exit"><b>Выход</b></router-link>
      </td>
    </tr>
  </table>
  <router-view />
  <br />
  <hr />
  <br />
  <router-link to="/"><b>На главную страницу</b></router-link>
</template>

<script>
  export default {
    name: "App",
    components: {},
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
