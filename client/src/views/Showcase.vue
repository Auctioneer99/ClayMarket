<template>
  <table border="1" width="100%" align="right">
    <tr v-for="item in items" :key="item.id">
      <td align="center">
        <img
          width="200"
          :src="`images/${item.image}`"
          :alt="`${item.name}`"
          border="0"
        />
        <button v-on:click="addToBasket(item.id)">Положить в корзину</button>
      </td>

      <td>
        <table>
          <tr>
            <td align="right">Поставщики:</td>
            <td>
              <li v-for="supplier in item.suppliers" :key="supplier.id">
                {{ supplier.name }}
              </li>
            </td>
          </tr>
          <tr>
            <td align="right">Название:</td>
            <td>{{ item.name }}</td>
          </tr>
          <tr>
            <td align="right">Категория:</td>
            <td>{{ item.category.name }}</td>
          </tr>
          <tr>
            <td align="right">Цена:</td>
            <td>{{ item.price }}</td>
          </tr>
          <tr>
            <td align="right">Масса:</td>
            <td>{{ item.weight }}</td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</template>

<script>
  import service from "../domain/clayMarketService.js";
  import keycloak from "../domain/keycloak.js";

  export default {
    data() {
      return {
        items: [],
      };
    },
    props: ["type", "id"],
    async beforeMount() {
      this.items = await service.getItems(this.type, this.id);
    },
    methods: {
      addToBasket: function (id) {
        keycloak.login(this.$router.currentRoute.value.fullPath);
        service.addToBasket(id);
      },
    },
  };
</script>

<style></style>
